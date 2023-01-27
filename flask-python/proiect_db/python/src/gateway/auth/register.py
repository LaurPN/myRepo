import os
import requests
import json


def reg(request):
    if not ('email' and 'password' and 'role') in request.form:
        return ('missing credentials', 401), None

    email = str(request.form['email'])
    password = str(request.form['password'])
    role = str(request.form['role'])

    form_data = dict(email=email, password=password, role=role)

    form_data = json.dumps(form_data)

    response = requests.post(
        f"http://{os.environ.get('PROIECT_DB_AUTH_SVC_ADDRESS')}/register", json=form_data
    )

    if response.status_code == 200:
        return None, ("successful", 200)
    else:
        return (response.text, response.status_code), None
