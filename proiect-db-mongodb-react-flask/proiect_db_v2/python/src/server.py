from flask import Flask, request
from flask_pymongo import PyMongo
from bson.json_util import dumps, loads
from bson.objectid import ObjectId
from flask_cors import CORS

server = Flask(__name__)
server.config["MONGO_URI"] = "mongodb://127.0.0.1:27017/proiect_db"
mongo = PyMongo(server)
cors = CORS(server)

db = mongo.db


@server.route("/create", methods=["POST"])
def create():
    req = request.get_json()

    repair_name = None
    repair_cost = None
    repair_work_hours = None
    repair_description = ''

    if not ('repair_name' or 'repair_cost' or 'repair_work_hours') in req:
        return "missing values", 401

    if req.get('repair_description') != None:
        repair_description = req.get('repair_description')

    repair_name = req.get('repair_name')
    repair_cost = req.get('repair_cost')
    repair_work_hours = req.get('repair_work_hours')

    insert_dict = dict(repair_name=repair_name, repair_description=repair_description,
                       repair_cost=repair_cost, repair_work_hours=repair_work_hours)

    try:
        db.repairs.insert_one(insert_dict)
    except:
        return "could not add document", 500
    return "successful", 200


@ server.route("/read", methods=["GET"])
def read():
    repairs = list(db.repairs.find())
    for x in repairs:
        x['_id'] = str(ObjectId(x.get('_id')))

    repairs = dumps(repairs)
    return repairs, 200


@ server.route("/update/<id>", methods=["PATCH"])
def update(id):
    req = request.get_json()

    repair_name = None
    repair_cost = None
    repair_work_hours = None
    repair_description = ''

    if not ('repair_name' or 'repair_cost' or 'repair_work_hours') in req:
        return "missing values", 401

    if req.get('repair_description') != None:
        repair_description = req.get('repair_description')

    repair_name = req.get('repair_name')
    repair_cost = req.get('repair_cost')
    repair_work_hours = req.get('repair_work_hours')

    try:
        repair = db.repairs.find_one({'_id': ObjectId(id)})

        insert_dict = dict(repair_name=repair_name, repair_description=repair_description,
                           repair_cost=repair_cost, repair_work_hours=repair_work_hours)

        repair = db.repairs.find_one({'_id': ObjectId(id)})
        if not repair:
            return "object not found", 200
        db.repairs.update_one({'_id': ObjectId(id)}, {'$set': insert_dict})
    except:
        return "Object could not be updated", 400
    return "successful", 200


@ server.route("/delete/<id>", methods=["DELETE"])
def delete(id):
    try:
        if not db.repairs.find_one({'_id': ObjectId(id)}):
            return "object not found", 200
        db.repairs.delete_one({'_id': ObjectId(id)})
    except:
        return "Object could not be deleted", 400
    return f"object {id} deleted", 200


if __name__ == "__main__":
    server.run(host="0.0.0.0", port=5500)
