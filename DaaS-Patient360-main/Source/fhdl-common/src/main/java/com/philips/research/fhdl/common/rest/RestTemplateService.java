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
package com.philips.research.fhdl.common.rest;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.philips.research.fhdl.common.iam.JWTTokenGenerator;
import com.philips.research.fhdl.common.utility.Constants;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RestTemplateService {

	RestTemplate restTemplate = new RestTemplate();
	UriComponents components = null;
	HttpHeaders header = new HttpHeaders();
	ResponseEntity<String> response = null;
	MultiValueMap<String, String> queryParamsMap = new LinkedMultiValueMap<>();
	public static final String GET_RESPONSE_FAILURE_MESSAGE = "Failed to get response";
	private static Logger log = LoggerFactory.getLogger(RestTemplateService.class);

	public ResponseEntity<String> getResponse(String url, Map<String, String> httpHeaders) {

		// Set Contentype to json
		header.setContentType(MediaType.APPLICATION_JSON);
		try {
			// Iterate map for header key value, set in the http headers.
			for (Map.Entry<String, String> entry : httpHeaders.entrySet()) {
				header.add(entry.getKey(), entry.getValue());
			}

			HttpEntity<String> entity = new HttpEntity<>("header", header);

			components = UriComponentsBuilder.fromHttpUrl(url).build();

			response = restTemplate.exchange(components.toString(), HttpMethod.GET, entity, String.class);

			return response;
		} catch (Exception exc) {
			log.error(exc.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(GET_RESPONSE_FAILURE_MESSAGE);
		}

	}

	public static ResponseEntity<String> getResponseAfterServiceCall(String url, HttpMethod httpMethod,
			HttpEntity<String> request) {
		return new RestTemplate().exchange(url, httpMethod, request, String.class);
	}

	/**
	 * Gets the REST response.
	 *
	 * @param <T>          the generic Class type
	 * @param resourceUrl  the resource url
	 * @param httpMethod   the http method
	 * @param request      the HTTP request with form data
	 * @param responseType the response type
	 * @return the REST response
	 * @throws IOException
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 * @throws RestClientException
	 */
	public static <T> ResponseEntity<T> getRestResponse(String resourceUrl, HttpMethod httpMethod,
			HttpEntity<MultiValueMap<String, String>> request, Class<T> responseType)
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
		String deploymentMode = System.getenv(Constants.DEPLOYMENT);
		if (Constants.DEPLOYMENT_CLOUD.equalsIgnoreCase(deploymentMode)) {
			return new RestTemplate().exchange(resourceUrl, httpMethod, request, responseType);
		} else {
			CloseableHttpClient httpClient = null;
			try {
				TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
				SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
				SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
				httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
				HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
				clientHttpRequestFactory.setHttpClient(httpClient);
				return new RestTemplate(clientHttpRequestFactory).exchange(resourceUrl, httpMethod, request,
						responseType);
			} finally {
				if (httpClient != null) {
					httpClient.close();
				}
			}

		}
	}

}
