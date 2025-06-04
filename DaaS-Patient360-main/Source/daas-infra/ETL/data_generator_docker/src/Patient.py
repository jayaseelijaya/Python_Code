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
import Composition
from Composition import composition
import observation_module 
from observation_module import observation
from datetime import datetime
import uuid
import random
import Imagingstudy
from Imagingstudy import imagingstudy_files
import Medication_summary_dataset
from Medication_summary_dataset import MedicationStatement
from Medication_summary_dataset import Medicationrequest
import Medication
from Medication import Medication
import Immunization
from Immunization import immunization_resource
import Condition
from Condition import Condition_dataset
import Allergy
from Allergy import AllergyIntolerance_files
import Encounter
from Encounter import Encounter
import shlex, subprocess


directory = os.getcwd()

# Importing daas vault
sys.path.append(os.path.abspath('../../../vault'))
from get_data_from_vault import vault_details

# Reading Vault Details
vault_data = vault_details()
print(vault_data)

Organization_folder = directory +'/Dataset/'
if not os.path.exists(Organization_folder):
    os.makedirs(Organization_folder)
    
Practitioner_folder = directory +'/Dataset/'
if not os.path.exists(Practitioner_folder):
    os.makedirs(Practitioner_folder)
    
patient_folder = directory +'/Dataset/'
if not os.path.exists(patient_folder):
   os.makedirs(patient_folder)
def patient():
    #for i in range(patient_file_count):
        patient_id = uuid.uuid4()
        telephone = '-'.join(( "800", str(r.randint(100,999)), str(r.randint(1000,9999)) ))
        POSTAL_INDEX_CHOICES = (0,0,0,1,1,2,3,4,5,6,7,8)
        POSTAL_DATA = ({'city': 'Bixby', "state": "Massachusetts", 'postalCode': '74008', 'country': 'USA'},
                     {'city': 'Mounds', "state": "california", 'postalCode': '74047', 'country': 'USA'},
                     {'city': 'Sapulpa', "state": "texas", 'postalCode': '74066', 'country': 'USA'},
                     {'city': 'Sand Springs', "state": "washington", 'postalCode': '74063', 'country': 'USA'},
                     {'city': 'Broken Arrow', "state": "virginia", 'postalCode': '74014', 'country': 'USA'},
                     {'city': 'Tulsa', "state": "new jersey", 'postalCode': '74126', 'country': 'USA'},
                     {'city': 'Tulsa', "state": "Hawali", 'postalCode': '74117', 'country': 'USA'},
                     {'city': 'Tulsa', "state": "alaska", 'postalCode': '74116', 'country': 'USA'},
                     {'city': 'Tulsa', "state": "Florida", 'postalCode': '74108', 'country': 'USA'})
                     
        # Street names 
        STREET_NAMES = ('Park','Main','Oak','Pine','Elm','Washington','Lake','Hill','Walnut',
                        'Spring','North','Ridge','Church','Willow','Mill','Sunset','Railroad',
                        'Jackson','West','South','Center','Highland','Forest','River','Meadow',
                        'East','Chestnut')
                   
        STREET_TYPES = ('St','Rd','Ave')
        index = POSTAL_INDEX_CHOICES[r.randint(0,len(POSTAL_INDEX_CHOICES)-1)]
        street = ' '.join((str(r.randint(1,100)),
                             STREET_NAMES[r.randint(0,len(STREET_NAMES)-1)],
                             STREET_TYPES[r.randint(0,len(STREET_TYPES)-1)]))
        gender_change = ('male','female') 
        newname = names.get_full_name()
        print(newname)
        print(directory)
        with open(directory + '/Sample_Template/Patient.json') as dataset:
            jsonData = json.load(dataset)
            oldname = jsonData['name'][0]['given'][0]
            jsonData['name'][0]['given'][0] = newname
            oldid = jsonData['id']
            jsonData['id'] = str(patient_id)
            jsonData['identifier'][0]['system']="urn:oid:2.16.840.1.113883.2.4.6."+str(r.randint(100,10000))
            jsonData['telecom'][0]['value']= telephone
            jsonData['address'][0] = POSTAL_DATA[index]
            jsonData['gender'] = gender_change[r.randint(-1,len(gender_change)-2)]
            jsonData['contact'][0]['name']['family']=names.get_first_name()
            jsonData['contact'][0]['name']['given'][0] = names.get_last_name()
            jsonData['contact'][0]['telecom'][0]['value'] = str(r.randint(1,12)) + '06903' + '372'
            jsonData['birthDate'] = '19' + str((r.randint(11,99))) + '-0' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9)))
            #resourceJson = jsonData.copy()
            #jsonData['resourceJson'] = json.dumps(resourceJson)
        filename1  = "Patient"
        filename2  = ".json"#creating a new patient data
        filename   = filename1 + filename2  
        with open(patient_folder + filename, mode='w+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()
            print(filename)   
            
        #creating Organization file
        Organization_id = uuid.uuid4()
        with open(directory + '/Sample_Template/Organization.json') as dataset:
            jsonData = json.load(dataset)
            oldid = jsonData['id']
            jsonData['id'] = str(Organization_id)
            #resourceJson = jsonData.copy()
            #jsonData['resourceJson'] = json.dumps(resourceJson)
        filename  = "Organization" + ".json"
        with open(Organization_folder + filename, mode='w+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()
            print(filename)

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
            jsonData['address'][0]= POSTAL_DATA[index]
            jsonData['gender']= gender_change[r.randint(-1,len(gender_change)-2)]
            #resourceJson = jsonData.copy()
            #jsonData['resourceJson'] = json.dumps(resourceJson)
        filename1  = "Practitioner"
        filename2  = ".json"
        filename   = filename1 + filename2
        with open(Practitioner_folder + filename, mode='w+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()
            print(filename)
        observation(newname,patient_id,Practitioner_id)
        imagingstudy_files(newname,patient_id)
        medication_id,code_value = Medication()
        Medicationrequest(newname,patient_id)
        MedicationStatement(newname,patient_id,medication_id,code_value)
        immunization_resource(newname,patient_id,Organization_id)
        en_id = Encounter(newname, patient_id, Practitioner_id, Organization_id)
        Condition_dataset(newname,patient_id,Practitioner_id,en_id)
        AllergyIntolerance_files(newname,patient_id)
        composition(newname,patient_id,Practitioner_id,Organization_id)
        

def ingestion():
    filename=["Patient.json","Organization.json","Practitioner.json","Observation_vital_sign0.json","Observation_vital_sign1.json","Observation_vital_sign2.json",
            "Observation_vital_sign3.json","Observation_laboratory0.json","Observation_blood_pressure0.json","Observation_laboratory1.json",
            "Observation_blood_pressure1.json","Observation_laboratory0_CO2.json","Observation_laboratory1_CO2.json","Imagingstudy0.json","Imagingstudy1.json",
            "MedicationRequest0.json","MedicationRequest1.json","MedicationRequest2.json","MedicationStatement_10.json","MedicationStatement_11.json",
            "MedicationStatement_12.json","Immunization0.json","Immunization1.json","Immunization2.json","Condition0.json","Condition1.json",
            "Condition2.json","Condition3.json","Allergyintolerance.json","Encounter.json","Composition.json"]
    length=len(filename)
  #  topic_name=random.choice(["pd","cc"])
    for file in range(length):
        var= directory+ '/Dataset/'+filename[file]
        command1 = vault_data['iob_endpoint']
        command2=var+' --header "dept:pd" -v'
        command=command1+command2
        args = shlex.split(command)
        process = subprocess.Popen(args)
patient()
ingestion()
