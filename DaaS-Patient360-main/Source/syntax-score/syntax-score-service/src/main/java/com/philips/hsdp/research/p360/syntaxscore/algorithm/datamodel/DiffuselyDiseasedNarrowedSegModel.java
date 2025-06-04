/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/* @author Rajeshwar Tondare */
@Data
public class DiffuselyDiseasedNarrowedSegModel {
	private static DiffuselyDiseasedNarrowedSegModel INSTANCE;
	private Map<String, Boolean> diffuselyDiseasedNarrowedSeg;

	private DiffuselyDiseasedNarrowedSegModel() {
		this.diffuselyDiseasedNarrowedSeg = new HashMap<>();
		this.diffuselyDiseasedNarrowedSeg.put("1", false);
		this.diffuselyDiseasedNarrowedSeg.put("2", false);
		this.diffuselyDiseasedNarrowedSeg.put("3", false);
		this.diffuselyDiseasedNarrowedSeg.put("4", false);
		this.diffuselyDiseasedNarrowedSeg.put("5", false);
		this.diffuselyDiseasedNarrowedSeg.put("6", false);
		this.diffuselyDiseasedNarrowedSeg.put("7", false);
		this.diffuselyDiseasedNarrowedSeg.put("8", false);
		this.diffuselyDiseasedNarrowedSeg.put("9", false);
		this.diffuselyDiseasedNarrowedSeg.put("9a", false);
		this.diffuselyDiseasedNarrowedSeg.put("10", false);
		this.diffuselyDiseasedNarrowedSeg.put("10a", false);
		this.diffuselyDiseasedNarrowedSeg.put("11", false);
		this.diffuselyDiseasedNarrowedSeg.put("12", false);
		this.diffuselyDiseasedNarrowedSeg.put("12a", false);
		this.diffuselyDiseasedNarrowedSeg.put("12b", false);
		this.diffuselyDiseasedNarrowedSeg.put("13", false);
		this.diffuselyDiseasedNarrowedSeg.put("14", false);
		this.diffuselyDiseasedNarrowedSeg.put("14a", false);
		this.diffuselyDiseasedNarrowedSeg.put("14b", false);
		this.diffuselyDiseasedNarrowedSeg.put("15", false);
		this.diffuselyDiseasedNarrowedSeg.put("16", false);
		this.diffuselyDiseasedNarrowedSeg.put("16a", false);
		this.diffuselyDiseasedNarrowedSeg.put("16b", false);
		this.diffuselyDiseasedNarrowedSeg.put("16c", false);
	}

	public static DiffuselyDiseasedNarrowedSegModel getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DiffuselyDiseasedNarrowedSegModel();
			return INSTANCE;
		}
		return INSTANCE;
	}
}