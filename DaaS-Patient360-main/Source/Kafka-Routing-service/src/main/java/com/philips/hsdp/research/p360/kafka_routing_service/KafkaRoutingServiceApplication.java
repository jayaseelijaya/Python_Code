/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.kafka_routing_service;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* @author Rajeshwar Tondare */
@SpringBootApplication
public class KafkaRoutingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaRoutingServiceApplication.class, args);
	}

	@PostConstruct
	public void loadAppProperties() {
		System.setProperty("aws_region", "ap-south-1");
		System.setProperty("table_name", "proposition_metadata");
		System.setProperty("dynamodb_endpoint", "https://dynamodb.ap-south-1.amazonaws.com");
	}
}