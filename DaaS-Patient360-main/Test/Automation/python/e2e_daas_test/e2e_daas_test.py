"""Importing Modules."""
import sys
import json
import time
import datetime
import copy
import requests
import psycopg2

CF_ORG = sys.argv[1]
CF_SPACE = sys.argv[2]
CF_USN = sys.argv[3]
CF_PWD = sys.argv[4]
OAUTH2_CLIENT_ID = sys.argv[5]
OAUTH2_CLIENT_PWD = sys.argv[6]
IAM_USN = sys.argv[7]
IAM_PWD = sys.argv[8]
HOME_PATH = sys.argv[9]
VAULT_SERVICE_INSTANCE = sys.argv[10]
API_ENDPOINT = sys.argv[11]

#Importing common vault & IAM token module
sys.path.insert(0, HOME_PATH + "/Test/Automation/python/vault_details_iam_token")
from vault_details_iam_token import generate_iam_details
from vault_details_iam_token import vault_details

print("Starting verification script for E2E test for DaaS")

# Reading Vault Details
print("Extracting Vault Data")
vault_data = vault_details(CF_ORG, CF_SPACE, CF_USN, CF_PWD, VAULT_SERVICE_INSTANCE, API_ENDPOINT)
cdr_r4_url = vault_data['cdr_r4_url']
CF_ORG_id = vault_data['cf_org_id']
data_ingest_simple_resource = vault_data['data_ingest_simple_resource']
data_ingest_bundle_resource = vault_data['data_ingest_bundle_resource']
data_ingest_syntaxscore_resource = vault_data['data_ingest_syntaxscore_resource']
pdb_host_name = vault_data['pdb_host_name']
pdb_username = vault_data['pdb_username']
pdb_passwd = vault_data['pdb_passwd']
pdb_port_number = vault_data['pdb_port_number']
pdb_database_name = vault_data['pdb_database_name']

# #Generate IAM token
access_token = generate_iam_details(
    CF_ORG, CF_SPACE, CF_USN, CF_PWD,
    VAULT_SERVICE_INSTANCE, API_ENDPOINT,
    OAUTH2_CLIENT_ID, OAUTH2_CLIENT_PWD, IAM_USN, IAM_PWD)
print("IAM Token", access_token)

# Creating constant for api-version
API_VERSION = '1'

# Defining Veriables
RESPONSE_SIMPLE_RESOURCE = ""
RESULT_SIMPLE_RESOURCE = ""
TAGS_SIMPLE_RESOURCE = ""
RESPONSE_BUNDLE_RESOURCE = ""
RESULT_BUNDLE_RESOURCE = ""
TAGS_BUNDLE_RESOURCE = ""
RESPONSE_SYNTAXSCORE_RESOURCE = ""
RESULT_SYNTAXSCORE_RESOURCE = ""
TAGS_SYNTAXSCORE_RESOURCE = ""

# Creat CDR R4 URL
cdr_url = cdr_r4_url + "/store/fhir/" + CF_ORG_id + "/"

# Creating Base JSON Structure for Test Result
json_result = {
    "Test Name" : "",
    "Test Discription" : "",
    "Test Result" : "",
    "Start Time" : "",
    "End Time" : "",
    "Total Time" : ""
}

# Adding Header Details for API Call
api_header = {
'Accept': '*/*'
}

# Adding Header Details for CDR Call
cdr_headers = {
'Content-Type': 'application/fhir+json;fhirVersion=4.0',
'Accept': 'application/fhir+json;fhirVersion=4.0',
'Authorization': 'Bearer ' + access_token,
'api-version': API_VERSION
}

# Establishing the Connection with PostgreSQL DB
conn = psycopg2.connect(
   database=pdb_database_name, user=pdb_username,
   password=pdb_passwd, host=pdb_host_name, port= pdb_port_number
)
# Creating a cursor object using the cursor() method
cursor = conn.cursor()

# Executing an MYSQL function using the execute() method
cursor.execute("select version()")

