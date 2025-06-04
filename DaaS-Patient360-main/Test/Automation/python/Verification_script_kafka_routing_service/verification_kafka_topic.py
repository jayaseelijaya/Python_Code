import boto3
import json
import random
from json import dumps
import time
import sys
import kafka
import datetime
import copy

from kafka import KafkaProducer
from kafka import KafkaConsumer
from json import loads
from datetime import datetime
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
    "Test Name" : "Verification of kafka topics in mdm ",
    "Test Discription" : "This test case to verify topics name available in mdm and topics created in kafka available for particular propositionid or not.",
    "Test Result" : "",
    "Start Time" : "",
    "End Time" : "",
    "Total Time" : ""
}

# Importing daas vault 
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

start_time_total = datetime.datetime.now()

try:
    dynamo_client = boto3.resource(service_name = service, region_name = region, aws_access_key_id = aws_access_key, aws_secret_access_key = aws_secret_access_key, aws_session_token =aws_token)                     
    table = dynamo_client.Table(table_name)
    response = table.scan()
    item = response['Items']
    if (item != ""):
        try:
            admin_client = kafka.KafkaAdminClient(bootstrap_servers=bootstrap_server)
            topics = admin_client.list_topics()
            list = []
            for i in range(2):
                propositionid = item[i]['propositionId']
                proposition_list = list.append(propositionid)
            for proposition_id in list:
                query_table = table.get_item(Key={"propositionId": proposition_id})
                item = query_table['Item']
                base_topic_name = query_table['Item']['baseTopicName'] 
                request_topic_name = query_table['Item']['requestTopicName']
                result_topic_name = query_table['Item']['resultTopicName']
                
                #Verifying baseTopic is available in kafka
                def base_topic_json(topic):
                    start_time = datetime.datetime.now()
                    base_topic_json_result = copy.deepcopy(json_result)
                    base_topic_json_result['Test Name'] = "Verify the Basetopic is available or not for this proposition_id: " + proposition_id
                    base_topic_json_result['Test Discription'] = "This test case is to verify Basetopic is available -for particular propositionId. "
                    try:
                        if base_topic_name:
                            if base_topic_name in topics:
                                base_topic_json_result['Test Result'] = "Pass"
                            else:
                                base_topic_json_result['Test Result'] = "Fail"
                    except KeyError:
                          base_topic_json_result['Test Result'] = "Fail"
                    end_time = datetime.datetime.now()
                    total_time = end_time - start_time
                    base_topic_json_result["Start Time"] = str(start_time)
                    base_topic_json_result["End Time"] = str(end_time)
                    base_topic_json_result["Total Time"] = str(total_time)        
                    with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
                        feedsjson.write(json.dumps(base_topic_json_result))
                        feedsjson.write(",")
                        
                 #Verifying requestTopic is available in kafka     
                def request_topic_json(topic):
                    start_time = datetime.datetime.now()
                    request_topic_json_report = copy.deepcopy(json_result)
                    request_topic_json_report['Test Name'] = "Verify the requesttopic is available for the proposition_id:" + proposition_id
                    request_topic_json_report['Test Discription'] = "This test case is to verify requesttopic is available for particular propositionId In MDM and kafka topics. "
                    try:
                        if request_topic_name:
                            if request_topic_name in topics:
                               request_topic_json_report['Test Result'] = "Pass"
                            else: 
                               request_topic_json_report['Test Result'] = "Fail"
                    except KeyError:
                           request_topic_json_report['Test Result'] = "Fail"
                    end_time = datetime.datetime.now()
                    total_time = end_time - start_time
                    stime = str(start_time)
                    etime = str(end_time)
                    ttime = str(total_time)
                    request_topic_json_report["Start Time"] = stime
                    request_topic_json_report["End Time"] = etime
                    request_topic_json_report["Total Time"] = ttime  
                    with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
                        feedsjson.write(json.dumps(request_topic_json_report))
                        feedsjson.write(",")
                        
                #Verifying resultTopicName is available in kafka  
                def result_topic_json(topic):
                    start_time = datetime.datetime.now()
                    result_topic_json = copy.deepcopy(json_result)
                    result_topic_json['Test Name'] = "Verify the resulttopic is available for the proposition_id:" + proposition_id
                    result_topic_json['Test Discription'] = "This test case is to verify resulttopic is available for particular propositionId In MDM and kafka topics. "
                    try:
                        if result_topic_name:
                            if result_topic_name in topics:
                                result_topic_json['Test Result'] = "Pass"
                            else:
                               result_topic_json['Test Result'] = "Fail"                                
                    except KeyError:
                           result_topic_json['Test Result'] = "Fail"
                    end_time = datetime.datetime.now()
                    total_time = end_time - start_time
                    result_topic_json["Start Time"] = str(start_time)
                    result_topic_json["End Time"] = str(end_time)
                    result_topic_json["Total Time"] = str(total_time) 
                    with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
                        feedsjson.write(json.dumps(result_topic_json))
                        feedsjson.write(",")
                base_topic_json(base_topic_name)
                request_topic_json(request_topic_name)   
                result_topic_json(result_topic_name)
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
    else:
        print("Data not found")      
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