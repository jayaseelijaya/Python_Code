/*

(C) Koninklijke Philips Electronics N.V. 2021
All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
the copyright owner.

 */
package com.philips.research.fhdl.common.iam;

import static com.philips.research.fhdl.common.constants.Constants.HSDP_ENDPOINT_GET_IAM_ACCESS_TOKEN;
import static com.philips.research.fhdl.common.exception.CustomExceptionMessages.IAM_ACCESSTOKEN_API_FAILED;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import com.philips.research.fhdl.common.constants.Constants;
import com.philips.research.fhdl.common.dto.IAMAccessToken;
import com.philips.research.fhdl.common.exception.CustomExceptionHandler;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author Reshmy R
 *
 */

@Log4j
@Service
public class HSDPIAMService {

	private static Logger log = LoggerFactory.getLogger(HSDPIAMService.class);
	RestTemplate restTemplate = new RestTemplate();
	static String validateUrl = System.getProperty("iam_validate_url");
	static String iamAuthUser = System.getProperty("iam_auth_username");
	static String iamAuthPass = System.getProperty("iam_auth_password");
	private static final String ERROR_MESSAGE = "...{}";
	private static final String ACTIVE = "active";

	/**
	 * 
	 * @return iamAccessToken
	 */
	public String getIAMAccessToken(String serviceId, String privateKey, String iamHostUrl) {
		String iamAccessToken = null;
		try {
			String jwtToken = JWTTokenGenerator.generateJWTToken(iamHostUrl, serviceId, privateKey);
			iamAccessToken = exchangeJWTTokenForIAMAccessToken(jwtToken, iamHostUrl);
		} catch (Exception exception) {
			log.error(IAM_ACCESSTOKEN_API_FAILED + ERROR_MESSAGE, exception.getMessage());
		}

		return iamAccessToken;
	}

	/**
	 * 
	 * Exchange a JWT token for an IAM access token with HSDP services
	 * 
	 * @param jwtToken
	 * @return iamAccessToken
	 * @throws IOException
	 */
	private String exchangeJWTTokenForIAMAccessToken(String jwtToken, String iamHostUrl) throws IOException {
		log.info("Exchanging the JWT token for an IAM access token with HSDP...");
		String iamAccessToken = "";
		try {
			// prepare headers
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.add(Constants.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
			headers.add(Constants.API_VERSION, Constants.API_VERSION_VALUE_2);
			Map<String, String> requestFormBody = new HashMap<>();
			requestFormBody.put(Constants.FORM_KEY_GRANT_TYPE, Constants.FORM_VALUE_JWT_BEARER);
			requestFormBody.put(Constants.FORM_KEY_ASSERTION, jwtToken);
			String requestBody = constructRequestBodyStringFromForm(requestFormBody);
			HttpEntity<String> requestEntity = new HttpEntity<String>(requestBody, headers);
			ResponseEntity<IAMAccessToken> result = restTemplate.exchange(
					iamHostUrl + HSDP_ENDPOINT_GET_IAM_ACCESS_TOKEN, HttpMethod.POST, requestEntity,
					IAMAccessToken.class);
			IAMAccessToken accessToken = result.getBody();
			if (null != accessToken) {
				iamAccessToken = accessToken.getAccessToken();
			}
		} catch (HttpClientErrorException httpException) {
			log.error(IAM_ACCESSTOKEN_API_FAILED + ERROR_MESSAGE, httpException.getMessage());
		} catch (Exception exception) {
			log.error(IAM_ACCESSTOKEN_API_FAILED + ERROR_MESSAGE, exception.getMessage());
		}

		log.info("Exchanged the JWT token for an IAM access token with HSDP");
		return iamAccessToken;
	}

	/**
	 * converts form data into a String formatting it as required for a request body
	 * 
	 * @param form
	 * @return requestBody
	 */
	private String constructRequestBodyStringFromForm(Map<String, String> form) {
		StringBuilder requestBody = new StringBuilder();
		for (Map.Entry<String, String> formEntry : form.entrySet()) {
			requestBody.append(Constants.AMPERSAND);
			requestBody.append(formEntry.getKey()).append(Constants.EQUALS_TO).append(formEntry.getValue());
		}
		// substring(1) removes the unwanted AMPERSAND character at the beginning
		return requestBody.length() == 0 ? null : requestBody.substring(1);
	}

	/**
	 * Validate the requested token.
	 * 
	 * @param token
	 * @return Object
	 */
	public static Object validateIAMToken(String token) throws IOException, JSONException {

		HttpsURLConnection connection = null;
		Object object = null;
		String output = null;
		String valiadateUrl = validateUrl;

		String auth = iamAuthUser + ":" + iamAuthPass;
		final String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
		String authHeaderValue = "Basic " + new String(encodedAuth);
		String data = "token=" + token;
		URL url = new URL(valiadateUrl);
		connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setInstanceFollowRedirects(false);
		connection.setRequestProperty("Content-Type", Constants.IAM_CONTENT_TYPE);
		connection.setRequestProperty("charset", Constants.IAM_CHARSET);
		connection.setRequestProperty("Authorization", authHeaderValue);
		connection.setDoOutput(true);
		PrintStream os = new PrintStream(connection.getOutputStream());
		os.print(data);
		
		BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
		StringBuilder sb = new StringBuilder();

		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		String response = sb.toString();
		JSONObject jsonObject = new JSONObject(response);
		Object aObj = jsonObject.get(ACTIVE);
		
		if (aObj instanceof String) {
			String active = jsonObject.getString(ACTIVE);
			object = active;
		}
		if (aObj instanceof Boolean) {
			boolean active = jsonObject.getBoolean(ACTIVE);
			object = active;
		}
		return object;
	}

	/**
	 * Generate IAM Token.
	 * 
	 * @param iamUrl
	 * @param iamAuthUsername
	 * @param iamAuthPassword
	 * @param iamGrantUsername
	 * @param iamGrantPassword
	 * @return token
	 */
	public static String generateIamToken(String iamUrl, String iamAuthUsername, String iamAuthPassword,
			String iamGrantUsername, String iamGrantPassword) {
		Pattern pat = Pattern.compile(Constants.TOKEN_PATTERN);
		final String auth = iamAuthUsername + ":" + iamAuthPassword;
		final String authentication = Base64.getEncoder().encodeToString(auth.getBytes());
		
		String content = "grant_type=password&username=" + iamGrantUsername + "&password=" + iamGrantPassword;
		BufferedReader reader = null;
		HttpsURLConnection connection = null;
		String accessToken = "";
		StringBuilder sb = new StringBuilder();
		StringBuilder sbContent = new StringBuilder();
		sb.append("Basic ");
		sb.append(authentication);
		sbContent.append(content);
		try {
			URL url = new URL(iamUrl);
			connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", sb.toString());
			connection.setRequestProperty("Content-Type", Constants.IAM_CONTENT_TYPE);
			connection.setRequestProperty("api-version", "1");
			PrintStream os = new PrintStream(connection.getOutputStream());
			os.print(sbContent);
			os.close();

			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;
			StringWriter out = new StringWriter(
					connection.getContentLength() > 0 ? connection.getContentLength() : 2048);
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			String response = out.toString();
		
			Matcher matcher = pat.matcher(response);
			if (matcher.matches() && matcher.groupCount() > 0) {
				accessToken = matcher.group(1);
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return accessToken;
	}
}
