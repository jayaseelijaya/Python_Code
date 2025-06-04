#!/bin/bash
set -e

export http_proxy=$GATEWAY_PROXY
export https_proxy=$GATEWAY_PROXY_SECURE

echo "Updating pip and adding cloudfoundry_client module"
python3.7 -m pip install --upgrade --force pip
python3.7 -m pip install PyYAML --upgrade
python3.7 -m pip install cloudfoundry_client
echo "Done updating pip"

help(){
    echo ""
    echo "USAGE :"
    echo "|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|"
    echo "| sh auto_deploy.sh [cloud foundry username] [cloud foundry password] [docker user name] [docker user password] [docker registry] [docker image tag] [route prefix] [domain] [docker image release version] [cf org name] [cf space name] [cf api host] [cf login host] [cf vault instance name] [cf vault plan name] [rabbitmq instance name] [logDrainurl]"
    echo "|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|"
}


if [ $# -lt 19 ]; then
    help
    exit 0
fi


for ARGUMENT in "$@"
do
  KEY=$(echo $ARGUMENT | cut -f1 -d=)
  VALUE=$(echo $ARGUMENT | cut -f2 -d=)
  case "$KEY" in
	-cfusername) cfUsername=${VALUE};;
	-cfpassword) cfPassword=${VALUE};;
	-dockerusername) dockerUsername=${VALUE};;
	-dockerpassword) dockerPassword=${VALUE};;
	-dockerregistry) dockerRegistry=${VALUE};;
	-dockerimagetag) dockerImageTag=${VALUE};;
	-routeprefix) routePrefix=${VALUE};;
    -domain) domain=${VALUE};;
	-dockerImageVersion) dockerImageVersion=${VALUE};;
	-orgname) org_name=${VALUE};;
	-spacename) space_name=${VALUE};;
	-apihost) api_host=${VALUE};;
	-loginhost) login_host=${VALUE};;
	-vaultinstance) vault_instance=${VALUE};;
    -vaultplan) vault_plan=${VALUE};;
	-rabbitmqinstance) rabbitmq_instance=${VALUE};;
	-logdrainurl) logDrainurl=${VALUE};;
	-region) region_name=${VALUE};;
	-vaultendpoint) vault_endpoint=${VALUE};;
  esac
done

ENV_VALUE=configurations/config-core.yml
CONFIGTEMPLATE=configurations/services_manifest_template.yml.j2

echo " Create vault service..."
dot="$(cd "$(dirname "$0")"; pwd)"
path="$dot/cf/vault"

python3.7 $path/setup_vault.py ${org_name} ${space_name} ${cfUsername} ${cfPassword} ${vault_instance} ${region_name}

echo "Store credentials to vault"
search_dir="$dot/cf/vault/credentials"
for entry in "$search_dir"/*
do
  val=$(echo "$entry" | cut -d'/' -f 11 | cut -d'.' -f 1) 
 python3.7 $path/read_write_vault.py ${cfUsername} ${cfPassword}  $org_name  $space_name  $vault_instance  $api_host "$entry" $val $vault_endpoint w
done

#echo " Bind apps with vault ..."
#python3.7 $path/bind_apps.py ${org_name} ${space_name} ${cfUsername} ${cfPassword} ${vault_instance} ${region_name}

echo "Vault setup completed..."

 echo "Starting microservices deployment..."
# ##STEP 1: Populate the environment specific file
# Example:
# python populate_config.py -p $1  -i $2
# $1 -> ./configurations/pc_lite_config/dev_env_pclite_config_manifest_template.yml.j2 , a template file
# #$2 -> ./configurations/pc_lite_config/dev_env_input_to_config.yml, env value

cd ${WORKSPACE}/CICD/deploy_scripts/

echo " Calling populate_config python file started...python2"

python3.7 ./utils/populate_config.py -p $CONFIGTEMPLATE -i $ENV_VALUE -d $domain -org_name $org_name -space_name $space_name -api_host $api_host -login_host $login_host -vault_instance $vault_instance -vault_plan $vault_plan -rabbitmq_instance $rabbitmq_instance -routePrefix $routePrefix

echo " Calling populate_config python file finished..."

configfile=configurations/services_manifest_template.yml
echo $configfile

###STEP 2: Create-manifests files from provided template and manifests folder

echo " Calling create-manifests started ..."

python3.7 create-manifests -c $ENV_VALUE -dockerUsername $dockerUsername -dockerRegistry $dockerRegistry -dockerImageTag $dockerImageTag -routePrefix $routePrefix -dockerImageVersion $dockerImageVersion 
echo " Calling create-manifests finished ..."

###STEP 3: Create-services
#echo " Calling create-services started ..."
#echo $configfile
#python3.7 create-services -c $configfile -cfUsername $cfUsername -cfPassword $cfPassword

#echo " Calling create-services finished ..."


# ###STEP 4: deploy apps

echo " Deploying the app ...."
python3.7 app_deploy.py -cfUsername $cfUsername -cfPassword $cfPassword -dockerPassword $dockerPassword -routePrefix $routePrefix -logDrainurl $logDrainurl

echo "Deployment of the apps completed ...."

