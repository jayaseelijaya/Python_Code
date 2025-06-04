import subprocess
import json
import sys
import os
import csv

if (total_arg == 5):
    org_name = sys.argv[1]
    space_name = sys.argv[2]
    username = sys.argv[3]
    password = sys.argv[4]

    #Login to Cloud Foundry
    cf_login = subprocess.run(['/cf', 'login', '-a', 'https://api.cloud.pcftest.com', '-u', username, '-p', password, '-o', org_name, '-s', space_name], stdout=subprocess.PIPE)

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
            apparray = execute_command('apps')

            for i in range(4, len(apparray) - 1):
                apps = apparray[i].split()[0]    
                appname =apps[1:].replace(" ", "")
                subprocess.run(['/cf', 'stop', appname], stdout = subprocess.PIPE)
                subprocess.run(['/cf', 'delete','-r','-f', appname], stdout = subprocess.PIPE)
                print("Deleted app: ",appname)
        except Exception as e:
            print('Error :  %s' % e)
        if space_name == "aicoe-fhdl-test":
            print("Test space Service deletion",space_name)
            try: 
                servicearray = execute_command('services')

                for i in range(3, len(servicearray) - 1):
                    services = servicearray[i].split()[0]    
                    servicename =services[1:].replace(" ", "")
                    print(servicename,servicename+"-key")
                    subprocess.run(['/cf', 'delete-service-key','-f', servicename,servicename+"-key"], stdout = subprocess.PIPE)
                    subprocess.run(['/cf', 'delete-service','-f', servicename], stdout = subprocess.PIPE)
                    print("Deleted service: ",servicename)
            except Exception as e:
                print('Error deleting: %s' % e)
else:
    print('Some arguments are missing!')
