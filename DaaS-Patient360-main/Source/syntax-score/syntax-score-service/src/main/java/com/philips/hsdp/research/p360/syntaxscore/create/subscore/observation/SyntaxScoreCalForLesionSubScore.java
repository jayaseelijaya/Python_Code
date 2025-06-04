/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import org.springframework.stereotype.Service;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;

/* @author Raj Kumar */
@Service
public class SyntaxScoreCalForLesionSubScore {
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	private String syntaxScoreString;
	
	public SyntaxScoreCalForLesionSubScore() {}
	public SyntaxScoreCalForLesionSubScore(String syntaxScoreString) {
		super();
		this.syntaxScoreString = syntaxScoreString;
	}

	public List<String> createObservation() {

		byte[] decoded = Base64.getUrlDecoder().decode(syntaxScoreString);
		
		String observationString = new String(decoded, StandardCharsets.UTF_8);
		observationString = observationString.replace(">,", ">\n,");
        return new ArrayList<>(Arrays.asList(observationString.split("\\n,")));
	}
}