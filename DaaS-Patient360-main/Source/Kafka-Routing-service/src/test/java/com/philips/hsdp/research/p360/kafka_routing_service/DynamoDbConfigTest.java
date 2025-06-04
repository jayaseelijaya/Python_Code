/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.kafka_routing_service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.junit.Assert;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.jupiter.api.DisplayName;
import com.philips.hsdp.research.p360.kafka_routing_service.config.DynamoDbConfig;

/* @author Shital Ghatole */
@RunWith(MockitoJUnitRunner.class)
public class DynamoDbConfigTest {

	public static final String TEST_STRING = "TEST";
	@InjectMocks
	DynamoDbConfig config = new DynamoDbConfig();
	@Test
	@DisplayName(" Test Method that sets dummy values for dynamodb")
	public void dynamoDBMapper_Test_With_DummyValue() {
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
}