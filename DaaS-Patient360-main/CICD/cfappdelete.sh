#!/bin/bash -e
	
	echo -e "######## CF APPS DELETION ########"
	echo -e "######## CF PARAMETERS ########"
	echo -e " CF_SPACE : ${CF_SPACE} "
	echo -e " CF_USN   : ${CF_USN} "
	echo -e " CF_ORG   : ${CF_ORG} "
	echo "Adding Proxy"
    export http_proxy=$GATEWAY_PROXY
    export https_proxy=$GATEWAY_PROXY_SECURE
	#Code to delete apps and services in CF Test space
	#python3.7 ${WORKSPACE}/CICD/delete_services_n_apps.py ${CF_ORG} "aicoe-fhdl-test"  ${CF_USN} ${CF_PWD}	
	#Code to delete apps in CF Dev space
	python3.7 ${WORKSPACE}/CICD/delete_services_n_apps.py {CF_ORG} "aicoe-fhdl-dev" ${CF_USN} ${CF_PWD}
	echo -e "######## CF APPS REMOVED ########"