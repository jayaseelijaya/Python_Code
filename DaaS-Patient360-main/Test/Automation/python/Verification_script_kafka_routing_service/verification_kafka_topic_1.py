import boto3
import random
import sys
import datetime
import kafka
import time
import os
import json
import xmltojson
import xmltodict
import random
import shlex, subprocess
import copy

from json import dumps
from json import loads
from kafka import KafkaConsumer
from kafka import KafkaProducer
from botocore.exceptions import ClientError
from kafka.errors import NoBrokersAvailable


cf_org = sys.argv[1]
cf_space = sys.argv[2]
cf_usn = sys.argv[3]
cf_pwd = sys.argv[4]
home_path = sys.argv[5]
vault_service_instance = sys.argv[6]
api_endpoint = sys.argv[7]

json_result = {
    "Test Name" : "Verification of kafka topic 1 ",
    "Test Discription" : "This test case to verify Kafka topic 1 producing and consuming data or not.",
    "Test Result" : "",
    "Start Time" : "",
    "End Time" : "",
    "Total Time" : ""
}

# Importing common vault 
sys.path.insert(0, home_path + "/Test/Automation/python/daas_vault_details")
from Vault_details_daas import vault_details

# Reading Vault Details
vault_data = vault_details(cf_org, cf_space, cf_usn, cf_pwd, vault_service_instance, api_endpoint)
service = vault_data['service_name']
table_name = vault_data['table_name']
region = vault_data['region_name']
aws_access_key = vault_data['aws_access_key']
aws_secret_access_key = vault_data['aws_secret_key']
aws_token = vault_data['aws_session_token']
bootstrap_server = vault_data['msk_endpoint']

start_time_total =  datetime.datetime.now()
try:    
    dynamo_client = boto3.resource(service_name = service,region_name = region, aws_access_key_id = aws_access_key,aws_secret_access_key = aws_secret_access_key, aws_session_token =aws_token)
    table = dynamo_client.Table(table_name)
    response = table.scan()
    item = response['Items']
    if (item != ""):
        try:
            admin_client = kafka.KafkaAdminClient(bootstrap_servers=bootstrap_server)
            topics = admin_client.list_topics()
            list = []
            for i in range(len(item)):
                propositionid = item[i]['propositionId'] 
                proposition_list = list.append(propositionid)
            for proposition_id in list:
                query_table = table.get_item(Key = {"propositionId": proposition_id})
                item = query_table['Item']
                base_topic = query_table['Item']['baseTopicName'] 
                profile_name = query_table['Item']['profileName']
                organization_id = query_table['Item']['organizationId']
                
                # Produce message in Kafka topic 1
                if base_topic in topics:
                    start_time = datetime.datetime.now()
                    producer = KafkaProducer(bootstrap_servers=bootstrap_server, value_serializer=lambda x: dumps(x).encode('utf-8'))
                    with open("syntaxscore_input_bundle.json",'r') as file_data:
                        json_data = json.load(file_data)
                        headers_send = [
                                     ("profileName", bytes(profile_name, encoding='utf-8')),
                                     ("organizationId", bytes(organization_id, encoding='utf-8')),
                                     ("propositionId",  bytes(proposition_id, encoding='utf-8')),
                           ]
                        obj = time.gmtime(0)
                        epoch = time.asctime(obj)
                        curr_time = round(time.time()*1000)
                        message = producer.send(base_topic, value=json_data, headers=headers_send, timestamp_ms=int(curr_time))
                    producer.flush()  
                    
                    #Consume message from Kafka topic 1
                    time.sleep(3)
                    consumer = KafkaConsumer(base_topic,
                        bootstrap_servers=bootstrap_server,
                        auto_offset_reset='earliest',
                        consumer_timeout_ms=1000,
                        enable_auto_commit=False,
                        auto_commit_interval_ms=1000,
                        value_deserializer=lambda x: loads(x.decode('utf-8')))
                    messages = consumer.poll(1)
                    time.sleep(1)
                    messages = consumer.poll(1)
                    for message in consumer:
                        header_info = message.headers
                    kafka_base_topic_json = copy.deepcopy(json_result)
                    kafka_base_topic_json['Test Name'] = "Verify the kafka1 topic1 is producing and consuming message or not" 
                    kafka_base_topic_json['Test Discription'] = "This test case is to verify kafka1 topic1 is producing and consuming message or not"
                    if (header_info == headers_send and json_data == message.value):
                        kafka_base_topic_json['Test Result'] = "Pass"
                    else:
                        kafka_base_topic_json['Test Result'] = "Fail"
                    consumer.close()
                    end_time = datetime.datetime.now()
                    total_time = end_time - start_time
                    kafka_base_topic_json["Start Time"] = str(start_time)
                    kafka_base_topic_json["End Time"] = str(end_time)
                    kafka_base_topic_json["Total Time"] = str(total_time)
                    with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
                        feedsjson.write(json.dumps(kafka_base_topic_json))
                        feedsjson.write(",")
                else:
                   print("kafka topic 1 is not available")
        except NoBrokersAvailable as exc:
            print(exc)
            json_result['Test Result'] = "Fail"
            end_time_total = datetime.datetime.now()
            total_time_final = end_time_total - start_time_total
            json_result["Start Time"] = str(start_time_total)
            json_result["End Time"] = str(end_time_total)
            json_result["Total Time"] = str(total_time_final)
            with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
                feedsjson.write(json.dumps(json_result))
                feedsjson.write(",")
except ClientError as e:
    print(e.response['Error'])
    json_result['Test Result'] = "Fail"
    end_time_total = datetime.datetime.now()
    total_time_final = end_time_total - start_time_total
    json_result["Start Time"] = str(start_time_total)
    json_result["End Time"] = str(end_time_total)
    json_result["Total Time"] = str(total_time_final)
    with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
         feedsjson.write(json.dumps(json_result))
         feedsjson.write(",")