def data_ingest():
    """ Post Simple Resource Data to Kafka by calling API """
    start_time = datetime.datetime.now()
    global RESPONSE_SIMPLE_RESOURCE
    global RESULT_SIMPLE_RESOURCE
    global TAGS_SIMPLE_RESOURCE
    global RESPONSE_BUNDLE_RESOURCE
    global RESULT_BUNDLE_RESOURCE
    global TAGS_BUNDLE_RESOURCE
    global RESPONSE_SYNTAXSCORE_RESOURCE
    global RESULT_SYNTAXSCORE_RESOURCE
    global TAGS_SYNTAXSCORE_RESOURCE
    data_ingestion_result = copy.deepcopy(json_result)
    data_ingestion_result['Test Name'] = "E2E test part data ingestion"
    data_ingestion_result['Test Discription'] = "This part of e2e test verifies data ingestion"
    try:
        RESPONSE_SIMPLE_RESOURCE = requests.request(method = "GET",
        url = data_ingest_simple_resource, headers = api_header, timeout=10)
        RESULT_SIMPLE_RESOURCE = json.loads(RESPONSE_SIMPLE_RESOURCE.text)
        TAGS_SIMPLE_RESOURCE = len(RESULT_SIMPLE_RESOURCE)
        TAGS_SIMPLE_RESOURCE = int(TAGS_SIMPLE_RESOURCE)

        # Post Bundle Resource Data to Kafka by calling API
        RESPONSE_BUNDLE_RESOURCE = requests.request(method = "GET",
        url = data_ingest_bundle_resource, headers = api_header, timeout=10)
        RESULT_BUNDLE_RESOURCE = json.loads(RESPONSE_BUNDLE_RESOURCE.text)
        TAGS_BUNDLE_RESOURCE = len(RESULT_BUNDLE_RESOURCE)
        TAGS_BUNDLE_RESOURCE = int(TAGS_BUNDLE_RESOURCE)

        # Post Syntaxscore Resource Data to Kafka by calling API
        RESPONSE_SYNTAXSCORE_RESOURCE = requests.request(method = "GET",
        url = data_ingest_syntaxscore_resource, headers = api_header, timeout=10)
        RESULT_SYNTAXSCORE_RESOURCE = json.loads(RESPONSE_SYNTAXSCORE_RESOURCE.text)
        TAGS_SYNTAXSCORE_RESOURCE = len(RESULT_SYNTAXSCORE_RESOURCE)
        data_ingestion_result['Test Result'] = "Pass"

        # Add Sleep Time
        print("Adding delay of 120 Seconds")
        time.sleep(120)
    except requests.exceptions.RequestException as err:
        print("Error", err)
        data_ingestion_result['Test Result'] = "Fail"
        print("E2E test part data ingestion failed exception raised")

    end_time = datetime.datetime.now()
    total_time = end_time - start_time
    stime = str(start_time)
    etime = str(end_time)
    ttime = str(total_time)
    data_ingestion_result["Start Time"] = stime
    data_ingestion_result["End Time"] = etime
    data_ingestion_result["Total Time"] = ttime
    with open(HOME_PATH + "/Test/Automation/python/report/json_result.json",
    mode='a+', encoding='utf-8') as feedsjson:
        feedsjson.write(json.dumps(data_ingestion_result))
        feedsjson.write(",")

def cdr_db_verification_basic_resource(tags, resource_type, result_json):
    """ Basic Resource Verification """
    start_time = datetime.datetime.now()
    basic_resource_result = copy.deepcopy(json_result)
    basic_resource_result['Test Name'] = "E2E test part cdr and db verification of basic resource"
    basic_resource_result['Test Discription'] = "This part of e2e test verifies basic resource\
    data added to CDR and uploaded to PostgreSQL DB"
    try:
        for count in range(0,tags):
            if result_json[count]['resourceType'] == resource_type:
                resource_id = result_json[count]['id']
                try:
                    # get data from cdr
                    cdr_url_full = cdr_url + "Patient/" + resource_id
                    response = requests.request(method = "GET",
                    url = cdr_url_full, headers = cdr_headers, timeout=10)

                    # get data from database
                    cursor.execute("select * from public.base_resource where patientid = "
                    + "\'" + resource_id + "\'")
                    data = cursor.fetchall()

                    if response.status_code == 200 and data:
                        basic_resource_result['Test Result'] = "Pass"
                        print("E2E test part CDR + DB verification of basic resource passed")
                    else:
                        basic_resource_result['Test Result'] = "Fail"
                        print("E2E test part CDR + DB verification of basic resource failed")
                except requests.exceptions.RequestException as err:
                    print("Error", err)
                    basic_resource_result['Test Result'] = "Fail"
                    print("E2E test part CDR + DB verification of basic resource \
                    failed exception  raised")
    except ValueError as err:
        print("Error", err)
        basic_resource_result['Test Result'] = "Fail"
        print("E2E test part CDR + DB verification of basic resource failed \
        exception  raised")

    end_time = datetime.datetime.now()
    total_time = end_time - start_time
    stime = str(start_time)
    etime = str(end_time)
    ttime = str(total_time)
    basic_resource_result["Start Time"] = stime
    basic_resource_result["End Time"] = etime
    basic_resource_result["Total Time"] = ttime
    with open(HOME_PATH + "/Test/Automation/python/report/json_result.json",
    mode='a+', encoding='utf-8') as feedsjson:
        feedsjson.write(json.dumps(basic_resource_result))
        feedsjson.write(",")

