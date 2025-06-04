/*
 * (C) Koninklijke Philips Electronics N.V. 2022
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.daas.cds.transformation.model;

import lombok.Data;

/* @author Sunil Kumar */
@Data
public class PatientDTO {
	public String response;
	public String patientId;
	public String practitionerId;
	public String medicationId;
	public String organizationId;
	public String practitionerResponse;
	public String organizationResponse;
	public String medicationResponse;
	public String practitionerResponseType;
	public String organizationResponseType;
	public String medicationResponseType;
}