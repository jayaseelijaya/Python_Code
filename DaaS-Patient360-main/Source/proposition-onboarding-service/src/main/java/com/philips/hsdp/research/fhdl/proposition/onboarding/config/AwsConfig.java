/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.fhdl.proposition.onboarding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.glue.AWSGlue;
import com.amazonaws.services.glue.AWSGlueClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/* @author Sunil Kumar */
@Configuration
public class AwsConfig {

	private String accessKey = System.getProperty("aws_access_key");
	private String accessSecret = System.getProperty("aws_secret_key");
	private String awsRegion = System.getProperty("region_name");
	private String awsSessionToken = System.getProperty("aws_session_token");
	private String dynamodbEndpoint = System.getProperty("daynmodb_endpoint");
	private String glueEndpoint = System.getProperty("glue_endpoint");

	/**
	 * This function is to connect with S3object to get s3-object_location .
	 * 
	 * @param s3Client : accessKey, accessSecret, awsSessionToken, awsRegion
	 * 
	 * @return AmazonS3
	 */
	@Bean
	public AmazonS3 s3Client() {
		AWSCredentials sessionCredentials = new BasicSessionCredentials(accessKey, accessSecret, awsSessionToken);
		return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(sessionCredentials))
				.withRegion(awsRegion).build();
	}

	/**
	 * This function is to connect with DynamDB to save data in MDM(DynamoDB).
	 * 
	 * @param buildAmazonDynamoDB : accessKey, accessSecret, awsSessionToken,
	 *                            awsRegion, dynamodbEndpoint
	 * 
	 * @return DynamoDBMapper
	 */
	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		return new DynamoDBMapper(buildAmazonDynamoDB());
	}

	private AmazonDynamoDB buildAmazonDynamoDB() {
		AWSCredentials sessionCredentials = new BasicSessionCredentials(accessKey, accessSecret, awsSessionToken);
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamodbEndpoint, awsRegion))
				.withCredentials(new AWSStaticCredentialsProvider(sessionCredentials)).build();
	}

	/**
	 * This function is to connect with DynamDB to save data in MDM .
	 * 
	 * @param awsGlueClient : accessKey, accessSecret, awsSessionToken, awsRegion,
	 *                      glueEndpoint
	 * 
	 * @return AWSGlue
	 */
	@Bean
	public AWSGlue awsGlueClient() {
		AWSCredentials sessionCredentials = new BasicSessionCredentials(accessKey, accessSecret, awsSessionToken);
		return AWSGlueClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(glueEndpoint, awsRegion))
				.withCredentials(new AWSStaticCredentialsProvider(sessionCredentials)).build();
	}

	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		return new RestTemplate(factory);
	}
}