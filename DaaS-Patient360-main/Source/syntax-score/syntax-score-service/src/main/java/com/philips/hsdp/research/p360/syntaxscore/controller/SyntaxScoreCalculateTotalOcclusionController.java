/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScore;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.UploadMultipleFilesService;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.SyntaxScoreCalForLesionSubScore;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.TotalOcclusionSubSyntaxScoreObservationFloat;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/*
 * @author Sunil Kumar
 */
@RestController
@SecurityRequirement(name = "SyntaxScore API")
public class SyntaxScoreCalculateTotalOcclusionController {
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	
	@Autowired
	SyntaxScoreCalForLesionSubScore syntaxScoreFloat;
	
	public String scoreCalculator1(String syntaxScoreString) {
		SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();
		float tempScore = syntaxScoreRequest.getLesionSyntaxSubscoreTotalOcclusionObservation();
		try {
		syntaxScoreString = String.valueOf(tempScore);
		}
		catch (NullPointerException e) {
			e.getMessage();
		}
		syntaxScoreCodeableConceptCodeValue.reset();
		return syntaxScoreString;
	}
	
	@Hidden
	@PostMapping(value = "/score-calculator-totalOcclusion-app")
	@Operation(summary = "Calculate score for score-calculator-totalOcclusion")
	public String scoreCalculator(String toObservationList) {
		
	    syntaxScoreFloat = new SyntaxScoreCalForLesionSubScore(toObservationList);
		syntaxScoreFloat.createObservation();
		syntaxScoreCodeableConceptCodeValue.reset();
		boolean present=false;
		TotalOcclusionSubSyntaxScoreObservationFloat totalOcclusionSubSyntaxScoreObservationfloat=new TotalOcclusionSubSyntaxScoreObservationFloat(present, toObservationList);
		return totalOcclusionSubSyntaxScoreObservationfloat.createObservation();
	}
		
	@PostMapping(value = "/score-calculator-totalOcclusion", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@Operation(summary = "Calculate score for score-calculator-totalOcclusion")
	public String scoreCalculator(@RequestPart(required = true) MultipartFile[] file) throws IOException {
		UploadMultipleFilesService xmlToJsonConverterService = new UploadMultipleFilesService();
		String syntaxScoreString = xmlToJsonConverterService.convert(file);
		SyntaxScoreCalForLesionSubScore syntaxScoreFloat = new SyntaxScoreCalForLesionSubScore(
				syntaxScoreString);
		syntaxScoreFloat.createObservation();
		boolean present=false;
		TotalOcclusionSubSyntaxScoreObservationFloat totalOcclusionSubSyntaxScoreObservationfloat=new TotalOcclusionSubSyntaxScoreObservationFloat(present, syntaxScoreString);
		return totalOcclusionSubSyntaxScoreObservationfloat.createObservation();
	}
}