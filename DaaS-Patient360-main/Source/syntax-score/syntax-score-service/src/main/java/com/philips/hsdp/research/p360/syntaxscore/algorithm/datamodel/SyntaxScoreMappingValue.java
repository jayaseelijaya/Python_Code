/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel;

import java.util.Map;
import org.springframework.stereotype.Component;

/* @Author Sunil Kumar*/
@Component
public class SyntaxScoreMappingValue {
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	AccessSyntaxScoreModel accessSyntaxScoreModel = AccessSyntaxScoreModel.getInstance();
	public static final String PRESENT = "present";
	public static final String YES = "Yes";
	public static final String DOMINANCE = "Left Cardiac Artery Dominance";

	/**
	 * This function is used to parse input question for Left Dominance from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : Left Dominance
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean : if its true then Dominance will be left other wise it will
	 *         RIght dominance
	 */

	public boolean coronaryArteryDominance(String value) {
		return value.equalsIgnoreCase(DOMINANCE);
	}

	/**
	 * This function is used to parse input question for totalOcclusion from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean value if it true then its present
	 */

	public boolean totalOcclusion(String value) {
		return value.equalsIgnoreCase(YES);
	}

	/**
	 * This function is used to parse input question for ageOfTotalOcclusion from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : Left Dominance
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return int value
	 */
	public int ageOfTotalOcclusion(String value) {
		if (value.equalsIgnoreCase("yes"))
			return 1;
		else if (value.equalsIgnoreCase("no"))
			return 0;
		else
			return 2;
	}

	/**
	 * This function is used to parse input question for bluntStump from Observation
	 * and map the data in user data model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean value if it true then its present
	 */
	public boolean bluntStump(String value) {
		return value.equalsIgnoreCase(PRESENT);
	}

	/**
	 * This function is used to parse input question for bridgingcollaterals from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean value if it true then its present
	 */

	public boolean bridgingCollaterals(String value) {
		return value.equalsIgnoreCase(PRESENT);
	}

	/**
	 * This function is used to parse input question for sideBranchInvolved from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return int value
	 */
	public int sideBranchInvolved(String value) {
		if (value.equalsIgnoreCase("No Sidebranch")) {
			return 0;
		} else if (value.equalsIgnoreCase("All Sidebranches are less than 1.5mm")) {
			return 1;
		}
		if (value.equalsIgnoreCase("All Sidebranches are greater than 1.5mm")) {

			return 2;
		} else {
			return 3;
		}
	}

	/**
	 * This function is used to parse input question for trifurcationValue from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean value if it true then its present
	 */
	public boolean trifurcationValue(String value) {
		return value.equalsIgnoreCase(PRESENT);
	}

	/**
	 * This function is used to parse input question for bifurcationValue from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean value if it true then its present
	 */

	public boolean bifurcationValue(String value) {
		return value.equalsIgnoreCase(PRESENT);
	}

	/**
	 * This function is used to parse input question for bifurcationangulation from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean value if it true then its present
	 */

	public boolean bifurcationAngulation(String value) {
		return value.equalsIgnoreCase(PRESENT);
	}

	/**
	 * This function is used to parse input question for bifurcation medina from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return int value
	 */
	public int medina(String value) {
		if (value.equalsIgnoreCase("Medina 1,0,0")) {
			return 0;
		} else if (value.equalsIgnoreCase("Medina 0,1,0")) {
			return 1;
		} else if (value.equalsIgnoreCase("Medina 1,1,0")) {
			return 2;
		} else if (value.equalsIgnoreCase("Medina 1,1,1")) {
			return 3;
		} else if (value.equalsIgnoreCase("Medina 0,0,1")) {
			return 4;
		} else if (value.equalsIgnoreCase("Medina 1,0,1"))
			return 5;
		else if (value.equalsIgnoreCase("Medina 0,1,1")) {
			return 6;
		} else {
			return 7;
		}
	}

	/**
	 * This function is used to parse input question for diseasedsegment from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return int value
	 */
	public int diseasedsegment(String value) {
		if (value.equalsIgnoreCase("1")) {
			return 0;
		} else if (value.equalsIgnoreCase("2")) {
			return 1;
		}
		if (value.equalsIgnoreCase("3")) {
			return 2;
		} else {
			return 3;
		}
	}

	/**
	 * This function is used to parse input question for aortoOstialValue from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean value if it true then its present
	 */

	public boolean aortoOstialValue(String value) {
		return value.equalsIgnoreCase(PRESENT);
	}

	/**
	 * This function is used to parse input question for severTortuosityValue from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean value if it true then its present
	 */

	public boolean severTortuosityValue(String value) {
		return value.equalsIgnoreCase(PRESENT);
	}

	/**
	 * This function is used to parse input question for heavyCalcificationValue
	 * from Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean value if it true then its present
	 */

	public boolean heavyCalcificationValue(String value) {
		return value.equalsIgnoreCase(PRESENT);
	}

	/**
	 * This function is used to parse input question for lengthGT20mmValue from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean value if it true then its present
	 */

	public boolean lengthGT20mmValue(String value) {
		return value.equalsIgnoreCase(PRESENT);
	}

	/**
	 * This function is used to parse input question for thrombusValue from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean value if it true then its present
	 */

	public boolean thrombusValue(String value) {
		return value.equalsIgnoreCase(PRESENT);
	}

	/**
	 * This function is used to parse input question for diffuseDiseaseValue from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          value : presence or absence
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return boolean value if it true then its present
	 */

	public boolean diffuseDiseaseValue(String value) {
		return value.equalsIgnoreCase(PRESENT);
	}

	/**
	 * This function is used to parse input question for segment from Observation
	 * and map the data in user data model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          bodySite : segment value
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return set the value in user data model
	 */
	public SyntaxScoreCodeableConceptModel segments(String bodySite) {
		Map<String, Boolean> segment = syntaxScoreCodeableConceptCodeValue.getSegment();
		String inputXmlValue = bodySite;
		segment.put(inputXmlValue, true);
		return syntaxScoreCodeableConceptCodeValue;
	}

	/**
	 * This function is used to parse input question for diffuseDiseaseValueNarraow
	 * from Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          bodySite : segment value
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return set the value in user data model
	 */
	public SyntaxScoreCodeableConceptModel diffuseDiseaseValueNarraow(String bodySite) {
		Map<String, Boolean> diffuselyDiseasedNarrowedSeg = syntaxScoreCodeableConceptCodeValue
				.getDiffuselyDiseasedNarrowedSeg();
		String inputXmldiffuseDiseaseValue = bodySite;
		diffuselyDiseasedNarrowedSeg.put(inputXmldiffuseDiseaseValue, true);
		return syntaxScoreCodeableConceptCodeValue;
	}

	/**
	 * This function is used to parse input question for firstSegment from
	 * Observation and map the data in user data
	 * model-SyntaxScoreCodeableConceptModel
	 * 
	 * @param String                          bodySite : segment value
	 * 
	 * @param SyntaxScoreCodeableConceptModel : to map the data in user data model-
	 *                                        SyntaxScoreCodeableConceptModel
	 * 
	 * @return set the value in user data model
	 */
	public SyntaxScoreCodeableConceptModel firstSegment(String bodySite) {
		Map<String, Boolean> firstSegmentValue = syntaxScoreCodeableConceptCodeValue.getFirstSegment();
		String inputXmlValue = bodySite;
		firstSegmentValue.put(inputXmlValue, true);
		return syntaxScoreCodeableConceptCodeValue;
	}
}