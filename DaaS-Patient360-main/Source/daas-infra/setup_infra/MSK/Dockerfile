FROM ubuntu:20.04
RUN apt-get update
RUN apt-get upgrade -y
RUN apt-get install -y python3-pip
RUN apt install curl -y

EXPOSE 8000
COPY ./requirements.txt .
COPY /createKafkaTopic.py /createKafkaTopic.py
RUN pip install -r requirements.txt
CMD ["uvicorn", "--host", "0.0.0.0", "--port", "8000", "createKafkaTopic:app"]