import boto3
import json
import random
import time
import sys
import kafka
import os
from kafka import KafkaProducer
from botocore.exceptions import ClientError
from json import dumps
from json import loads

#insert msk broker and topic name
bootstrap_server =[{msk_brokers}]
base_topic = {topic_name}

# Produce message in Kafka topic
producer = KafkaProducer(bootstrap_servers = bootstrap_server, value_serializer=lambda x: dumps(x).encode('utf-8'))
directory = os.getcwd()

#insert location of syntax score json file
with open(directory+"{syntax_score_data_location}",'r') as file_data:
    json_data = json.load(file_data)
    message = producer.send(base_topic, value=json_data)
    print("kafka topic 1 {} produced data successfully : ".format(base_topic), json_data,"\n")
    print(message)
producer.flush()