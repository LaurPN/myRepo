import json
from flask import Flask, request
from auth_svc import access
from auth import validate, register

server = Flask(__name__)


@server.route("/login", methods=["POST"])
def login():
    token, err = access.login(request)

    if not err:
        return token
    else:
        return err


@server.route("/register", methods=["POST"])
def regsiter():
    access, err = validate.token(request)

    if err:
        return err

    access = json.loads(access)

    if not (access["role"] == "admin"):
        return "invalid credentials", 401

    error, res = register.reg(request)

    if error:
        return error
    else:
        return res


if __name__ == "__main__":
    server.run(host="0.0.0.0", port=8080, debug=True)
