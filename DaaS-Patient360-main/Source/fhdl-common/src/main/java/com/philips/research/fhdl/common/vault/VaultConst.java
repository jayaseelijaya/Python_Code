/*
  * (C) Koninklijke Philips Electronics N.V. 2021
  *
  * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  * the copyright owner.
  * 
  * @author Hasarani S
  * 
  */
package com.philips.research.fhdl.common.vault;

public class VaultConst {

	private VaultConst() {
		throw new IllegalStateException("VaultConst class");
	}

	public static final String VAULT_AUTH_URL = "v1/auth/approle/login";
	public static final String VCAP_SERVICES = "VCAP_SERVICES";
	public static final String HSDP_VAULT = "hsdp-vault";
	public static final String VCAP_CREDENTIALS = "credentials";
	public static final String VCAP_SERVICES_SECRET_PATH = "service_secret_path";
	public static final String VCAP_ROLE_ID = "role_id";
	public static final String VCAP_SECRET_ID = "secret_id";
	public static final String VCAP_ENDPOINT = "endpoint";
	public static final String VCAP_AUTH = "auth";
	public static final String CLIENT_TOKEN = "client_token";
	public static final String VAULT_TOKEN = "X-Vault-Token";
	public static final String VAULT_DATA = "data";
	public static final String CONFIGURATION_VAULT_PRIVATE_KEY = "fhdl-vault-key";

}
