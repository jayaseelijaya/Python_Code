/*
 * (C) Koninklijke Philips Electronics N.V. 2022
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */
 
package com.philips.hsdp.research.daas.cds.transformation.constants;

import java.util.Arrays;
import java.util.List;

/* @author Sunil Kumar */
public class Constants {
	public static final String RESOURCE_FHIR_JSON = "FHIR-JSON";
	public static final String STORAGE_ZONE_CDR = "CDR";
	public static final String STORAGE_ZONE_DICOM = "DICOM";
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final List<String> VAULT_KEYS = Arrays.asList("daas-common-credentials");

	private Constants() {
		throw new IllegalStateException("Constants class. Cannot instantiate.");
	}
}