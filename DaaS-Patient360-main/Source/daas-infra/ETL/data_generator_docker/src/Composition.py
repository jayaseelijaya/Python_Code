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
#Creating Immunization file 
Composition_folder = directory +'/Dataset/'
if not os.path.exists(Composition_folder):
        os.makedirs(Composition_folder)
# def Composition_dataset(patient_newname,new_patient_id):
def composition(patientname,patientid,Pract_id,Org_id):
    Composition_id = uuid.uuid4()
    with open(directory + '/Sample_Template/Composition.json') as dataset:
        jsonData = json.load(dataset)
        oldid = jsonData['id']
        jsonData['id'] = str(Composition_id)
        jsonData['subject']['reference']= "Patient/"+ str(patientid)
        jsonData['author'][0]['reference']= "Practitioner/" + str(Pract_id)
        jsonData['custodian']['reference']= "Organization/" + str(Org_id)
    filename  = "Composition" + ".json"
    folderpath = os.path.join(Composition_folder,filename)
    with open(folderpath, 'w', encoding='utf-8') as f:
        jsonData1 = json.dump(jsonData, f, ensure_ascii=False, indent=4)
        print(filename)
