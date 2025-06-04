#!/bin/bash

sh auto_deploy.sh -cfusername=$cfusername -cfpassword=$cfpassword -dockerusername=$dockerusername -dockerpassword=$dockerpassword -dockerregistry=$dockerregistry -dockerimagetag=$dockerimagetag -routeprefix=$routeprefix -domain=$domain -dockerImageVersion=$dockerImageVersion -orgname=$orgname -spacename=$spacename -apihost=$apihost -loginhost=$loginhost -vaultinstance=$vaultinstance -vaultplan=$vaultplan -rabbitmqinstance=$rabbitmqinstance -logdrainurl=$logdrainurl

echo "vm setup script execution..."
sh vmsetup.sh $hostip $hostusername $hostpass
