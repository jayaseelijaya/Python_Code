#!/usr/bin/env python
# pylint: disable=invalid-name
#
# This is disabled due to the use of single character variable names
# within context managers and list comprehensions.  Single character
# variables are acceptable in these use cases where the intent is
# clear within a couple of lines of code.
"""This script will generate Cloud Foundry manifest files based on an
environment configuration stored in a yaml file in the local directory.  The
configuration filename should be passed in with --config option and must
adhere to the format specified in the README in this project.  All manifest
files can also be merged into a single master manifest for ease of deployment
on larger projects with the --merge argument.  All generated manifests can
also be removed by using the --clean argument.
"""
from __future__ import print_function
import re
import os
import argparse
import logging
import yaml
from jinja2 import Environment, FileSystemLoader


TEMPLATE_PATH = './templates'
MANIFEST_PATH = './manifests'
BASE_MANIFEST = os.path.join(MANIFEST_PATH, 'base_manifest.yml')
MASTER_MANIFEST = os.path.join(MANIFEST_PATH, 'master_manifest.yml')


logging.basicConfig(
    level=logging.DEBUG,
    format='%(asctime)s %(levelname)s %(message)s',
    filename='./deploy.log',
    filemode='a'
)

def log(msg):
    """Simple logging function.

    Simple function to print and log events during processing of manifest
    files.  The log file will be written to ./deploy.log.

    Args:
        msg (str): A log message.
    """
    print(msg)
    logging.debug(msg)


def purge(template_names):
    """Cleans all generated manifest files from the manifest directory.

    This will remove all generated manifest files from the MANIFEST_PATH.
    Only manifest files that have corresponding template files will be
    removed.  The one exception to this is the master manifest file since
    it is generated from other manifests and not from a template.

    Args:
        template_names (list[str]): A list of template names that is used
            to generate manifest names that should be removed.
    """
    if os.path.isdir(MANIFEST_PATH):

        for template_name in template_names:
            manifest_name = '.'.join(template_name.split('.')[:2])
            manifest_file = os.path.join(MANIFEST_PATH, manifest_name)
            try:
                os.remove(manifest_file)
            except OSError:
                pass
            log('Removing {0}'.format(manifest_file))
        for manifest in (MASTER_MANIFEST, BASE_MANIFEST):
            if os.path.isfile(manifest):
                os.remove(manifest)
                log('Removing {0}'.format(manifest))
        log('All generated manifests have been removed.')
    else:
        log('Manifest directory does not exist.')


def render_manifests(config_file, template_names, dockerUsername, dockerRegistry, dockerImageTag,routePrefix, dockerImageVersion):
    """Renders all template files into usable manifest files.

    This function will take the base config file and a list of template names
    to use for generating manifest files.  Templates must be valid jinja2
    templates and the config file must be a yaml file with the required data
    for the templates.  Templates are expected to exist in the TEMPLATE_PATH
    directory and generated manifests will be output to the MANIFEST_PATH
    directory.

    Args:
        config_file (str): The path to the yaml config file needed to render
            the manifest templates.
        template_names (list[str]): A list containing the names of the
            template files to render.
    """
    if not os.path.isdir(MANIFEST_PATH):
        os.mkdir(MANIFEST_PATH)
    with open(config_file) as _f:
        config = yaml.load(_f.read(),Loader=yaml.FullLoader)
        for apps in config['apps']:
            log("apps: "+apps)
            for key in config['apps'][apps].keys():
                if routePrefix != 'ci':
                    if key.find("route") != -1:
                        config['apps'][apps][key] = routePrefix + '-' + str(config['apps'][apps][key])
                        log(config['apps'][apps][key])
                    elif key.find("cf_app_name") != -1:
                        config['apps'][apps][key] = routePrefix + '-' + str(config['apps'][apps][key])
                        log(config['apps'][apps][key])
    j2 = Environment(loader=FileSystemLoader(TEMPLATE_PATH), trim_blocks=True)
    for template_name in template_names:
        config["docker_username"] = dockerUsername
        config["version_tag"] = dockerImageVersion
        config["docker_image"] = dockerRegistry +'/'+ dockerImageTag + '/' + template_name.replace(".yml.j2", "") + ':' + dockerImageVersion
        template = j2.get_template(template_name)
        manifest_contents = template.render(**config)
        manifest_name = '.'.join(template_name.split('.')[:2])
        manifest_file = os.path.join(MANIFEST_PATH, manifest_name)
        with open(manifest_file, 'w') as f:
            log('Generating {0}'.format(manifest_file))
            f.write(manifest_contents)
    log('Completed manifest generation.')


