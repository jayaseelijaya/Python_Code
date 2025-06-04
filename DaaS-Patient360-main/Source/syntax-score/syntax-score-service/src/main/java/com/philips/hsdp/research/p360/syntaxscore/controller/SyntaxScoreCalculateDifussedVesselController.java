/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.ParseXmlToDataModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.processor.DiffuseDiseaseProcessor;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScore;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.UploadMultipleFilesService;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.DiffuseDiseaseSubSyntaxScoreObservationFloat;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.SyntaxScoreCalForLesionSubScore;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/*
 * @author Sunil Kumar
 */
@RestController
@SecurityRequirement(name = "SyntaxScore API")
public class SyntaxScoreCalculateDifussedVesselController {
	private static Logger log = LoggerFactory.getLogger(SyntaxScoreCalculateDifussedVesselController.class);
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	@Autowired
	SyntaxScoreCalForLesionSubScore syntaxScoreFloat;
	@Autowired
	ParseXmlToDataModel parseXmlToDataModel;
	@Autowired
	DiffuseDiseaseProcessor diffuseDiseaseProcessor;
	@Autowired
	DiffuseDiseaseSubSyntaxScoreObservationFloat diffuseDiseaseSubSyntaxScoreObservationFloat;

	@Hidden
	@PostMapping(value = "/difussed-vessel-score-calculator-app")
	@Operation(summary = "Calculate score for difussed-vessel")
	public String scoreCalculator(String syntaxScoreString) throws IOException {
		boolean present = false;
		syntaxScoreFloat = new SyntaxScoreCalForLesionSubScore(syntaxScoreString);
		syntaxScoreFloat.createObservation();
		SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();

		int lesionNumber = 0;
		parseXmlToDataModel.parseDataModel(syntaxScoreString, lesionNumber);
		diffuseDiseaseProcessor = new DiffuseDiseaseProcessor();
		diffuseDiseaseProcessor.process();
		float response = syntaxScoreRequest.getTempSyntaxScoreDiffuseDisease();
		String responseString = String.valueOf(response);
		String syntaxScore = "Syntax Score difussed-vessel = " + responseString;
		log.info(syntaxScore);
		syntaxScoreCodeableConceptCodeValue.reset();
	    diffuseDiseaseSubSyntaxScoreObservationFloat = new DiffuseDiseaseSubSyntaxScoreObservationFloat(
				present, syntaxScoreString);
		return diffuseDiseaseSubSyntaxScoreObservationFloat.createObservation();
	}

	@PostMapping(value = "/difussed-vessel-score-calculator", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@Operation(summary = "Calculate score for difussed-vessel")
	public String scoreCalculator(@RequestPart(required = true) MultipartFile[] file)
			throws IOException, URISyntaxException {
		UploadMultipleFilesService xmlToJsonConverterService = new UploadMultipleFilesService();
		String syntaxScoreString = xmlToJsonConverterService.convert(file);
		syntaxScoreFloat = new SyntaxScoreCalForLesionSubScore(syntaxScoreString);
		syntaxScoreFloat.createObservation();
		SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();

		int lesionNumber = 0;
		parseXmlToDataModel.parseDataModel(syntaxScoreString, lesionNumber);
		diffuseDiseaseProcessor = new DiffuseDiseaseProcessor();
		diffuseDiseaseProcessor.process();
		float response = syntaxScoreRequest.getTempSyntaxScoreDiffuseDisease();
		String responseString = String.valueOf(response);

		syntaxScoreCodeableConceptCodeValue.reset();
		return responseString;
	}
}