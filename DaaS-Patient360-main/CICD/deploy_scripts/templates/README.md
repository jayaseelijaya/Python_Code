HSDP Deployment Template for Cloud Foundry: Manifest Templates
===============================================================

This directory is where all manifest templates should be stored for your
project. Templates are written in YAML and use the Jinja2 template engine
to render configuation data into finished manifest files which can be used
to deploy Cloud Foundry applications.  Two types of manifest templates are
supported: 'base' and 'application-specific', both of which are explained
in the sections below.

## Base Manifest

Contains common attributes used across the entire deployment

**Example:**

```
domain: {{ domain }}
memory: 1G
instances: 2
services:
 - {{ services.newrelic.service_name }}
 - {{ services.logging.service_name }}
{% if base is defined and 'env' in base -%}
{{ 'env:' }}
{% for k, v in base.env.iteritems() %}
{{ k }}: {{ v }}
{% endfor %}
{% endif %}
```

The `services` key specifies a list of services needed for the deployment. In
this example, we've specified logging and NewRelic services for all
applications in this deployment. Refer to configurations/README.md for
details on how services are defined.

## Application Manifest

Individual applications inherit data from the base manifest. Here we can
define application-specific attributes (note that values specified here
will override values from the base manifest).

**Example:**

```
{% if app_name is not defined -%}
{% set app_name = {} -%}
{% endif -%}
---
inherit: base_manifest.yml
applications:
  - name: app_name-{{ version }}-{{ blue_green }}
    memory: 1G
    host: app_name-{{ version|replace('.','') }}-{{ blue_green }}
    path: ../binary/app_name/app_name-{{ version }}-RELEASE.war
    buildpack: {{ app_name.buildpack|default(default_buildpack) }}
    services:
      - {{ services.<service_name_1>.service_name }}
      - {{ services.<service_name_2>.service_name }}
      - {{ services.<service_name_n>.service_name }}
    {% if 'env' in app_name -%}
      {{ 'env:' }}
    {% for k, v in app_name.env.iteritems() -%}
      {{ k|indent(2, true) }}: {{ v }}
    {% endfor %}
    {% endif %}
```

Note that here, 'app_name' is just an example, it should match the
top-level key name used for application-specific configuration in the
deployment configuration file.

In the `services` key, specify a list of services required by the
application using the pattern shown (substitute appropriate values from
the `services` section of the deployment configuration file for the
string '`<service_name_*>`')

