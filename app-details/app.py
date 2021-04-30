
from flask import Flask
from flask import redirect
from flask import request
from flask import jsonify
import os
import socket


app = Flask(__name__)
APP_PORT = 0

@app.route('/', methods=['GET'])
def default():
    message = {}
    message['message'] = 'Welcome!'

    resp = jsonify(message)
    resp.status_code = 200
    return resp


@app.route('/details', methods=['GET'])
def shareDetails():
    message = {}
    message['hostname'] = socket.gethostname()
    message['ip'] = request.remote_addr
    message['port'] = APP_PORT

    resp = jsonify(message)
    resp.status_code = 200
    return resp


@app.route('/error', methods=['GET'])
def error():
    message = {}
    message['error'] = 'some error occured'
    
    resp = jsonify(message)
    resp.status_code = 500
    return resp


if __name__ == '__main__':
    # Bind to PORT if defined, otherwise default to 5000.
    APP_PORT = int(os.environ.get('PORT', 5000))
    app.run(host='0.0.0.0', port=APP_PORT)

