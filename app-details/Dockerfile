FROM python:alpine3.13
LABEL maintainer="avijitmondal38@gmail.com"

RUN pip3 install --no-cache-dir --upgrade pip && \
    pip3 install flask

WORKDIR /app
ADD app.py app.py

ENTRYPOINT ["python3","app.py"]
