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

medicationstatement_folder = directory +'/dataset/medicationstatement/'
if not os.path.exists(medicationstatement_folder):
   os.makedirs(medicationstatement_folder)
   
medicationrequest_folder = directory +'/dataset/medicationrequest/'
if not os.path.exists(medicationrequest_folder):
   os.makedirs(medicationrequest_folder)

def medicationstatement(patient_newname,new_patient_id,medication_id,code_value):
    for medicationstatement in range(0,3): 
        with open(directory + '/code_values/medication_code_values.json') as med:
            Data = json.load(med)
            values = r.randint(0,len(Data)-1)
        with open(directory + '/Sample_Template/Medicationstatement.json') as dataset:
            medication_Statement_id = uuid.uuid4()
            jsonData = json.load(dataset)
            oldid = jsonData['id']
            jsonData['id'] = str(medication_Statement_id)
            jsonData['medicationReference']['reference'] = "Medication/" + str(medication_id)
            jsonData['medicationReference']['display'] = str(code_value)
            jsonData['subject']['reference'] = 'Patient/' + str(new_patient_id)
            jsonData['subject']['display'] = str(patient_newname)
            jsonData['dosage'][0]['text'] = str(r.randint(10,60))+ ' ' + 'mg/day'
            value = jsonData['dosage'][0]['text']
            jsonData['dosage'][0]['doseQuantity']['value'] = int(value.replace('mg/day', ''))
            jsonData['effectivePeriod']['start'] = str(r.randint(2001,2019)) + '-0' + str(r.randint(1,9)) + '-0' + str((r.randint(1,9)))
            resourceJson = jsonData.copy()
            jsonData['resourceJson'] = json.dumps(resourceJson)
        filename = "medicationStatement_1" + ".json"
        with open(medicationstatement_folder + filename, mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()

def medicationrequest(patient_newname,new_patient_id):
    status = ['active', 'completed']
    intent = ['proposal', 'plan', 'order', 'instance-order']
    for medicationrequest in range(0,3): 
        with open(directory + '/code_values/medication_code_values.json') as med:
            Data = json.load(med)
            values = r.randint(0,len(Data)-1)
        with open(directory + '/Sample_Template/Medicationrequest.json') as dataset:
            medicationrequest_id = uuid.uuid4()
            jsonData = json.load(dataset)
            oldid = jsonData['id']
            jsonData['id'] = str(medicationrequest_id)
            jsonData['status'] = status[r.randint(0,len(status)-2)]
            jsonData['intent'] = intent[r.randint(0,len(intent)-1)]
            jsonData['medicationCodeableConcept']['coding'][0] = Data[values]
            jsonData['subject']['reference'] = 'Patient/' + str(new_patient_id)
            jsonData['subject']['display'] = str(patient_newname)
            jsonData['dosageInstruction'][0]['text'] = str(r.randint(10,60))+ ' ' + 'mg/day'
            value = jsonData['dosageInstruction'][0]['text']
            jsonData['dosageInstruction'][0]['doseQuantity']['value'] = int(value.replace('mg/day', ''))
            jsonData['dispenseRequest']['validityPeriod']['start'] = str(r.randint(2021,2024)) + '-0' + str(r.randint(1,9)) + '-0' + str(r.randint(1,9))
            resourceJson = jsonData.copy()
            jsonData['resourceJson'] = json.dumps(resourceJson)
        filename  =  "medicationRequest" + ".json"
        with open(medicationrequest_folder + filename, mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()
            
