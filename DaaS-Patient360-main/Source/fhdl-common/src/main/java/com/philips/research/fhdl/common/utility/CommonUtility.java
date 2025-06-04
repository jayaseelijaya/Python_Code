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

package com.philips.research.fhdl.common.utility;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.philips.research.fhdl.common.vault.VaultService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class CommonUtility {

	public static final String USER_NAME = "username";
	private static String auditVaultKey = "fhdl-vault-key";
	private static JSONObject auditVaultJson = null;

	private CommonUtility() {

	}

	/**
	 * Retrieve the data from vault
	 * 
	 * @return ConfigKey
	 */
	public static JSONObject getAuditVaultJson() {
		if (auditVaultJson == null) {
			String token = VaultService.getTokenFromVault();
			auditVaultJson = VaultService.getDataFromVault(token, auditVaultKey, false);
		}
		return auditVaultJson;

	}

	public static String getEnvValue(String key) {
		return System.getenv().get(key);
	}
}
