import subprocess
import json
import sys
import os
total_arg = len(sys.argv)

if (total_arg == 7):
    org_name = sys.argv[1]
    space_name = sys.argv[2]
    username = sys.argv[3]
    password = sys.argv[4]
    vault_zone_name = sys.argv[5]
    vault_region_name =sys.argv[6]
    vault_region = '{"Region":"%s"}' % (vault_region_name)

    #Login to Cloud Foundry
    cf_login = subprocess.run(['/cf', 'login', '-a', "https://api.cloud.pcftest.com", '-u', username, '-p', password, '-o', org_name, '-s', space_name], stdout=subprocess.PIPE)
    
    #Create vault service
    create_service = subprocess.run(['/cf', 'create-service', 'hsdp-vault', 'vault-us-east-1', vault_zone_name], stdout=subprocess.PIPE)
    #time.sleep(120)
    flag=0
    while(flag==0):
        try:
    
    #Generate Service Key
            service_key = subprocess.run(['/cf', 'create-service-key', vault_zone_name, vault_zone_name + '-key'], stdout=subprocess.PIPE) 
            
            flag=1
        except Exception:
            print("Dynamodb creation in progress...")
    print('Vault service and key generated')

    #Store credentials
    cmd = '/cf';
    args = 'services';
    temp = subprocess.Popen([cmd, args], stdout = subprocess.PIPE);
    output = str(temp.communicate())
    output = output.split("\n")
    output = output[0].split('\\')
    res = []
    for line in output:
        res.append(line)

    
    for i in range(3, len(res) - 1):
        try: 
            services = res[i].split()[0]    
            servicename =services[1:].replace(" ", "")
            service_key_details = subprocess.run(['/cf', 'service-key', servicename, servicename + '-key'], capture_output=True, text=True)  
            service_key_details_json = json.loads(service_key_details.stdout.split('\n', 2)[2].strip().replace(" ", ""))
            paths = os.getcwd() 
            full_path = os.path.join(paths, "CICD/deploy_scripts/cf/vault/credentials/"+servicename+'-credentials.json')
            with open(full_path, 'w') as f:
                json_string=json.dumps(service_key_details_json)
                f.write(json_string)
        except Exception as e:
            print('Error creating the json files: %s' % e)
    print('Service credentials json file created successfully')
else:
    print('Some arguments are missing!')
    