def merge_manifests():
    """Merges all manifests into a single master manifest for easy deployment.

    When this option is used all generated manifests will be merged into
    a single manifest file called master_manifest.yml.  The contents of
    base_manifest will be used as the base manifest and the applications
    section of all other manifests will be merged into the applications
    section of the master_manifest file.
    """
    manifests = [
        os.path.join(MANIFEST_PATH, f)
        for f in os.listdir(MANIFEST_PATH)
        if re.match(r'^[0-9]', f)
    ]

    applications = []
    for manifest in manifests:
        manifest_data = yaml.load(open(manifest, 'r').read())
        for a in manifest_data['applications']:
            log('Merging {0} into master_manifest.yml.'.format(manifest))
            applications.append(a)
    with open(BASE_MANIFEST, 'r') as f:
        merged_manifest = yaml.load(f.read())
    merged_manifest['applications'] = applications
    with open(MASTER_MANIFEST, 'w') as f:
        log('Writing master_master.yml.')
        f.write(yaml.dump(merged_manifest, default_flow_style=False))
    log('Successfully merged all manifest files into master_manifest.yml')


def parse_args():
    """Parse command line args.

    Simple function to parse and return command line args.

    Returns:
        argparse.Namespace: An argparse.Namespace object.
    """
    parser = argparse.ArgumentParser()
    required_arg = parser.add_argument_group(
        'Action', 'One of these args is required.')
    action = required_arg.add_mutually_exclusive_group(required=True)
    action.add_argument('-c',
                        '--create',
                        dest='create',
                        default=None,
                        required=False,
                        help='Create manifest files from a config file.')
    action.add_argument('-p',
                        '--purge',
                        dest='purge',
                        required=False,
                        default=False,
                        action='store_true',
                        help='Purge all generated manifests')
    opts = parser.add_argument_group('Optional Arguments', '')
    opts.add_argument('--merge',
                      dest='merge',
                      required=False,
                      default=False,
                      action='store_true',
                      help='Merge all generated manifests to create a master '
                           'deployment manifest.')
    parser.add_argument('-dockerUsername',
                        dest='dockerUsername',
                        default=None,
                        help='Pass Docker User Name')
    parser.add_argument('-dockerRegistry',
                        dest='dockerRegistry',
                        default=None,
                        help='Pass Docker registry value')
    parser.add_argument('-dockerImageTag',
                        dest='dockerImageTag',
                        default=None,
                        help='Pass Docker image release tag')
    parser.add_argument('-routePrefix',
                        dest='routePrefix',
                        default=None,
                        help='Pass route prefix for each app')
    parser.add_argument('-dockerImageVersion',
                        dest='dockerImageVersion',
                        default=None,
                        help='Pass Docker image release version')
    args = parser.parse_args()
    return args


def main():
    """Main entry point.
    """
    args = parse_args()
    template_names = [x for x in os.listdir(TEMPLATE_PATH) if x.endswith('.j2')]
    if args.purge:
        purge(template_names)
    elif args.create:
        render_manifests(args.create, template_names, args.dockerUsername,args.dockerRegistry,args.dockerImageTag,args.routePrefix,args.dockerImageVersion)
        if args.merge:
            merge_manifests()


if __name__ == '__main__':
    main()