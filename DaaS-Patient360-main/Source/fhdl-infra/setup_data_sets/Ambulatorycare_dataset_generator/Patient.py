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
import Observation
from Observation import observation
from datetime import datetime
import uuid
import Imagingstudy
from Imagingstudy import imagingstudy_files
import Medication_summary_dataset
from Medication_summary_dataset import medicationstatement
from Medication_summary_dataset import medicationrequest
import Medication
from Medication import medication
import Immunization
from Immunization import immunization_resource
import Condition
from Condition import condition_dataset
import Allergy
from Allergy import allergyintolerance_files
import Encounter
from Encounter import encounter

directory = os.getcwd()

organization_folder = directory +'/dataset/organization/'
if not os.path.exists(organization_folder):
    os.makedirs(organization_folder)
    
practitioner_folder = directory +'/Dataset/practitioner/'
if not os.path.exists(practitioner_folder):
    os.makedirs(practitioner_folder)
    
patient_folder = directory +'/dataset/patient/'
if not os.path.exists(patient_folder):
   os.makedirs(patient_folder)

def patient(patient_file_count):
    for i in range(patient_file_count):
        patient_id = uuid.uuid4()
        telephone = '-'.join(( "800", str(r.randint(100,999)), str(r.randint(1000,9999)) ))
        postal_index_choices = (0,0,0,1,1,2,3,4,5,6,7,8)
        postal_data = ({'city': 'Bixby', "state": "Massachusetts", 'postalCode': '74008', 'country': 'USA'},
                     {'city': 'Mounds', "state": "california", 'postalCode': '74047', 'country': 'USA'},
                     {'city': 'Sapulpa', "state": "texas", 'postalCode': '74066', 'country': 'USA'},
                     {'city': 'Sand Springs', "state": "washington", 'postalCode': '74063', 'country': 'USA'},
                     {'city': 'Broken Arrow', "state": "virginia", 'postalCode': '74014', 'country': 'USA'},
                     {'city': 'Tulsa', "state": "new jersey", 'postalCode': '74126', 'country': 'USA'},
                     {'city': 'Tulsa', "state": "Hawali", 'postalCode': '74117', 'country': 'USA'},
                     {'city': 'Tulsa', "state": "alaska", 'postalCode': '74116', 'country': 'USA'},
                     {'city': 'Tulsa', "state": "Florida", 'postalCode': '74108', 'country': 'USA'})
                     
        # Street names 
        street_names = ('Park','Main','Oak','Pine','Elm','Washington','Lake','Hill','Walnut',
                        'Spring','North','Ridge','Church','Willow','Mill','Sunset','Railroad',
                        'Jackson','West','South','Center','Highland','Forest','River','Meadow',
                        'East','Chestnut')
                   
        street_types = ('St','Rd','Ave')
        index = postal_index_choices[r.randint(0,len(postal_index_choices)-1)]
        street = ' '.join((str(r.randint(1,100)),
                             street_names[r.randint(0,len(street_names)-1)],
                             street_types[r.randint(0,len(street_types)-1)]))
        gender_change = ('male','female') 
        newname = names.get_full_name()
        with open(directory + '/Sample_Template/Patient.json') as dataset:
            jsonData = json.load(dataset)
            oldname = jsonData['name'][0]['given'][0]
            jsonData['name'][0]['given'][0] = newname
            oldid = jsonData['id']
            jsonData['id'] = str(patient_id)
            jsonData['identifier'][0]['system']="urn:oid:2.16.840.1.113883.2.4.6."+str(r.randint(100,10000))
            jsonData['telecom'][0]['value']= telephone
            jsonData['address'][0] = postal_data[index]
            jsonData['gender'] = gender_change[r.randint(-1,len(gender_change)-2)]
            jsonData['contact'][0]['name']['family']=names.get_first_name()
            jsonData['contact'][0]['name']['given'][0] = names.get_last_name()
            jsonData['contact'][0]['telecom'][0]['value'] = str(r.randint(1,12)) + '06903' + '372'
            jsonData['birthDate'] = '19' + str((r.randint(11,99))) + '-0' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9)))
            resourceJson = jsonData.copy()
            jsonData['resourceJson'] = json.dumps(resourceJson)
        filename1  = "patient"
        filename2  = ".json"#creating a new patient data
        filename   = filename1 + filename2  
        with open(patient_folder + filename, mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()
  
        #creating Organization file
        Organization_id = uuid.uuid4()
        with open(directory + '/Sample_Template/Organization.json') as dataset:
            jsonData = json.load(dataset)
            oldid = jsonData['id']
            jsonData['id'] = str(Organization_id)
            resourceJson = jsonData.copy()
            jsonData['resourceJson'] = json.dumps(resourceJson)
        filename  = "organization" + ".json"
        with open(organization_folder + filename, mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()
           
        first_newname = names.get_first_name()
        last_newname = names.get_last_name()
        gender_change = ('male','female')
        #creating Practitioner file
        Practitioner_id = uuid.uuid4()
        with open(directory + '/Sample_Template/Practitioner.json') as dataset:
            jsonData = json.load(dataset)
            oldid = jsonData['id']
            jsonData['id'] = str(Practitioner_id)
            jsonData['name'][0]['family']= first_newname
            jsonData['name'][0]['given'][0]= last_newname
            jsonData['telecom'][0]['value']=first_newname + '.' + last_newname + str(r.randint(60,1000)) + '@example.com'
            jsonData['address'][0]= postal_data[index]
            jsonData['gender']= gender_change[r.randint(-1,len(gender_change)-2)]
            resourceJson = jsonData.copy()
            jsonData['resourceJson'] = json.dumps(resourceJson)
        filename  = "practitioner" + ".json"
        with open(practitioner_folder + filename, mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()
        observation(newname,patient_id,Practitioner_id)
        imagingstudy_files(newname,patient_id)
        medication_id,code_value = medication()
        medicationrequest(newname,patient_id)
        medicationstatement(newname,patient_id,medication_id,code_value)
        immunization_resource(newname,patient_id,Organization_id)
        new_encounter_id = encounter(newname,patient_id,Practitioner_id,Organization_id)
        condition_dataset(newname,patient_id,Practitioner_id,new_encounter_id)
        allergyintolerance_files(newname,patient_id)
patient(int(input("Enter file count : ")))
print("resources created successfully")