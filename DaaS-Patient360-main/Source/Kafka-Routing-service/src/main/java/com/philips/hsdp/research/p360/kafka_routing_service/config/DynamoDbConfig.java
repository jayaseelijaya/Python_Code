/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.kafka_routing_service.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

/* @author Rajeshwar Tondare */
@Configuration
public class DynamoDbConfig {
	private String accessKey = System.getProperty("aws_key");
	private String accessSecret = System.getProperty("aws_secret");
	private String awsRegion = System.getProperty("aws_region");
	private String dynamodbEndpoint = System.getProperty("dynamodb_endpoint");
	private String awsSessionToken = System.getProperty("aws_session_Token");

	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		AWSCredentialsProvider credentails = new AWSStaticCredentialsProvider(
				new BasicSessionCredentials(accessKey, accessSecret, awsSessionToken));
		AmazonDynamoDB dbClient = AmazonDynamoDBClientBuilder.standard().withCredentials(credentails)
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamodbEndpoint, awsRegion))
				.build();
		return new DynamoDBMapper(dbClient);
	}
}