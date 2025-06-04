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
Medication_folder = directory +'/Dataset/'
if not os.path.exists(Medication_folder):
   os.makedirs(Medication_folder)
def Medication():
    form = [{"system": "http://snomed.info/sct", "code": "385055001",  "display": "Tablet dose form (qualifier value)"},{"system": "http://snomed.info/sct","code": "385219001",
    "display": "Injection solution (qualifier vallue)"}]
    itemCodeableConcept = [{"system": "http://snomed.info/sct","code": "373994007","display": "Prednisone 5mg tablet (Product)"},{"system": "http://snomed.info/sct","code": "386983007","display": "Alprazolam (substance)"},{"system": "http://snomed.info/sct","code": "408596005","display": "Alemtuzumab 30mg/3mL infusion concentrate (product)"},{
    "system": "http://snomed.info/sct","code": "387106007","display": "Lorazepam (substance)"},{"system": "http://snomed.info/sct","code": "430127000","display": "Oral Form Oxycodone (product)"},{"system": "http://snomed.info/sct","code": "317935006","display": "Chlorthalidone 50mg tablet (product)"}]   
    Medication_id = uuid.uuid4()      
    with open(directory + '/code_values/medication_values.json') as medication_code:
        Data_value = json.load(medication_code)
        print(len(Data_value['coding']))
        values = r.randint(0,len(Data_value['coding'])-1)
        code_value = Data_value['coding'][values]['display']
        print(Data_value['coding'][values])
        
    with open(directory + '/Sample_Template/Medication.json') as dataset:
        jsonData = json.load(dataset)
        oldid = jsonData['id']
        jsonData['id'] = str(Medication_id)
        if (values == 0):
            jsonData['code']['coding'][0] = Data_value['coding'][values]
            jsonData['code']['text'] = Data_value['coding'][values]['display']
            jsonData['form']['coding'][0] = form[0]
            jsonData['ingredient'][0]['itemCodeableConcept']['coding'][0] = itemCodeableConcept[0]
        if (values == 1):
            jsonData['code']['coding'][0] = Data_value['coding'][values]
            jsonData['code']['text'] = Data_value['coding'][values]['display']
            jsonData['form']['coding'][0] = form[1]
            jsonData['ingredient'][0]['itemCodeableConcept']['coding'][0] = itemCodeableConcept[1]
        if (values == 2):
            jsonData['code']['coding'][0] = Data_value['coding'][values]
            jsonData['code']['text'] = Data_value['coding'][values]['display']
            jsonData['form']['coding'][0] = form[1]
            jsonData['ingredient'][0]['itemCodeableConcept']['coding'][0] = itemCodeableConcept[2]
        if (values == 3):
            jsonData['code']['coding'][0] = Data_value['coding'][values]
            jsonData['code']['text'] = Data_value['coding'][values]['display']
            jsonData['form']['coding'][0] = form[1]
            jsonData['ingredient'][0]['itemCodeableConcept']['coding'][0] = itemCodeableConcept[3]
        if (values == 4):
            jsonData['code']['coding'][0] = Data_value['coding'][values]
            jsonData['code']['text'] = Data_value['coding'][values]['display']
            jsonData['form']['coding'][0] = form[0]
            jsonData['ingredient'][0]['itemCodeableConcept']['coding'][0] = itemCodeableConcept[4]
        if (values == 5):
            jsonData['code']['coding'][0] = Data_value['coding'][values]
            jsonData['code']['text'] = Data_value['coding'][values]['display']
            jsonData['form']['coding'][0] = form[0]
            jsonData['ingredient'][0]['itemCodeableConcept']['coding'][0] = itemCodeableConcept[5]
        resourceJson = jsonData.copy()
        jsonData['resourceJson'] = json.dumps(resourceJson)
    filename  = "Medication_1" + ".json"
    with open(Medication_folder + filename, mode='w+', encoding='utf-8') as feedsjson:
        feedsjson.write(json.dumps(jsonData))
        return Medication_id,code_value
        feedsjson.close()
        print(filename)
        
