import subprocess
import json
import sys
import os

total_arg = len(sys.argv)

if (total_arg == 10):

    org_name = sys.argv[1]
    space_name = sys.argv[2]
    username = sys.argv[3]
    password = sys.argv[4]
    redshift_zone_name =  sys.argv[5]
    redshift_region_name = sys.argv[6]
    redshift_api_endpoint= sys.argv[7]
    redshift_region = '{"Region":"%s"}' % (redshift_region_name)
    redshift_storage_type = sys.argv[8]
    WORKSPACE = sys.argv[9]
    #Login to Cloud Foundry
    cf_login = subprocess.run(['/cf', 'login', '-a', redshift_api_endpoint, '-u', username, '-p', password, '-o', org_name, '-s', space_name], stdout=subprocess.PIPE)
    #Create redshift service
    create_service = subprocess.run(['/cf', 'create-service', 'hsdp-redshift', redshift_storage_type, redshift_zone_name, '-c', WORKSPACE + '/Source/fhdl-infra/setup-db/redshift_config.json'], stdout=subprocess.PIPE)
    #time.sleep(120)
    flag=0
    while(flag==0):
        try:
    #Generate Service Key
            redshift_service_key = subprocess.run(['/cf', 'create-service-key', redshift_zone_name, redshift_zone_name + '-key'], stdout=subprocess.PIPE) 
            
            redshift_service_key = subprocess.run(['/cf', 'service-key', redshift_zone_name, redshift_zone_name + '-key'], stdout=subprocess.PIPE)
            redshift_service_key_res = str(redshift_service_key.stdout, 'utf-8')
            redshift_service_key_json = json.loads(redshift_service_key_res.split('\n', 2)[2].strip().replace(" ", "")) 
            flag=1
        except Exception:
            print("Redshift creation is in progress...")   
    print('Redshift service created')
else:
    print('Some arguments are missing!')