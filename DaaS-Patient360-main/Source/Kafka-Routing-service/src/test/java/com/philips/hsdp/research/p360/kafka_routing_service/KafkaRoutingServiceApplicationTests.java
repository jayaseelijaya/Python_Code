/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.kafka_routing_service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

/* @author Shital Ghatole */
@RunWith(MockitoJUnitRunner.class)
class KafkaRoutingServiceApplicationTests {

	@InjectMocks
	KafkaRoutingServiceApplication application=new KafkaRoutingServiceApplication ();
	@Test
	public void loadAppProperties() {
		application.loadAppProperties();
	}
	@Test
	public void Main_Test() {
		application.main(new String[0]);
	}
}