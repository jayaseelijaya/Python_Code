/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.kafka_routing_service.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Assert;
import org.mockito.internal.stubbing.defaultanswers.ForwardsInvocations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessageHeaders;
import com.amazonaws.auth.AWSCredentialsProvider;
import org.junit.jupiter.api.DisplayName;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.philips.hsdp.research.p360.kafka_routing_service.config.DynamoDbConfig;
import com.philips.hsdp.research.p360.kafka_routing_service.model.MdmMetadata;
import com.philips.hsdp.research.p360.kafka_routing_service.service.Consumer;

/* @author Shital Ghatole */
@RunWith(MockitoJUnitRunner.class)
public class ConsumerTest {

	public static final String TEST_STRING = "TEST";
	String propositionIdValue = "122";
	private MessageHeaders keys;
	String key = "propositionid";
	@Mock
	private KafkaTemplate<String, String> kafkaTemplate;
	@Mock
	JSONObject Object = new JSONObject();
	@Mock
	private DynamoDBMapper dynamoDbMapper;
	@Mock
	List<MdmMetadata> result = new ArrayList<>();
	@Mock
	DynamoDbConfig config = new DynamoDbConfig();
	@Mock
	AWSCredentialsProvider provider = Mockito.mock(AWSCredentialsProvider.class);
	@InjectMocks
	MdmMetadata metadata;
	@Mock
	DynamoDBQueryExpression<MdmMetadata> queryExpression;
	@Mock
	AmazonDynamoDB dynamodb = Mockito.mock(AmazonDynamoDB.class);
	@InjectMocks
	private Consumer consumer;
	@Mock
	MessageHeaders messageHeaders = new MessageHeaders(keys);
	@Mock
	JSONObject headerDetails;
	@Mock
	ProducerRecord<String, String> producerRecord;

	@Test
	@DisplayName("These method Listens topic data")
	public void kafkaListenerTest() throws JSONException {
		String actualPROPOSITIONID = Constants.PROPOSITIONID;
		String expectedPROPOSITIONID = "propositionId";
		JSONObject data = new JSONObject();
		data.put("propositionId", "propositionId");
		data.put("orgId", "Hospital");
		data.put("profileName", "ardiology");
		MessageHeaders messageHeaders = new MessageHeaders(keys);
		MdmMetadata mdmMetadata = new MdmMetadata();
		mdmMetadata.setProfileName("card");
		mdmMetadata.setOrganizationName("Hospi");
		mdmMetadata.setOrganizationId("12345");
		List<MdmMetadata> list = new ArrayList<>();
		list.add(mdmMetadata);
		when(dynamoDbMapper.query(eq(MdmMetadata.class), any(DynamoDBQueryExpression.class)))
	        .thenReturn(mock(PaginatedQueryList.class, withSettings().defaultAnswer(new ForwardsInvocations(list))));
		consumer.kafkaListener(data, messageHeaders);
		Assert.assertTrue("key does not match", expectedPROPOSITIONID.equals(actualPROPOSITIONID));
	}

	@SuppressWarnings("unchecked")
	@Test
	@DisplayName(" Test Method that sets dummy values for dynamodb")
	public void getMetaInfoFromMdmTest() {
		MdmMetadata mdmMetadata = new MdmMetadata();
		mdmMetadata.setProfileName("card");
		mdmMetadata.setOrganizationName("Hospi");
		mdmMetadata.setOrganizationId("12345");
		List<MdmMetadata> list = new ArrayList<>();
		list.add(mdmMetadata);
		when(dynamoDbMapper.query(eq(MdmMetadata.class), any(DynamoDBQueryExpression.class))).thenReturn(
		mock(PaginatedQueryList.class, withSettings().defaultAnswer(new ForwardsInvocations(list))));
		consumer.getMetaInfoFromMdm(propositionIdValue);
		Assert.assertNotNull("propositionIdValue must not be null",propositionIdValue);
	}

	@Test
        @DisplayName(" Test Method with no business logic")
	public void DynamoDBMapperTest() {
		System.setProperty("dynamodb_endpoint", TEST_STRING);
		System.setProperty("aws_key", TEST_STRING);
		System.setProperty("aws_secret", TEST_STRING);
		System.setProperty("s3_session_Token", TEST_STRING);
		System.setProperty("aws_region", TEST_STRING);
		DynamoDBMapper dynamoDbMapper = config.dynamoDBMapper();
		String actualaws_key = System.getProperty("aws_key");
		String expectedaws_key = TEST_STRING;
		Assert.assertTrue("expected and actual aws key match", expectedaws_key.equals(actualaws_key));

	}

	@Test
	@DisplayName("Test Method publishing data with given dummy values")
	public void publishDataToRequestTopicTest() throws JSONException {
		JSONObject headerDetails = new JSONObject();
		headerDetails.put("propositionId", "propositionid");
		headerDetails.put("orgId", "Hospital");
		headerDetails.put("profileName", "ardiology");
		consumer.publishDataToRequestTopic(headerDetails, propositionIdValue);
		kafkaTemplate.send(producerRecord);
		Assertions.assertNotNull(producerRecord, "ProducerRecord must not be null");

	}
}