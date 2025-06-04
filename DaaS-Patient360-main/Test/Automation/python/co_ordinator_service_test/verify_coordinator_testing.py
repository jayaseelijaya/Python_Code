import boto3
import json
import random
import time
import sys
import datetime
import kafka
import requests
import os
import shlex, subprocess
import copy

from kafka import KafkaProducer
from json import loads
from json import dumps
from kafka import KafkaConsumer
from kafka import TopicPartition
from botocore.exceptions import ClientError
from kafka.errors import NoBrokersAvailable

home_path = sys.argv[1]
cf_org = sys.argv[2]
cf_space = sys.argv[3]
cf_usn = sys.argv[4]
cf_pwd = sys.argv[5]
vault_service_instance = sys.argv[6]
api_endpoint = sys.argv[7]

sys.path.insert(0, home_path + "/Test/Automation/python/daas_vault_details")
from Vault_details_daas import vault_details

# Reading Vault Details
vault_data = vault_details(cf_org, cf_space, cf_usn, cf_pwd, vault_service_instance, api_endpoint)
first_endpoint = vault_data['MSKbroker1']
second_endpoint = vault_data['MSKbroker2']
third_endpoint = vault_data['MSKbroker3']
syntaxscore_input = vault_data['syntaxscore_input_bundle']
bootstrap_server = [first_endpoint,second_endpoint,third_endpoint]

json_result = {
"Test Name" : "Verification of co-ordinator service ",
"Test Discription" : "This test case is to verify the co-ordinator service loading data into result topic.",
"Test Result" : "",
"Start Time" : "",
"End Time" : "",
"Total Time" : ""
}

start_time_total = datetime.datetime.now()
try:
    directory = os.getcwd()
    path=directory+"/sample_template_syntaxscore/"
    data=random.choice(["flow_1.json","flow_2.json","flow_3.json","flow_4.json","flow_5.json"])

    with open (home_path + "/Test/Automation/python/co_ordinator_service_test/config.json",'r') as topic_name:
        jsonData = json.load(topic_name)
        request_topic = jsonData['request_topic']
        result_topic = jsonData['result_topic']
        profileName = jsonData['profileName']
        orgId = jsonData['orgId']
        propositionId = jsonData['propositionId']
    headers = {
        'api-version': '1',
        'Content-Type': 'application/fhir+json;fhirVersion=4.0',
        'Accept': 'application/fhir+json;fhirVersion=4.0'
    }

    data_file = open(path+data, "rb")
    response = requests.post(syntaxscore_input, headers=headers, json=json.load(data_file))
    output=response.text
    json_data_output = json.loads(output)
    data = json_data_output['entry']
    patient_data = data[0].get('resource')

    consumer = KafkaConsumer(result_topic,
            bootstrap_servers=bootstrap_server,
            auto_offset_reset='latest',
            consumer_timeout_ms=1000,
            enable_auto_commit=False,
            auto_commit_interval_ms=1000,
            value_deserializer=lambda x: loads(x.decode('utf-8')))
    start_time = datetime.datetime.now()
    producer = KafkaProducer(bootstrap_servers=bootstrap_server, value_serializer=lambda x: dumps(x).encode('utf-8'))
    headers_send = [
                ("profileName", bytes(profileName, encoding='utf-8')),
                ("orgId", bytes(orgId, encoding='utf-8')),
                ("propositionId",  bytes(propositionId, encoding='utf-8')),
       ]
    message = producer.send(request_topic, value=json_data_output, headers=headers_send)
    print("Patient data has been published into request topic")
    producer.flush()

    consumer.poll(10)
    time.sleep(5)
    for message in consumer:
        msgdata = message.value
        header_info = message.headers
        msgResponse = json.dumps(msgdata)
        msg  = json.loads(msgResponse)
        entry_data = msg['entry']
        consumed_patient_data = entry_data[0].get('resource')
    if (patient_data == consumed_patient_data):
        print("Verification of co-ordinator service test case is passed")
        json_result['Test Result'] = "Pass"
    else:
        print("Verification of co-ordinator service test case is failed")
        json_result['Test Result'] = "Fail"
    consumer.close() 
    end_time = datetime.datetime.now()
    total_time = end_time - start_time
    json_result["Start Time"] = str(start_time)
    json_result["End Time"] = str(end_time)
    json_result["Total Time"] = str(total_time)
    with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
        feedsjson.write(json.dumps(json_result))
        feedsjson.write(",")
except NoBrokersAvailable as exc:
    print(exc)
    end_time_total = datetime.datetime.now()
    total_time_final = end_time_total - start_time_total
    json_result['Test Result'] = "Fail"
    json_result["Start Time"] = str(start_time_total)
    json_result["End Time"] = str(end_time_total)
    json_result["Total Time"] = str(total_time_final)
    with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
      feedsjson.write(json.dumps(json_result))
      feedsjson.write(",")