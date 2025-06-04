#!/bin/bash -e
cd Source
mvn clean install
echo "=== Running Docker at bottom==="
runDockerCommands
echo "=== Docker Running Finished ==="    
echo "######## SETUP LANDING ZONES ########"
echo "Adding Proxy"
#export http_proxy=$GATEWAY_PROXY
#export https_proxy=$GATEWAY_PROXY_SECURE
# Following Scripts commented as these are stable & it is taking long times in builds to complete.
# python3.7 ${WORKSPACE}/Source/fhdl-infra/subscribe-cdr-dicom-store/subscribe_cdr_dicom_store.py ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE}
# python3.7 ${WORKSPACE}/Source/fhdl-infra/setup-db/setup_redshift.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${REDSHIFT_ZONE_NAME} ${REGION_NAME} ${API_ENDPOINT} ${REDSHIFT_STORAGE_TYPE} ${WORKSPACE}

runDockerCommands(){
    # backup
    echo "Building docker images"
    echo "Building fhdl-fhir-service service docker images"
     cd Source/fhdl-fhir-service/
     echo "########## Running docker command for setup fhdl-fhir-service service ##########"
     make registry=$DOCKER_REPO_URL repopath=$DOCKER_REPO_PATH version=$DOCKER_IMAGE_VERSION proxy='' jarversion=$JARVERSION secure_proxy=''
     if [ $? -eq 0 ]
     then
        echo "fhdl-fhir-service service image success"
     else
        echo "fhdl-fhir-service service image failed"
        exit 1
     fi
}