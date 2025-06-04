import base64
import requests
import json
import os
import sys
import time
import subprocess
import names
import random as r
import datetime
from datetime import datetime
import uuid

directory = os.getcwd()
#creating Ecounter file        
Encounter_folder = directory +'/Dataset/'
if not os.path.exists(Encounter_folder):
    os.makedirs(Encounter_folder)
def Encounter(patient_newname,new_patient_id,pract_id,Org_id):
    with open(directory + '/Sample_Template/Ecounter.json') as dataset:
        Ecounter_id = uuid.uuid4()
        jsonData = json.load(dataset)
        oldid = jsonData['id']
        jsonData['id'] = str(Ecounter_id)
        jsonData['subject']['reference']= "Patient/"+ str(new_patient_id)
        jsonData['subject']['display'] = str(patient_newname)
        jsonData['serviceProvider']['reference'] = "Organization/" + str(Org_id)
        jsonData['participant'][0]['individual']['reference'] = "Practitioner/" + str(pract_id)
        jsonData['identifier'][0]['value'] = str(Ecounter_id)
        jsonData['participant'][0]['period']['start'] = "2021" + '_0' + str(r.randint(1,4))+ '_0' + str(r.randint(1,9))
        jsonData['participant'][0]['period']['end'] = "2021" + '_0' + str(r.randint(5,9))+ '_0' + str(r.randint(1,9))
        jsonData['period']['start'] = "2021" + '_0' + str(r.randint(1,4))+ '_0' + str(r.randint(1,9))
        jsonData['period']['end'] = "2021" + '_0' + str(r.randint(5,9))+ '_0' + str(r.randint(1,9))
        resourceJson = jsonData.copy()
        jsonData['resourceJson'] = json.dumps(resourceJson)
    filename_Encounter = "Encounter.json"
    with open(Encounter_folder + filename_Encounter, mode='w+', encoding='utf-8') as feedsjson:
        feedsjson.write(json.dumps(jsonData))
        return Ecounter_id
        feedsjson.close()
    print(filename_Encounter)
    
