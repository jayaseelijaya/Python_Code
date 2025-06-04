#!/bin/bash -e

BUILD_SHARE="/home/jenkins/TFS_CI_SHARE"
echo -e "######## SOFTWARES VERSION ########" 

# echo -e "CLOUD FOUNDARY VERSION"
# cf -v
echo -e "PYTHON VERSION"
python --version

######## PROXY ENV SETUP ########
export http_proxy=${http_proxy}
export https_proxy=${http_proxy}


echo -e "######## CF PARAMETERS ########"
echo -e " PCF_TEST   : ${PCF_TEST} "
echo -e " CF_LOGIN   : ${CF_LOGIN} "
echo -e " HSDP_CI_ORG: ${HSDP_CI_ORG} "
echo -e " CF_SPACE   : ${CF_SPACE} "
echo -e " CF_USN     : ${CF_USN} "

######## CF DEPLOYMENT EXECUTION ########
chmod -R 755 ${WORKSPACE}/*

cd ${WORKSPACE}/

sh  ${WORKSPACE}/CICD/deploy_scripts/auto_deploy.sh -cfusername=${CF_USN} -cfpassword=${CF_PWD} -dockerusername=${DOCKER_USN} -dockerpassword=${DOCKER_PWD} -dockerregistry=${DOCKER_REPO_URL} -dockerimagetag=${DOCKER_REPO_PATH} -routeprefix=fhdl -domain=${DOMAIN} -dockerImageVersion=${DOCKER_IMAGE_VERSION} -orgname=${CF_ORG} -spacename=${CF_SPACE} -apihost=${CF_API_HOST} -loginhost=${CF_LOGIN_HOST} -vaultinstance=${VAULT_SERVICE_INSTANCE} -vaultplan=hsdp-vault -rabbitmqinstance=fhdl-rabbitmq -logdrainurl=logdrainurl -vaultendpoint=${VAULT_HOST} -region=${REGION_NAME} 

