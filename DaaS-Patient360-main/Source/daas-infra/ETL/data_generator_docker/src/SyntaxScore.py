import os
import json
import xmltojson
import random
import shlex, subprocess
import requests
import sys


directory = os.getcwd()

# Importing daas vault
sys.path.append(os.path.abspath('../../../vault'))
from get_data_from_vault import vault_details

# Reading Vault Details
vault_data = vault_details()

path = directory+"/Sample_Template_Syntaxscore/"
data = random.choice(["Flow_1.json","Flow_2.json","Flow_3.json","Flow_4.json","Flow_5.json"])

headers = {"Accept" : "application/fhir+json; fhirVersion=4.0", "Content-Type" : "application/fhir+json; fhirVersion=4.0", "api-version" : "1"}
data_file = open(path+data, "rb")

url = vault_data['syntaxscore_input_bundle']
response = requests.post(url, headers=headers, json=json.load(data_file))
output=response.text
with open("Input_Syntax_Score.json", mode='w+') as feedsjson:
    json_data = json.loads(output)
    feedsjson.write(json.dumps(json_data))
with open("Input_Syntax_Score.json",'r') as file_data:
   json_data = json.load(file_data)
   feedsjson.close()

command1 = vault_data['iob_endpoint']
command2 = directory+"/Input_Syntax_Score.json"+' --header "dept:syntax_score" -v'
command = command1+command2

args = shlex.split(command)
process = subprocess.Popen(args)
print(process)
