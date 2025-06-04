import subprocess
import json
import sys
import os
import csv
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

    #method to run commands
    def execute_command(args = '-l'):
        cmd = '/cf';
        try:
            temp = subprocess.Popen([cmd, args], stdout = subprocess.PIPE);
            output = str(temp.communicate())
            output = output.split("\n")
            output = output[0].split('\\')
            res = []
            for line in output:
                res.append(line)
            return res
        except Exception as e:
            print('Error running cf command:  %s' % e)

    if __name__ == '__main__':
        try: 
            #bind apps with vault
            apparray = execute_command('apps')

            for i in range(4, len(apparray) - 1):
                apps = apparray[i].split()[0]    
                appname =apps[1:].replace(" ", "")
                subprocess.run(['/cf', 'bind-service', appname, vault_zone_name], stdout = subprocess.PIPE)
            print("Binded apps with vault")
        except Exception as e:
            print('Error binding apps:  %s' % e)

        try: 
            #delete credentials json files after storing
            servicearray = execute_command('services')

            for i in range(3, len(servicearray) - 1):
                services = servicearray[i].split()[0]    
                servicename =services[1:].replace(" ", "")
                paths = os.getcwd()
                full_path = os.path.join(paths, "CICD/deploy_scripts/cf/vault/credentials/"+servicename+'-credentials.json')
                if os.path.exists(full_path):
                    os.remove(full_path)
                else:
                    print("Can not delete the file as it doesn't exists")
        except Exception as e:
            print('Error deleting the json files created during build: %s' % e)
else:
    print('Some arguments are missing!')
    