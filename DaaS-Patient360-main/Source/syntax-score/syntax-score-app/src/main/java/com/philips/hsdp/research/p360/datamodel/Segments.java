/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.datamodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "segment" })

/** @author Raj Kumar */
public class Segments {

	@JsonProperty("segment")
	private Segment segment;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Segments() {
	}

	/**
	 * 
	 * @param segment
	 */
	public Segments(Segment segment) {
		super();
		this.segment = segment;
	}

	@JsonProperty("segment")
	public Segment getSegment() {
		return segment;
	}

	@JsonProperty("segment")
	public void setSegment(Segment segment) {
		this.segment = segment;
	}
}