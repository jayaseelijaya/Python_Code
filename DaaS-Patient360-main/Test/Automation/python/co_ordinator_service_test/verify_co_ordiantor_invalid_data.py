import boto3
import json
import random
import time
import sys
import datetime
import kafka
import requests
import os
import copy

from json import loads
from kafka import KafkaProducer
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
bootstrap_server = [first_endpoint,second_endpoint,third_endpoint]
with open (home_path + "/Test/Automation/python/co_ordinator_service_test/config.json",'r') as topic_name:
    jsonData = json.load(topic_name)
    request_topic = jsonData['request_topic']
    result_topic = jsonData['result_topic']
    profilename = jsonData['profileName']
    orgid = jsonData['orgId']
    propositionid = jsonData['propositionId']

json_result = {
"Test Name" : "Negative test cases for co-ordinator service ",
"Test Discription" : "This test case is to verify the negative test case for co-ordinator service.",
"Test Result" : "",
"Start Time" : "",
"End Time" : "",
"Total Time" : ""
}

start_time_total = datetime.datetime.now()
try:
    consumer = KafkaConsumer(
            bootstrap_servers=bootstrap_server,
            auto_offset_reset='earliest',
            consumer_timeout_ms=1000,
            enable_auto_commit=False,
            auto_commit_interval_ms=1000,
            value_deserializer=lambda x: loads(x.decode('utf-8')))
    partition = TopicPartition(result_topic, 0)
    consumer.assign([partition])
    consumer.seek_to_end(partition)
    last_offset_value = consumer.position(partition)
    print("Message count in result topic before publishing data:",last_offset_value)

    directory = os.getcwd()
    with open(home_path + "/Test/Automation/python/co_ordinator_service_test/invalid_syntaxscore_bundle.json",'r') as file_data:
        json_data = json.load(file_data)
    start_time = datetime.datetime.now()
    producer = KafkaProducer(bootstrap_servers=bootstrap_server, value_serializer=lambda x: dumps(x).encode('utf-8'))
    headers_send = [
                ("profileName", bytes(profilename, encoding='utf-8')),
                ("orgId", bytes(orgid, encoding='utf-8')),
                ("propositionId",  bytes(propositionid, encoding='utf-8')),
       ]
    message = producer.send(request_topic, value=json_data, headers=headers_send)
    print("Request topic {} produced data successfully ".format(request_topic),"\n")
    producer.flush()

    consumer.poll(10)
    time.sleep(1)
    tp = TopicPartition(result_topic, 0)
    consumer.assign([tp])
    consumer.seek_to_end(tp)
    current_offset_value = consumer.position(tp)
    print("Message count available in result topic after publishing data:", current_offset_value)
    if (last_offset_value == current_offset_value):
        print("Negative test case for co-ordinator service  is passed")
        json_result['Test Result'] = "Pass"
    else:
        print("Negative test case for co-ordinator service test case is failed")
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