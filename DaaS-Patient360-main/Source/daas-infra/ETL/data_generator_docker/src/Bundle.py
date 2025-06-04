import base64
import requests
import json
import os
import random
import sys
import time
import names
import shlex, subprocess


directory = os.getcwd()

# Importing daas vault
sys.path.append(os.path.abspath('../../../vault'))
from get_data_from_vault import vault_details

# Reading Vault Details
vault_data = vault_details()


foldername = directory +'/Bundle_datasets/'
if not os.path.exists(foldername):
   os.makedirs(foldername)
#for i in range(n):
newname = names.get_full_name()
print(newname)
with open('R4_bundle.json') as dataset:
    jsonData = json.load(dataset)
    oldname = jsonData['entry'][0]['resource']['name'][0]['given'][0]
    print("The value of oldname is",oldname)
    jsonData['entry'][0]['resource']['name'][0]['given'][0] = newname
filename1  = newname.replace(' ', '_')
filename2  = ".json"#creating a new patient data
filename   = filename1 + filename2
folderpath = os.path.join(foldername,filename)
with open(folderpath, 'w', encoding='utf-8') as f:
    topic_name=random.choice(["pd","cc"])
    jsonData1 = json.dump(jsonData, f, ensure_ascii=False, indent=4)
    command1 = vault_data['iob_endpoint']
    command2="Bundle_datasets/"+filename+' --header "dept:pd" -v'
    command=command1+command2
    args = shlex.split(command)
    process = subprocess.Popen(args)
