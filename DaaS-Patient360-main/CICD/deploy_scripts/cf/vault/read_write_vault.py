from argparse import ArgumentParser
from argparse import RawTextHelpFormatter
from vault_operations import MyVault
from get_key import *
import json

def parse_args():
    """This function is to parse the arguments from command line"""
    parser = ArgumentParser(description='Vaultification of Service Secrets:',
                            formatter_class=RawTextHelpFormatter)

    parser.add_argument("cf_user",
                        help="Provide CF User Name")
    parser.add_argument("cf_pwd",
                        help="Provide CF Password")
    parser.add_argument("cf_org",
                        help="Provide CF Org Name")
    parser.add_argument("cf_space",
                        help="Provide CF Space")
    parser.add_argument("cf_vault_service",
                        help="Provide CF Vault Service Name")
    parser.add_argument("cf_url",
                        help="Provide CF URL. Example: api.cloud.pcftest.com")
    parser.add_argument("file_path",
                        help="Provide file you want to upload to vault or download to a local location")
    parser.add_argument("vault_path",
                        help="Provide a path where to upload or download from vault. Example: config")
    parser.add_argument("vault_endpoint",
                         help="Provide public endpoint of vault service. Example: http://130.157.125.34:8080")
    parser.add_argument("option",
                        choices=["w", "write", "r", "read"],
                        help="Provide one of the following options:\n"
                             "w or write for writing configurations in vault\n"
                             "r or read for reading configurations from vault and store in file_path location")
    args = parser.parse_args()
    return args


def main():
    args = parse_args()

    try:
        key = cf_get_key('https://' + args.cf_url,
                         args.cf_user,
                         args.cf_pwd,
                         args.cf_org,
                         args.cf_space,
                         args.cf_vault_service)

        # client will be returned and same can be used in future methods for write and read
        client = MyVault.create_client(args.vault_endpoint,
                                       key['role_id'],
                                       key['secret_id'])

        if args.option.lower() == 'w' or args.option.lower() == 'write':
            print("To Write File in Vault")
            MyVault.write_json_config_file(client,
                                      key['service_secret_path'].strip('v1/') + '/' + args.vault_path,
                                      args.file_path)
            print('File is Uploaded. Vault Path: ' + args.vault_path)
	
        elif args.option.lower() == 'r' or args.option.lower() == 'read':
            print('To Read file from Vault and store in local path.')
            config_obj = MyVault.read_json_config_file(client,
                                                  key['service_secret_path'].strip('v1/') + '/' + args.vault_path)
            with open(args.file_path, 'w') as outfile:
                json.dump(config_obj, outfile, indent=2)
            print('File is Downloaded. File Location: ' + args.file_path)
    except Exception as e:
        print("error Occured as :", e)


if __name__ == '__main__':
    main()
