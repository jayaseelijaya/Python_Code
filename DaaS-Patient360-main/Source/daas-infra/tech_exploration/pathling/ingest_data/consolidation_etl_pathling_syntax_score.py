import base64
import requests
import json
import os
from kafka import KafkaConsumer

dir_pat = os.getcwd()

#insert topic name and url of pathling server
topic_name = [{'topic_name'}]
url_bundle = {url}

headers = {
    'Content-Type': 'application/fhir+json'
}

# Consuming Data from topic
#insert msk broker 
consumer = KafkaConsumer(bootstrap_servers = [{msk_brokers}], auto_offset_reset = 'latest')
consumer.subscribe(topic_name)

while True:
    for msg in consumer:
        if isinstance(msg.value, bytes):
            msg_data = msg.value.decode('utf-8')
            msg_response = json.loads(msg_data)
            # Serializing json
            json_object = json.dumps(msg_response, indent=4)
            resource_type = msgResponse['resourceType']
            if resource_type == 'Bundle':
                response = requests.post(url_bundle, headers = headers, json = msg_response)
                print(response.status_code)