def cdr_db_verification_bundle_resource(resource_type, result_json):
    """ Bundle Resource Verification """
    start_time = datetime.datetime.now()
    bundle_resource_result = copy.deepcopy(json_result)
    bundle_resource_result['Test Name'] = "E2E test part CDR and DB verification \
    of bundle resource"
    bundle_resource_result['Test Discription'] = "This part of e2e test verifies \
    bundle resource data added to CDR and uploaded to PostgreSQL DB"
    try:
        tags = len(result_json["entry"])
        for count in range(0,tags):
            if result_json['entry'][count]['resource']['resourceType'] == resource_type:
                resource_id = result_json['entry'][count]['resource']['id']
                try:
                    # get data from cdr
                    cdr_url_full = cdr_url + "Patient/" + resource_id
                    response = requests.request(method = "GET",
                    url = cdr_url_full, headers = cdr_headers, timeout=10)

                    # get data from database
                    cursor.execute("select * from public.base_resource where patientid = "
                    + "\'" + resource_id + "\'")
                    data = cursor.fetchall()

                    if response.status_code == 200 and data:
                        bundle_resource_result['Test Result'] = "Pass"
                        print("E2E test part CDR + DB verification of bundle resource passed")
                    else:
                        bundle_resource_result['Test Result'] = "Fail"
                        print("E2E test part CDR + DB verification of bundle resource failed")
                except requests.exceptions.RequestException as err:
                    print("Error", err)
                    bundle_resource_result['Test Result'] = "Fail"
                    print("E2E test part CDR + DB verification of bundle resource failed \
                    exception  raised")
    except ValueError as err:
        print("Error", err)
        bundle_resource_result['Test Result'] = "Fail"
        print("E2E test part CDR + DB verification of bundle resource failed except \
        Exception as errion raised")

    end_time = datetime.datetime.now()
    total_time = end_time - start_time
    stime = str(start_time)
    etime = str(end_time)
    ttime = str(total_time)
    bundle_resource_result["Start Time"] = stime
    bundle_resource_result["End Time"] = etime
    bundle_resource_result["Total Time"] = ttime
    with open(HOME_PATH + "/Test/Automation/python/report/json_result.json",
    mode='a+', encoding='utf-8') as feedsjson:
        feedsjson.write(json.dumps(bundle_resource_result))
        feedsjson.write(",")

def cdr_db_verification_syntaxscore_resource(resource_type, result_json):
    """ Syntaxscore Resource Verification """
    start_time = datetime.datetime.now()
    syntaxscore_resource_result = copy.deepcopy(json_result)
    syntaxscore_resource_result['Test Name'] = "E2E test part CDR and DB verification \
    of Syntaxscore Resource"
    syntaxscore_resource_result['Test Discription'] = "This part of e2e test verifies \
    syntaxscore resource data added to CDR and uploaded to PostgreSQL DB"
    try:
        tags = len(result_json["entry"])
        for count in range(0,tags):
            if result_json['entry'][count]['resource']['resourceType'] == resource_type:
                resource_id = result_json['entry'][count]['resource']['id']
                try:
                    # get data from cdr
                    cdr_url_full = cdr_url + "Patient/" + resource_id
                    response = requests.request(method = "GET",
                    url = cdr_url_full, headers = cdr_headers, timeout=10)

                    # get data from database
                    cursor.execute("select * from public.base_resource where patientid = "
                    + "\'" + resource_id + "\'")
                    data = cursor.fetchall()

                    if response.status_code == 200 and data:
                        syntaxscore_resource_result['Test Result'] = "Pass"
                        print("E2E test part CDR + DB verification of syntaxscore resource passed")
                    else:
                        syntaxscore_resource_result['Test Result'] = "Fail"
                        print("E2E test part CDR + DB verification of syntaxscore resource failed")
                except requests.exceptions.RequestException as err:
                    print("Error", err)
                    syntaxscore_resource_result['Test Result'] = "Fail"
                    print("E2E test part CDR + DB verification of syntaxscore resource \
                    failed exception  raised")
    except ValueError as err:
        print("Error", err)
        syntaxscore_resource_result['Test Result'] = "Fail"
        print("E2E test part CDR + DB verification of syntaxscore resource failed except \
        Exception as errion raised")

    end_time = datetime.datetime.now()
    total_time = end_time - start_time
    stime = str(start_time)
    etime = str(end_time)
    ttime = str(total_time)
    syntaxscore_resource_result["Start Time"] = stime
    syntaxscore_resource_result["End Time"] = etime
    syntaxscore_resource_result["Total Time"] = ttime
    with open(HOME_PATH + "/Test/Automation/python/report/json_result.json",
    mode='a+', encoding='utf-8') as feedsjson:
        feedsjson.write(json.dumps(syntaxscore_resource_result))
        feedsjson.write(",")

data_ingest()
cdr_db_verification_basic_resource(TAGS_SIMPLE_RESOURCE, "Patient", RESULT_SIMPLE_RESOURCE)
cdr_db_verification_bundle_resource("Patient", RESULT_BUNDLE_RESOURCE)
cdr_db_verification_syntaxscore_resource("Patient", RESULT_SYNTAXSCORE_RESOURCE)

#Closing the connection
conn.close()
