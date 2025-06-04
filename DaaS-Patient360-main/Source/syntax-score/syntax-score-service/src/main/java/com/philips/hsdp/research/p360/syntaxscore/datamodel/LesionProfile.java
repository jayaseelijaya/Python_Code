/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.datamodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/* @author Raj Kumar */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "lesion" })

public class LesionProfile {

	@JsonProperty("lesion")
	private Lesion lesion;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public LesionProfile() {
	}

	/**
	 * 
	 * @param lesion
	 */
	public LesionProfile(Lesion lesion) {
		super();
		this.lesion = lesion;
	}

	@JsonProperty("lesion")
	public Lesion getLesion() {
		return lesion;
	}

	@JsonProperty("lesion")
	public void setLesion(Lesion lesion) {
		this.lesion = lesion;
	}
}