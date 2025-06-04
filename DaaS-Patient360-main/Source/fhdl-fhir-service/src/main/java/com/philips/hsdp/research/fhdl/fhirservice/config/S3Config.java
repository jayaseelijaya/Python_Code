/*
 * (C) Koninklijke Philips Electronics N.V. 2021
 * 
 * All rights are reserved. Reproduction or transmission in whole or in part, in
 * any form or by any means, electronic, mechanical or otherwise, is prohibited
 * without the prior written consent of the copyright owner.
 * 
 */

package com.philips.hsdp.research.fhdl.fhirservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.auth.BasicSessionCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * @author Rajeshwar Tondare
 */
@Configuration
public class S3Config {
	private static final Logger log = LoggerFactory.getLogger(S3Config.class);
	private String accessKey = System.getProperty("api_key");
	private String accessSecret = System.getProperty("secret_key");
	private String awsRegion = System.getProperty("aws_region");

	private String accessKeyLoader = System.getProperty("s3loader_api_key");
	private String accessSecretLoader = System.getProperty("s3loader_secret_key");
	private String awsRegionLoader = System.getProperty("aws_region");
	private String awsSessionToken = System.getProperty("s3session_token");

	@Bean
	public AmazonS3 s3Client() {
		log.info("Vault details::::::::api-key:::::::::::::::::::;", System.getProperty("api_key"));
		System.out.println("Vault details::::::::api-key:::::::::::::::::::;"+accessKey);
		log.info("Vault details:::::::::::::::::::::::::::;", System.getProperties());
		System.out.println("Vault details::::::::api-key:::::::::::::::::::;"+System.getProperties());
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, accessSecret);
		return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(awsRegion).build();
	}

	@Bean
	public AmazonS3 s3ClientLoader() {
		AWSCredentials sessionCredentials = new BasicSessionCredentials(accessKeyLoader, accessSecretLoader,
				awsSessionToken);
		return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(sessionCredentials))
				.withRegion(awsRegionLoader).build();
	}
}