/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.fhdl.proposition.onboarding.constants;

import java.util.Arrays;
import java.util.List;

/* @author Sunil Kumar */
public class Constants {
	public static final String TABLE_NAME = System.getProperty("table_name");

	public static final List<String> VAULT_KEYS = Arrays.asList("daas-common-credentials");

	private Constants() {
		throw new IllegalStateException("Constants class. Cannot instantiate.");
	}
}