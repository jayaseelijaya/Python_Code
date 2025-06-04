/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.datamodel.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)

/** @author Raj Kumar */
public enum BifurcationMedina {
	MEDINA_1_0_0("Medina 1,0,0"), MEDINA_0_1_0("Medina 0,1,0"), MEDINA_1_1_0("Medina 1,1,0"),
	MEDINA_1_1_1("Medina 1,1,1"), MEDINA_0_0_1("Medina 0,0,1"), MEDINA_1_0_1("Medina 1,0,1"),
	MEDINA_0_1_1("Medina 0,1,1");

	private String value;

	private BifurcationMedina(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}