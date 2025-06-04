/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/* @Author Sunil Kumar*/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "number", "name", "description" })

public class Segment {

	@JsonProperty("number")
	private String number;
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Segment() {
	}

	/**
	 * 
	 * @param number
	 * @param name
	 * @param description
	 */
	public Segment(String number, String name, String description) {
		super();
		this.number = number;
		this.name = name;
		this.description = description;
	}

	@JsonProperty("number")
	public String getNumber() {
		return number;
	}

	@JsonProperty("number")
	public void setNumber(String number) {
		this.number = number;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}
}