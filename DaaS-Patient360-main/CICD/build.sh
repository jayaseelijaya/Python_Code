#!/bin/bash -e
    echo "######## PROXY ENVIRONMENT SETUP ########"
    export http_proxy=${http_proxy}
    export https_proxy=${https_proxy}
    echo $https_proxy

    BUILD_SHARE="/home/jenkins/TFS_CI_SHARE"

sqDynamicGating(){
    echo "Running SonarQube Dynamic Gating"
    cd ${WORKSPACE}/ROBOCI/CICD/Scripts
    ./SQDG_baseline.sh ${PSNAME}
    cd ${WORKSPACE}
}

warningSuppressionCheck(){
    echo "Running Warning Suppression Gating"
    cd ${WORKSPACE}/ROBOCI/CICD/Scripts
    ./SuppressWarnings_gate.sh
    cd ${WORKSPACE}
}

sqReleasePrereq(){
    echo "Running SonarQube Release PreReq"
    cd ${WORKSPACE}/ROBOCI/CICD/Scripts
    ./sq_release_prerequisite.sh
    cd ${WORKSPACE}
}
runDockerCommands(){
    # backup
    echo "Building docker images"
    echo "Building fhdl-fhir-service service docker images"
     cd ${WORKSPACE}/Source/fhdl-fhir-service/
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
build(){
    if [[ $JOB_NAME =~ (DAY|NIGHTLY) ]]; then
    SONAR_BRANCH="DEV_NIGHTLY"
    elif [[ $JOB_NAME =~ (RELEASE) ]]; then
    sqReleasePrereq
    SONAR_BRANCH="DEV_RELEASE"
    elif [[ $JOB_NAME =~ (UPDATE) ]]; then
    sqReleasePrereq
    SONAR_BRANCH="DEV_UPDATE"
    elif [ $BUILD_TYPE = GATED -a $JOB_NAME != RELEASE -a $JOB_NAME != UPDATE ]; then
    SONAR_BRANCH="GATED"
    else
    echo " ${BUILD_TYPE} is Invalid "
    fi
            ##### TO CHECK DEVELOPMENT TYPE AND BUILD EXECUTION #####
    if [ "${DEV_TYPE,,}" == "java" ]; then
        echo "##### JAVA BUILD EXECUTION #####"
        if [[ $BUILD_TYPE =~ (GATED) ]]; then
            #warningSuppressionCheck
            #sqDynamicGating
            cd ${WORKSPACE}/Source
            mvn clean install sonar:sonar -Dsonar.projectName=${PSNAME} -Dsonar.projectKey=${PSNAME} -Dsonar.host.url=${HSDP_SONARQUBE_URL} -Dsonar.login=${HSDP_SONARQUBE_TOKEN}
            mvn clean install
            cd /home/jenkins
            chmod 777 sonargating.sh
            sh sonargating.sh ${PSNAME}
        elif [[ $BUILD_TYPE =~ (DAY|NIGHTLY|RELEASE|UPDATE) ]]; then
            cd ${WORKSPACE}/Source
            mvn clean install sonar:sonar -Dsonar.projectName=${PSNAME} -Dsonar.projectKey=${PSNAME} -Dsonar.host.url=${HSDP_SONARQUBE_URL} -Dsonar.login=${HSDP_SONARQUBE_TOKEN}
            cd /home/jenkins
            chmod 777 sonargating.sh
            sh sonargating.sh ${PSNAME}
        else
            echo "$BUILD_TYPE is INVALID"
        fi
        export BINARY_PATH=${BUILD_SHARE}/${BUILD_NAME}/${BUILD_NUM}/binary
        mkdir -p ${BINARY_PATH}
        echo "##### COPY BINARIES TO THE BINARY SERVER #####"
        cd ${WORKSPACE}/Source
        find . -name "*.jar" -exec cp {} ${BINARY_PATH}/  \;
    elif [ "${DEV_TYPE,,}" = "nodejsui" -o "${DEV_TYPE,,}" = "nodejs" ]; then
        if [[ $BUILD_TYPE =~ (GATED) ]]; then
            sqDynamicGating
            echo "##### ${DEV_TYPE} BUILD EXECUTION #####"
            cd ${WORKSPACE}/Source/app
            npm install
            npm run build
            npm run test
            sonar-scanner -Dsonar.projectKey=${PSNAME} -Dsonar.branch=${SONAR_BRANCH} -Dsonar.projectName=${PSNAME} -Dsonar.projectVersion=1.0 -Dsonar.sources=. -Dsonar.host.url=${HSDP_SONARQUBE_URL}
            chmod 777 sonargating.sh
            sh sonargating.sh ${PSNAME}
        elif [[ $BUILD_TYPE =~ (DAY|NIGHTLY|RELEASE|UPDATE) ]]; then
            echo "##### ${DEV_TYPE} BUILD EXECUTION #####"
            cd ${WORKSPACE}/Source/app
            npm install
            npm run build
            npm run test
            sonar-scanner -Dsonar.projectKey=${PSNAME} -Dsonar.branch=${SONAR_BRANCH} -Dsonar.projectName=${PSNAME} -Dsonar.projectVersion=1.0 -Dsonar.sources=. -Dsonar.host.url=${HSDP_SONARQUBE_URL}
            chmod 777 sonargating.sh
            sh sonargating.sh ${PSNAME}
        elif [ ${BUILD_TYPE} = "RELEASE" -o ${BUILD_TYPE} = "UPDATE" ]; then
            echo "##### COPY BINARIES TO THE BINARY SERVER #####"
            chmod -R 755 ${WORKSPACE}/
            BINARY_PATH=/home/jenkins/IOT_SHARE/$BUILD_NAME/$BUILD_NUM/
            mkdir -p $BINARY_PATH
            mkdir ${BINARY_PATH}Source
            cd $WORKSPACE/Source
            cp -rf . ${BINARY_PATH}Source
            else
                echo "Not a RELEASE/UPDATE Build"
        fi
    elif [ "${DEV_TYPE,,}" == "python" ]; then
        echo "##### ${DEV_TYPE} framework is not yet ready #####"
    else
        echo "##### ${DEV_TYPE} IS NOT A VALID DEVELOPMENT FRAMEWORK #####"
    fi

    echo "=== Running Docker at bottom==="
    runDockerCommands
    echo "=== Docker Running Finished ==="
	
    if [[ $BUILD_TYPE =~ ^(GATED|DAY|NIGHTLY|RELEASE|UPDATE) ]]; then
    echo "######## SETUP LANDING ZONES ########"
    echo "Adding Proxy"
    export http_proxy=$GATEWAY_PROXY
    export https_proxy=$GATEWAY_PROXY_SECURE
    # Following Scripts commented as these are stable & it is taking long times in builds to complete.
    # python3.7 ${WORKSPACE}/Source/fhdl-infra/subscribe-cdr-dicom-store/subscribe_cdr_dicom_store.py ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE}
   # python3.7 ${WORKSPACE}/Source/fhdl-infra/setup-db/setup_redshift.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${REDSHIFT_ZONE_NAME} ${REGION_NAME} ${API_ENDPOINT} ${REDSHIFT_STORAGE_TYPE} ${WORKSPACE}
    fi
}
buildWithoutSonarQube(){
    cd ${WORKSPACE}/Source
    mvn clean install
}

if [[ $BUILD_TYPE =~ ^(GATED|DAY|NIGHTLY|RELEASE|UPDATE) ]]; then
    build
elif [[ $BUILD_TYPE =~ ^(BLACKDUCK|FORTIFY) ]]; then
echo " BUILD_TYPE IS: $BUILD_TYPE Running Build without SonarQube"
    buildWithoutSonarQube
else
    echo "Not a CI or GATED build - Skipping SonareQube Scan"
fi