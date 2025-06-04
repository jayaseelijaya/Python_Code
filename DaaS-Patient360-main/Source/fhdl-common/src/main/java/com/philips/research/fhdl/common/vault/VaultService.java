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

import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

import com.philips.research.fhdl.common.rest.RestTemplateService;
import com.philips.research.fhdl.common.utility.CommonUtility;
import com.philips.research.fhdl.common.vault.VaultConst;
import com.philips.research.fhdl.common.vault.VaultService;
import com.philips.research.fhdl.common.exception.CustomException;
import com.philips.research.fhdl.common.exception.CustomExceptionHandler;
import static com.philips.research.fhdl.common.exception.CustomExceptionMessages.MISSING_ENV_VARIABLE;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class VaultService {
	private static Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

	private VaultService() {

	}

	// retrieve vault token
	public static String getTokenFromVault() {
		try {
			JSONObject vaultJsCredObj = getVaultDetails();
			String roleId = vaultJsCredObj != null ? ((String) vaultJsCredObj.get(VaultConst.VCAP_ROLE_ID)) : null;
			String secretId = vaultJsCredObj != null ? (String) vaultJsCredObj.get(VaultConst.VCAP_SECRET_ID) : null;
			String endpoint = vaultJsCredObj != null ? (String) vaultJsCredObj.get(VaultConst.VCAP_ENDPOINT) : null;
			System.out.println("Details:::::"+roleId);
			System.out.println("Details:::::"+secretId);
			System.out.println("Details:::::"+endpoint);

			if (roleId != null && secretId != null && endpoint != null) {
				HttpHeaders headers = new HttpHeaders();
				headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
				JSONObject personJsonObject = new JSONObject();
				personJsonObject.put(VaultConst.VCAP_ROLE_ID, roleId);
				personJsonObject.put(VaultConst.VCAP_SECRET_ID, secretId);

				if (!endpoint.endsWith("/")) {
					endpoint = endpoint + "/";
				}

				String url = endpoint + VaultConst.VAULT_AUTH_URL;
				HttpEntity<String> request = new HttpEntity<>(personJsonObject.toString(), headers);
				ResponseEntity<String> response = RestTemplateService.getResponseAfterServiceCall(url, HttpMethod.POST,
						request);

				if (response.getStatusCode() == HttpStatus.OK) {
					log.info("Token retrieved succesfully from vault");
					JSONObject vaultResponse = new JSONObject(response.getBody());
					JSONObject auth = (JSONObject) vaultResponse.get(VaultConst.VCAP_AUTH);
					return auth != null ? (String) auth.get(VaultConst.CLIENT_TOKEN) : null;
				}
			} else {
				log.info("Application is not binded with vault service");
			}
		} catch (HttpStatusCodeException e) {
			log.error(e.getMessage());

		} catch (Exception e1) {
			log.error(e1.getMessage());
		}
		return null;
	}

	// retrieve data stored in vault
	public static JSONObject getDataFromVault(String token, String vaultKeyName, boolean writeKeysToEnv) {
		try {
			JSONObject vaultJsCredObj = getVaultDetails();
			String endpoint = vaultJsCredObj != null ? (String) vaultJsCredObj.get(VaultConst.VCAP_ENDPOINT) : null;
			if (endpoint.contains("com//v1")) {
				endpoint = endpoint.substring(0, endpoint.length() - 1);
			}
			String serviceSecretPath = vaultJsCredObj != null
					? (String) vaultJsCredObj.get(VaultConst.VCAP_SERVICES_SECRET_PATH)
					: null;
			HttpHeaders headers = new HttpHeaders();
			headers.add(VaultConst.VAULT_TOKEN, token);
			HttpEntity<String> request = new HttpEntity<>(headers);

			String url = endpoint + serviceSecretPath + "/" + vaultKeyName;
			System.out.println("Details::::url::::::"+url);
			ResponseEntity<String> response = RestTemplateService.getResponseAfterServiceCall(url, HttpMethod.GET,
					request);

			JSONObject data = (response != null && response.getBody() != null) ? new JSONObject(response.getBody())
					: null;

			String storedData = data != null ? data.get(VaultConst.VAULT_DATA).toString() : null;
			JSONObject vaultData = storedData != null ? new JSONObject(storedData) : null;
			System.out.println("vaultData:::::::::::::"+vaultData);
			if (vaultData == null) {
				log.info("Unable to retrieve data from vault");
				return null;
			}
			Iterator<String> keys = vaultData.keys();

			if (writeKeysToEnv) {
				while (keys.hasNext()) {
					String key = keys.next();
					String value = vaultData.get(key).toString();
					System.setProperty(key, value);
				}
			}
			log.info("Data retrieved succesfully from vault");
			return vaultData;
		} catch (HttpStatusCodeException e) {
			log.error(e.getMessage());
		} catch (Exception e1) {
			log.error(e1.getMessage());
		}
		return null;
	}

	// store data inside vault
	public static boolean storeDataToVault(String token, String vaultKeyName, JSONObject payload) {
		try {
			JSONObject vaultJsCredObj = getVaultDetails();
			String endpoint = vaultJsCredObj != null ? (String) vaultJsCredObj.get(VaultConst.VCAP_ENDPOINT) : null;
			String serviceSecretPath = vaultJsCredObj != null
					? (String) vaultJsCredObj.get(VaultConst.VCAP_SERVICES_SECRET_PATH)
					: null;

			String url = endpoint + serviceSecretPath + "/" + vaultKeyName;
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
			headers.add(VaultConst.VAULT_TOKEN, token);
			HttpEntity<String> request = new HttpEntity<>(payload.toString(), headers);
			ResponseEntity<String> response = RestTemplateService.getResponseAfterServiceCall(url, HttpMethod.POST,
					request);
			if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
				log.info("Data stored succesfully in vault");
				return true;
			} else {
				log.info(String.format("Unable to store data in vault- %s %s", response.getStatusCode(),
						response.getBody()));
				return false;
			}

		} catch (HttpStatusCodeException e) {
			log.error(e.getMessage());

		} catch (Exception e1) {
			log.error(e1.getMessage());
		}
		return false;
	}

	// retrieve env variable from vault
	public static JSONObject getVaultDetails() throws JSONException {
		String vcapServicesStr = CommonUtility.getEnvValue(VaultConst.VCAP_SERVICES);

		JSONObject vcapServicesJson = vcapServicesStr != null ? new JSONObject(vcapServicesStr) : null;
		JSONArray vaultJSONArray = vcapServicesJson != null ? (JSONArray) vcapServicesJson.get(VaultConst.HSDP_VAULT)
				: null;
		JSONObject vaultJsonObj = vaultJSONArray != null ? (JSONObject) vaultJSONArray.get(0) : null;
		return vaultJsonObj != null ? (JSONObject) vaultJsonObj.get(VaultConst.VCAP_CREDENTIALS) : null;

	}

	public static boolean deleteDataFromVault(String token, String vaultKeyName) {
		try {
			JSONObject vaultJsCredObj = getVaultDetails();
			String endpoint = vaultJsCredObj != null ? (String) vaultJsCredObj.get(VaultConst.VCAP_ENDPOINT) : null;
			String serviceSecretPath = vaultJsCredObj != null
					? (String) vaultJsCredObj.get(VaultConst.VCAP_SERVICES_SECRET_PATH)
					: null;
			HttpHeaders headers = new HttpHeaders();
			headers.add(VaultConst.VAULT_TOKEN, token);
			HttpEntity<String> request = new HttpEntity<>(headers);

			String url = endpoint + serviceSecretPath + "/" + vaultKeyName;
			ResponseEntity<String> response = RestTemplateService.getResponseAfterServiceCall(url, HttpMethod.DELETE,
					request);

			if (response != null && response.getStatusCode() == HttpStatus.NO_CONTENT) {
				log.info("key deleted succesfully from vault");
				return true;
			} else {
				log.info("failed to delete key from vault");
				return false;
			}
		} catch (HttpStatusCodeException e) {
			log.error(e.getMessage());
		} catch (Exception e1) {
			log.error(e1.getMessage());
		}
		return false;

	}

	public static void intializeVaultProperties(List<String> vaultKeys) {

		try {
			String token = VaultService.getTokenFromVault();
			if (token == null || token.isEmpty()) {
				throw new CustomException(MISSING_ENV_VARIABLE, "Unable to Load Properties from vault");
			}

			for (String vaultKey : vaultKeys) {
				JSONObject jsonObject = VaultService.getDataFromVault(token, vaultKey, true);
				if (jsonObject == null) {
					throw new CustomException(MISSING_ENV_VARIABLE,
							"There is no Data available from Vault for vault key: " + vaultKey);
				}
				Iterator<String> keys = jsonObject.keys();

				while (keys.hasNext()) {
					String key = keys.next();
					String value = jsonObject.get(key).toString();
					System.setProperty(key, value);
				}
			}
		} catch (CustomException exception) {
			CustomExceptionHandler.handle(new CustomException(MISSING_ENV_VARIABLE, exception));
		}

	}

	public static String readConfigurationFromVault(String key) {

		String value = null;
		try {
			String token = VaultService.getTokenFromVault();
			if (token.isEmpty() || token == null) {
				throw new CustomException(MISSING_ENV_VARIABLE, "Unable to Load Properties from vault");
			}

			JSONObject jsonObject = VaultService.getDataFromVault(token, VaultConst.CONFIGURATION_VAULT_PRIVATE_KEY,
					false);
			if (jsonObject == null) {
				throw new CustomException(MISSING_ENV_VARIABLE, "There is no Data available from Vault for vault key: "
						+ VaultConst.CONFIGURATION_VAULT_PRIVATE_KEY);
			}

			value = jsonObject.get(key).toString();

		} catch (CustomException exception) {
			CustomExceptionHandler.handle(new CustomException(MISSING_ENV_VARIABLE, exception));
		}
		return value;
	}

}
