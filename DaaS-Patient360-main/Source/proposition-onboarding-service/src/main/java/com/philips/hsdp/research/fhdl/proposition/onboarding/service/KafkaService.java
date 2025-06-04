/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.fhdl.proposition.onboarding.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.philips.hsdp.research.fhdl.proposition.onboarding.model.ResourceTopicRequest;

/* @author Srinivasa Reddy */
@Service
public class KafkaService {
	@Autowired
	private RestTemplate restTemplate;
	private String resourceUrl = System.getProperty("resource_Url");

	public ResponseEntity<String> createTopic(ResourceTopicRequest resourceTopicRequest) {

		HttpHeaders headers = new HttpHeaders();
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(resourceUrl)
				.queryParam("orgName", resourceTopicRequest.getOrgName())
				.queryParam("deptName", resourceTopicRequest.getDeptName())
				.queryParam("profileName", resourceTopicRequest.getProfileName());
		HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(new HashMap<>(), headers);
		ResponseEntity<String> topicResponse = null;

		topicResponse = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, String.class);
		return topicResponse;
	}
}