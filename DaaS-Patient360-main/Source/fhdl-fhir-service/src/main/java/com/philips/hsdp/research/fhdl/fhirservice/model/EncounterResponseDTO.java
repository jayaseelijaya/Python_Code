/**
  * (C) Koninklijke Philips Electronics N.V. 2021
  *
  * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
  * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
  * the copyright owner. 
  **/
package com.philips.hsdp.research.fhdl.fhirservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
/*
 * @author Priyanka Mallick
 */
@Data
@JsonInclude(Include.NON_NULL)
public class EncounterResponseDTO {

	private JsonNode resourceJson;
}