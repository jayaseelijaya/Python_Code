/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.kafka_routing_service.constants;

/* @author Rajeshwar Tondare */
public class Constants {
	public static final String TOPIC1 = "hospital-a.cardiology";
	public static final String TOPIC2 = "hospital-a.cardiology.syntaxscore";
	public static final String PROFILENAME = "profileName";
	public static final String ORGID = "orgId";
	public static final String PROPOSITIONID = "propositionId";
	private Constants() {
		throw new IllegalStateException("Constants class. Cannot instantiate.");
	}
}