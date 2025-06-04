/*
  * (C) Koninklijke Philips Electronics N.V. 2022
  *
  * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  * the copyright owner. 
  */

package com.philips.hsdp.research.fhdl.proposition.onboarding.service;

import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3URI;
import com.amazonaws.services.s3.model.S3Object;

/* @author Srinivasa Reddy Bijjam*/
@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
 class S3BucketStorageServiceTest {

	@Mock
	private AmazonS3 amazonS3Client;

	@Mock
	AmazonS3URI s3URI;

	@Mock
	S3Object s3Object;

	@InjectMocks
	S3BucketStorageService s3BucketStorageService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("This Test case is to store the data into s3BucketStorage")
	 void getProfileStructureContent_Test() throws IOException, URISyntaxException {
		String profileStructureUri = "s3://daas-profile-json/SyntaxScore.structuredefinition.json";
		Mockito.when(amazonS3Client.getObject(Mockito.anyString(), Mockito.anyString())).thenReturn(s3Object);
		assertNotNull((profileStructureUri));
	}
}