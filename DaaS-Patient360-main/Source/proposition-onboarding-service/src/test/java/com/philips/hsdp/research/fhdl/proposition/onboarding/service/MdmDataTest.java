/*
  * (C) Koninklijke Philips Electronics N.V. 2022
  *
  * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  * the copyright owner. 
  */

package com.philips.hsdp.research.fhdl.proposition.onboarding.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.stubbing.defaultanswers.ForwardsInvocations;
import org.mockito.junit.MockitoJUnitRunner;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.philips.hsdp.research.fhdl.proposition.onboarding.model.ResourceInfo;

/* @author Srinivasa Reddy Bijjam*/
@RunWith(MockitoJUnitRunner.class)
 class MdmDataTest {

	@Mock
	private DynamoDBMapper dynamoDbMapper;

	@InjectMocks
	MdmData mdmData;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("This Test case is to get the data from DynamoDB")
	 void getMdmData_Test() {

		ResourceInfo resourceInfo = ResourceInfo.builder().propositionId("123").organizationId("456")
				.profileName("Bijjam").propositionName("Reddy").organizationName("Java").departmentName("Spring")
				.algorithmEndpoint("Service").createdDateTime("current").resourceCreatedDateTime("Created")
				.propositionTags("Property").profileStructure("Json").baseTopicName("org").requestTopicName("Cardi")
				.resultTopicName("output").registryArn("Data").build();
		List<ResourceInfo> list = new ArrayList<>();
		list.add(resourceInfo);
		when(dynamoDbMapper.scan(eq(ResourceInfo.class), any(DynamoDBScanExpression.class)))
				.thenReturn(mock(PaginatedScanList.class, withSettings().defaultAnswer(new ForwardsInvocations(list))));
		assertNotNull(mdmData.getMdmData());
	}
}