/*
  * (C) Koninklijke Philips Electronics N.V. 2022
  *
  * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  * the copyright owner. 
  */
package com.philips.hsdp.research.fhdl.proposition.onboarding.service;

import static org.junit.Assert.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.philips.hsdp.research.fhdl.proposition.onboarding.model.ResourceTopicRequest;

/* @author Srinivasa Reddy Bijjam*/
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
 class KafkaServiceTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	KafkaService kafkaService;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		System.setProperty("resource_Url", "http://43.205.232.198:8000/createkafkatopics");
	}

	@Test
	@DisplayName("This Test case is to create the kafka topic")
	 void createTopic_Test() {
		Mockito.when(restTemplate.exchange(
				"http://43.205.232.198:8000/createkafkatopics?orgName=hospital&deptName=cardiology&propositionName=PD-DID-P3",
				HttpMethod.POST, null, String.class)).thenReturn(ResponseEntity.ok("Topic created successsfully"));

		ResourceTopicRequest resourceTopicRequest = ResourceTopicRequest.builder().deptName("cardiology")
				.orgName("hospital").propositionName("PD-DID-P3").build();
		assertNull(kafkaService.createTopic(resourceTopicRequest));
	}
}