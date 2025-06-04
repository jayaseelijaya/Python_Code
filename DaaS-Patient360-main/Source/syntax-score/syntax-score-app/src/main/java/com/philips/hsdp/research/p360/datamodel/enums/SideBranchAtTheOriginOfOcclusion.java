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
public enum SideBranchAtTheOriginOfOcclusion {
	NO("No"), YES_ALLSIDEBRANCHES_LT_1_POINT_5_MM("Yes, all sidebranches < 1.5mm"),
	YES_ALLSIDEBRANCHES_GTOREQUAL_1_POINT_5_MM("Yes, all sidebranches >= 1.5mm"),
	YES_ALLSIDEBRANCHES_LT_1_POINT_5_MM_AND_GTOREQUAL_1_POINT_5_MM_ARE_INVOLVED(
			"Yes, both sidebranches < 1.5mm and >= 1.5mm are involved");

	private String value;

	private SideBranchAtTheOriginOfOcclusion(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}