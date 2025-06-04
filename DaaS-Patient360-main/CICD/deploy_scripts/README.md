HSDP Deployment template for Cloud Foundry
==========================================

This repo contains the basic structure for storing complete deployment
configurations for HSDP applications that are deployed to Cloud Foundry.
The general idea here is that all information needed to deploy an application
be captured in a single configuration file, using a format we have defined.
The format accounts for one or more applications to be delivered as a part
of a single deployment, and consists of a standard directory structure,
a way to link binaries to a revision, one or more configuration files, a
manifest template system, and tools to create manifests from the templates
to provision services from the configuration.

Directory Structure
-------------------
The directory structure consists of the following top level directories:
binary, cf, configurations, manifests,templates.

**Directory and file layout**
```
.
├── README.md
├── cf
│   ├── README.md
│   ├── __init__.py
│   ├── cf.py
│   ├── create_manifests.py
│   └── create_services.py
├── configurations
│   ├── README.md
│   ├── config.yml
├── create-manifests
├── create-services
├── requirements.txt
└── templates
    ├── README.md
    ├── 01_cache-service_manifest.yml.j2
    ├── 02_user-registration_manifest.yml.j2
    └── base_manifest.yml.j2
```
---------------------------------------------

`cf`: This directory contains the source for all the tools located in the root
directory of the project.  Files in this directory should never be modified or
updated in any way.  There are wrapper scripts in the root directory that
should be used to execute the scripts.

`configurations`: This directory is where all configurations should be stored
other than production configurations.  Individual users are free to store
configurations here as well as a final production template configuration.  See
the README.md file in the _configurations_ directory for more details.

`manifests`: This directory should remain empty other than the README.md file
that exists in it.  When manifest files are generated from template files, the
resulting manifest files will be stored here for deployment.

`templates`: This directory is where all application templates should be stored
for your project.  See the README.md in the templates directory for details on
the template format and requirements.


**Tools**

`create-manifests`: This script should be used to create deployment
manifest files from a combination of a configuration file and the template
manifest files.  Three command line options are supported: *--create,
--purge, --merge*.  Either create or purge must be provided.  The create
option requires the path to a configuration file as an argument.
The purge option will remove all generated manifest files from the
manifests directory.  The merge option is optional and if used will
merge all manifests into a single master manifest file that can be used
for large deployments.

`create-services`: This script will create all the services defined in the
configuration for you.  Existing services in the org/space will be checked
to verify that the service does not already exist. To run the script,
the *--config* option must be specified with an argument of the path
to the config file.  The script will create the services and poll every
60 seconds until all services are ready.  This may take as long as 30-40
minutes depending on the services and options in the configuration file.

`get-credentials`: This script will extract the credentials for an existing
service and display them on the console.  This should not be required, but
there are some cases where things like a database need to be accessed directly
by a user to do something like loading some schema or other service-specific
operation.  The get-credentials script requires two options: *--config*, which
accepts the path to one of the configuration files in the _configurations_
directory as an argument, and *--service-name*, which should be the name of
the service you want to get credentials for.


**Developer Responsibilities**

Developers are responsible for the following:

- Providing deployment templates for the applications that are part of
this deployment.  A default configuration for the template should also be
provided in the _configurations_ directory.

- Creating a README file in the top-level directory with a naming convention
of *README-<deployment name>.md*.  This file should succinctly and clearly
describe all of the information needed to deploy the system.  If you have
special instructions for SQL updates, clearly state this in the top-level
README and provide detailed deployment instructions in the _sql_ directory.
**IMPORTANT**: this must be a plain text file (the use of Markdown syntax
is encouraged but not required). It is not acceptable to provide a Microsoft
Word document or PowerPoint deck filled with unreadable screenshots or any
other binary file format for this purpose.

- Providing clear placeholders in a production configuration in the
_configurations_ directory (even for production or staging deployments
that you are not responsible for directly deploying). See the README.md
file in the _configurations_ directory for more details.  If you are only
working on a single application in a large deployment, it is still _your_
responsibility to provide the configuration settings for the application
you are working on.

Developers can and should use this system to deploy development releases.
If you are developing and testing on your workstation *you are doing
it wrong*.  In some cases, developers may even deploy code to staging or
production but this will vary program by program.


**Operator Responsibilities**

Operators are responsible for filling in production details in the production
configuration file that is part of the handoff to operations.  Generating
manifests for production deployment is an operations responsibility.
Operations will also be responsible for executing any special instructions
that have been provided as part of the README files delivered in the handoff.

#### Deployment steps ####
```
Example:
    sh auto_deploy.sh [cloud foundry username] [cloud foundry password] [docker user name] [docker user password] [docker registry] [docker image tag] [route prefix] [domain] [docker image release version] [cf org name] [cf space name] [cf api host] [cf login host] [cf vault instance name] [postgres instance name] [rabbitmq instance name] [logdrainurl] [updatevault] [updatsmokevault] 

positional arguments:
  cfusername                        Provide cf username
  cfpassword	                    Provide cf password
  dockerusername 	            Provide docker username
  dockerpassword 	            Provide docker password
  dockerregistry	            Provide docker regstry name
  dockerimagetag	            Provide docker imagetag
  routeprefix	                    Provide route prefix
  domain	                    Provide domainname
  dockerImageVersion                Provide the dockerimage version 
  orgname	                    Provide cf org
  spacename	                    Provide cf space
  apihost	                    Provide apihost 
  loginhost	                    Provide loginhost
  vaultinstance	                    Provide vaultinstance name
  postgresinstance	            Provide postgres instance name
  rabbitmqinstance	            Provide rabbitmq instance name
  logdrainurl		            Provide logdrain URL for the log service integration
  updatevault                       Enter Y/N to write deployment data to vault
  updatesmokevault                  Enter Y/N to write smoke data to vault

optional arguments:  
  -h, --help        show this help message and exit
```