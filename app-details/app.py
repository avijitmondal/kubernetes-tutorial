from flask import Flask
from flask import request
from flask import jsonify
from flask import send_from_directory
import os
import socket

app = Flask(__name__)
APP_PORT = 0


@app.route('/favicon.ico')
def favicon():
    return send_from_directory(os.path.join(app.root_path, 'static'),
                               'static/favicon.ico', mimetype='image/vnd.microsoft.icon')


@app.route('/', methods=['GET'])
def default():
    message = {'status': 'OK!'}

    resp = jsonify(message)
    resp.status_code = 200
    return resp


@app.route('/details', methods=['GET'])
def share_details():
    message = {'hostname': socket.gethostname(), 'ip': request.remote_addr, 'port': APP_PORT}

    resp = jsonify(message)
    resp.status_code = 200
    return resp


@app.route('/error', methods=['GET'])
def error():
    message = {'error': 'some error occurred'}

    resp = jsonify(message)
    resp.status_code = 500
    return resp


if __name__ == '__main__':
    # Bind to APP_PORT if defined, otherwise default to 5000.
    APP_PORT = int(os.environ.get('APP_PORT', 5000))
    app.run(host='0.0.0.0', port=APP_PORT)
