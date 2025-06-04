/**
  * (C) Koninklijke Philips Electronics N.V. 2021
  *
  * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  * the copyright owner. 
  **/
package com.philips.hsdp.research.fhdl.fhirservice.model;

import java.util.ArrayList;
import lombok.Data;
/*
 * @author Priyanka Mallick
 */
@Data
public class PatientFHIRStructureDTO {

	private String resourceType;
	private String type;
	private String timestamp;
	private ArrayList<Object> entry;
}