FROM ubuntu:20.04
RUN apt-get update
RUN apt-get upgrade -y
RUN apt-get install -y python3-pip
RUN apt install curl -y

EXPOSE 8084
WORKDIR /src
COPY ./requirements.txt .
COPY ./src /src
RUN pip install -r requirements.txt
CMD ["uvicorn", "--host", "0.0.0.0", "--port", "8084", "main:app"]

