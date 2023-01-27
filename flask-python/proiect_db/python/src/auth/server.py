import jwt
import os
import datetime
from flask import Flask, request
from flask_mysqldb import MySQL
import bcrypt
import re
import json

server = Flask(__name__)

# config
server.config["MYSQL_HOST"] = os.environ.get("MYSQL_HOST")
server.config["MYSQL_USER"] = os.environ.get("MYSQL_USER")
server.config["MYSQL_PASSWORD"] = os.environ.get("MYSQL_PASSWORD")
server.config["MYSQL_DB"] = os.environ.get("MYSQL_DB")
server.config["MYSQL_PORT"] = int(os.environ.get("MYSQL_PORT"))

# server.config["MYSQL_HOST"] = 'localhost'
# server.config["MYSQL_USER"] = 'proiect_db_auth_user'
# server.config["MYSQL_PASSWORD"] = 'Auth123'
# server.config["MYSQL_DB"] = 'proiect_db_auth'
# server.config["MYSQL_PORT"] = 3306

mysql = MySQL(server)


def createJWT(username, secret, authz):
    return jwt.encode(
        {
            "username": username,
            "exp": datetime.datetime.now(tz=datetime.timezone.utc) + datetime.timedelta(days=1),
            "iat": datetime.datetime.utcnow(),
            "role": authz
        },
        secret,
        algorithm="HS256"
    )


@server.route("/login", methods=["POST"])
def login():
    auth = request.authorization
    if not auth:
        return "missing credentials", 401

    # check db for username and password
    cursor = mysql.connection.cursor()
    result = cursor.execute(
        "select email, password, authentication_role from user inner join authentication_role on user.authentication_role_id=authentication_role.id where email=%s", (
            auth.username, )
    )

    if result > 0:
        user_row = cursor.fetchone()
        mysql.connection.commit()
        email = user_row[0]
        password = user_row[1].encode('ascii')

        if auth.username != email or not bcrypt.checkpw(auth.password.encode('ascii'), password):
            return "invalid credentials", 401
        else:
            return createJWT(auth.username, os.environ.get("JWT_SECRET"), user_row[2])
            # return createJWT(auth.username, "sarcasm", user_row[2])
    else:
        return "invalide credentials", 401


@server.route("/validate", methods=["POST"])
def validate():
    encoded_jwt = request.headers["Authorization"]

    if not encoded_jwt:
        return "missing credentials 1", 401

    encoded_jwt = encoded_jwt.split(" ")[1]

    try:
        decoded = jwt.decode(
            encoded_jwt, os.environ.get("JWT_SECRET"), algorithms=["HS256"]
            # encoded_jwt, "sarcasm", algorithms=["HS256"]
        )
    except:
        return "not authorized", 403

    return decoded, 200


# @server.route("/register", methods=["POST"])
# def register():
#     if 'email' in request.form and 'password' in request.form:
#         username = request.form['email']
#         password = request.form['password']
#         role = request.form['role']
#         cursor = mysql.connection.cursor()
#         result = cursor.execute(
#             "SELECT email, password FROM user where email=%s", (
#                 username, )
#         )
#         if result > 0:
#             return "account already exists", 401
#         elif not re.match(r'[^@]+@[^@]+\.[^@]+', username):
#             return "invalid email", 401
#         elif not (username and password and role):
#             return "missing credentials, fill in the form", 401
#         else:
#     match role.lower():
#         case "admin":
#             role = 1
#         case "mechanic":
#             role = 2
#         case "accountant":
#             role = 3
#         case _:
#             return "invalid credentials", 401
#     cursor.execute(
#         "INSERT INTO user (email, password, authentication_role_id) VALUES (%s, %s, %s)", (username, bcrypt.hashpw(
#             password.encode('ascii'), bcrypt.gensalt()).decode('ascii'), role)
#     )
#     mysql.connection.commit()
#     return "successful", 200

@server.route("/register", methods=["POST"])
def register():
    req = request.get_json()
    req = json.loads(req)

    username = None
    password = None
    role = None

    if not req:
        return "missing credentials", 401

    if 'email' in req:
        username = req['email']

    if 'password' in req:
        password = req['password']

    if 'role' in req:
        role = req['role']

    if (username == None or password == None or role == None):
        return "missing credentials", 401

    cur = mysql.connection.cursor()
    res = cur.execute(
        "SELECT email, password FROM user where email=%s", (
            username, )
    )

    if res > 0:
        return "account already exists", 401
    elif not re.match(r'[^@]+@[^@]+\.[^@]+', username):
        return "invalid email", 401
    else:
        match role.lower():
            case "admin":
                role = 1
            case "mechanic":
                role = 2
            case "accountant":
                role = 3
            case _:
                return "invalid credentials", 401
        cur.execute(
            "INSERT INTO user (email, password, authentication_role_id) VALUES (%s, %s, %s)", (username, bcrypt.hashpw(
                password.encode('ascii'), bcrypt.gensalt()).decode('ascii'), role)
        )
        mysql.connection.commit()
        return "successful", 200


if __name__ == "__main__":
    server.run("0.0.0.0", port=5000)
