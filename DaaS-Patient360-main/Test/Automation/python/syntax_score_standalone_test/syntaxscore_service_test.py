import json
import time
import datetime
import requests
import sys
import copy

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

syntaxscore_input_bundle = vault_data['syntaxscore_input_bundle']
syntaxscore_calculator = vault_data['syntaxscore_calculator']

with open(home_path + '/Test/Automation/python/syntax_score_standalone_test/flow_details.json','r') as dataset:
    jsondata = json.load(dataset)

flow_1_name  = jsondata['flow_1_name']
flow_1_score = jsondata['flow_1_score']
flow_2_name  = jsondata['flow_2_name']
flow_2_score = jsondata['flow_2_score']
flow_3_name  = jsondata['flow_3_name']
flow_3_score = jsondata['flow_3_score']
flow_4_name  = jsondata['flow_4_name']
flow_4_score = jsondata['flow_4_score']
flow_5_name  = jsondata['flow_5_name']
flow_5_score = jsondata['flow_5_score']

post_call_header = {
    'accept': 'application/fhir+json; fhirVersion=4.0',
    'Content-Type': 'application/fhir+json; fhirVersion=4.0',
    'api-version' : '1'
}

test_result = {
    "Test Name" : "Verification Syntaxscore service is up & running",
    "Test Discription" : "Verify That Syntaxscore service will generate right syntax score for flow",
    "Test Result" : "",
    "Start Time" : "",
    "End Time" : "",
    "Total Time" : ""
}

with open(flow_1_name + '.json','r') as dataset:
    flow1_data = json.load(dataset)

with open(flow_2_name + '.json','r') as dataset:
    flow2_data = json.load(dataset)

with open(flow_3_name + '.json','r') as dataset:
    flow3_data = json.load(dataset)

with open(flow_4_name + '.json','r') as dataset:
    flow4_data = json.load(dataset)

with open(flow_5_name + '.json','r') as dataset:
    flow5_data = json.load(dataset)

def calcualate_syntaxscore(flow_name, flowdata, flowscore, status):
    try:
        start_time = datetime.datetime.now()

        json_name = flow_name
        json_name = copy.deepcopy(test_result)
        json_name["Test Discription"] = "Verify That Syntaxscore service will generate right syntax score for flow :-" + flow_name
        try:
            response = requests.request(method = "POST", url = syntaxscore_input_bundle, headers = post_call_header, json = flowdata)
            text = response.text            
        except:
            print("Error in getting bundle")

        if response.status_code != 200:
            print("Verification Syntaxscore service bundle generation API is failed ")
            json_name['Test Result'] = "Fail"
        else:
            try:
                response_score = requests.request(method = "POST", url = syntaxscore_calculator, headers = post_call_header, data = text)
                data = json.loads(response_score.text)
            except:
                print("Error in getting score")

            calculated_score = data["entry"][1]["resource"]["valueQuantity"]["value"]
            print("Calcualted Score",calculated_score)
            print("Expected score", flowscore)
            calculated_score_str = str(calculated_score)
            flowscore_str = str(flowscore)

            if response_score.status_code != 200:
                print("Verification Syntaxscore service calcualtion API is failed ")
                json_name['Test Result'] = "Fail"
            elif calculated_score_str ==  flowscore_str:
                print("Verification Syntaxscore service is passed for flow :-", flow_name)
                json_name['Test Result'] = "Pass"
            else:
                print("Verification Syntaxscore service is failed for flow :-", flow_name)
                json_name['Test Result'] = "Fail"

        end_time = datetime.datetime.now()

    except:
        print("Verification Syntaxscore service is failed. Exception raised")
        json_name['Test Result'] = "Fail"

    end_time = datetime.datetime.now()

    total_time = end_time - start_time
    json_name["Start Time"] = str(start_time)
    json_name["End Time"]   = str(end_time)
    json_name["Total Time"] = str(total_time)

    if status == "running":
        with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(json_name))
            feedsjson.write(",")
    if status =="finish":
        with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(json_name))

calcualate_syntaxscore(flow_1_name, flow1_data, flow_1_score, status = "running")
calcualate_syntaxscore(flow_2_name, flow2_data, flow_2_score, status = "running")
calcualate_syntaxscore(flow_3_name, flow3_data, flow_3_score, status = "running")
calcualate_syntaxscore(flow_4_name, flow4_data, flow_4_score, status = "running")
calcualate_syntaxscore(flow_5_name, flow5_data, flow_5_score, status = "running")