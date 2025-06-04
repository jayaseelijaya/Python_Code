import json
import time
import subprocess
import boto3
import sys
import datetime

from botocore.exceptions import ClientError

cf_org = sys.argv[1]
cf_space = sys.argv[2]
cf_usn = sys.argv[3]
cf_pwd = sys.argv[4]
home_path = sys.argv[5]
vault_service_instance = sys.argv[6]
api_endpoint = sys.argv[7]

# Importing common vault & IAM token module
sys.path.insert(0, home_path + "/Test/Automation/python/vault_details_iam_token")
from vault_details_iam_token import generate_iam_details
from vault_details_iam_token import vault_details

vault_data = vault_details(cf_org, cf_space, cf_usn, cf_pwd, vault_service_instance, api_endpoint)

service_name = vault_data['service_name']
region_name = vault_data['region_name']
table_name = vault_data['table_name']
aws_access_key = vault_data['aws_access_key']
aws_secret_key = vault_data['aws_secret_key']
aws_session_token = vault_data['aws_session_token']
kafka_topic_delete_base_url = vault_data['kafka_topic_delete_base_url']

with open(home_path + '/Test/Automation/python/proposition_service_test/proposition_details.json','r') as dataset:
    proposition_details = json.load(dataset)

ref_base_topic_name = proposition_details['Organization Name'] + "." + proposition_details['Department Name']

# Extract data from teat case 1 response
with open(home_path + '/Test/Automation/python/proposition_service_test/proposition_response_details.json','r') as dataset:
    proposition_response_details = json.load(dataset)

proposition_id = proposition_response_details["proposition_details"]["proposition_id"]

start_time = datetime.datetime.now()

test_result = {
    "Test Name" : "Verification data in MDM",
    "Test Discription" : "Verify the proposition service have stored valid data in MDM",
    "Test Result" : "",
    "Start Time" : "",
    "End Time" : "",
    "Total Time" : ""
}

try:
    start_time = datetime.datetime.now()

    dynamo_client = boto3.resource(service_name = service_name, region_name = region_name,
                  aws_access_key_id = aws_access_key,
                  aws_secret_access_key = aws_secret_key, aws_session_token =aws_session_token)
    product_table = dynamo_client.Table(table_name)

    response = product_table.get_item(Key={"propositionId": proposition_id})
    response_details = response['Item']
    if response_details["baseTopicName"] == ref_base_topic_name:
        print("Verification of data in MDM passed")
        try:
            delete_response = product_table.delete_item(Key={"propositionId": proposition_id})
            response_str = str(response_details)
            response_str_corrected = response_str.replace("'", "\"")
            response_data_json = json.loads(response_str_corrected)
            basetopicname = str(response_data_json["baseTopicName"])
            requesttopicname = str(response_data_json["requestTopicName"])
            resulttopicname = str(response_data_json["resultTopicName"])
            try:
                kafka_topic_delete_final_url = kafka_topic_delete_base_url + "baseTopicName=" + basetopicname + "&requestTopicName=" + requesttopicname + "&resultTopicName=" + resulttopicname
                response = requests.request(method = "POST", url = kafka_topic_delete_final_url)
                response_text = response.text
                url_data = json.loads(response_text)
                print("Kafka Topics deleted after test", url_data)
            except Exception as ex:
                print(ex)
                print("Error while deleting Kafka Topics created for test")
                print("Verification of data in MDM failed")
                test_result['Test Result'] = "Fail"
            print("Proposition deleted after test", delete_response)
            test_result['Test Result'] = "Pass"
        except Exception as ex:
            print(ex)
            print("Error while deleting proposition created for test")
            print("Verification of data in MDM failed")
            test_result['Test Result'] = "Fail"
    else:
        print("Verification of data in MDM failed")
        test_result['Test Result'] = "Fail"

    end_time = datetime.datetime.now()

except:
    print("Verification of data in MDM failed. Exception raised")
    test_result['Test Result'] = "Fail"
    end_time = datetime.datetime.now()

total_time = end_time - start_time
test_result["Start Time"] = str(start_time)
test_result["End Time"] = str(end_time)
test_result["Total Time"] = str(total_time)

with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
    feedsjson.write(json.dumps(test_result))
    feedsjson.write(",")