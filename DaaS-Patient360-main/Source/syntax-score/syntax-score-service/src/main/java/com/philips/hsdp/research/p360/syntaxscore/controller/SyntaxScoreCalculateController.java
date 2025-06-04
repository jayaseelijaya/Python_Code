/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.ParseXmlToDataModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.SyntaxScoreCodeableConceptModel;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScore;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.SyntaxScoreCalculator;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.UploadMultipleFilesService;
import com.philips.hsdp.research.p360.syntaxscore.constant.FirstSegmentConstantLeft;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.LesionSubSyntaxScoreObservationFloat;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.SyntaxScoreCalForLesionSubScore;
import com.philips.hsdp.research.p360.syntaxscore.create.subscore.observation.SyntaxScoreObservationFloat;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/*
 * @author Sunil Kumar
 */
@RestController
@SecurityRequirement(name = "SyntaxScore API")
public class SyntaxScoreCalculateController {
	SyntaxScore syntaxScoreRequest = SyntaxScore.getInstance();
	SyntaxScoreCodeableConceptModel syntaxScoreCodeableConceptCodeValue = SyntaxScoreCodeableConceptModel.getInstance();
	float response;
	@Autowired
	SyntaxScoreCalForLesionSubScore syntaxScoreCalForLesionSubScore;
	@Autowired
	LesionSubSyntaxScoreObservationFloat lesionSubSyntaxScoreObservationFloat;
	@Autowired
	UploadMultipleFilesService xmlToJsonConverterService;
	@Autowired
	SyntaxScoreCalForLesionSubScore syntaxScoreFloat;
	@Autowired
	SyntaxScoreCalculator syntaxScoreCalculator;
	@Autowired
	ParseXmlToDataModel parseXmlToDataModel;
	@Autowired
	SyntaxScoreObservationFloat syntaxScoreObservationFloat;
	
	/**
	 * This function is used to calculate the score
	 * 
	 * @inheritDoc : override super class SyntaxScoreCalculateController.
	 * @param String : syntaxScoreString
	 * @param int : lesionNumber
	 * 
	 * @return String responseString
	 */
	//@Hidden
	@PostMapping(value = "/score-calculator-app")
	@Operation(summary = "calculate the score-calculator")
	public String scoreCalculator(String syntaxScoreString, int lesionNumber) {
	    syntaxScoreFloat = new SyntaxScoreCalForLesionSubScore(syntaxScoreString);
		syntaxScoreFloat.createObservation();
		parseXmlToDataModel  = new ParseXmlToDataModel();
		parseXmlToDataModel.parseDataModel(syntaxScoreString, lesionNumber);
		syntaxScoreCalculator.initSyntaxScoreCalculator();
		response = syntaxScoreRequest.getSyntaxScore();
		syntaxScoreCodeableConceptCodeValue.reset();
	    lesionSubSyntaxScoreObservationFloat= new LesionSubSyntaxScoreObservationFloat(syntaxScoreString);
		return lesionSubSyntaxScoreObservationFloat.createObservation();
	}
	
	/**
	 * This function is used to calculate the score
	 * 
	 * @inheritDoc : override super class SyntaxScoreCalculateController.
	 * @param MultipartFile[] : upload multiple files
	 * @param int : lesionNumber
	 * 
	 * @return String : display float as string in swagger UI
	 */
	@PostMapping(value = "/lesions-score-calculator", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@Operation(summary = "calculate the score-calculator")
	public String scoreCalculator(@RequestPart(required = true) MultipartFile[] file, int lesionNumber) throws IOException {
		xmlToJsonConverterService = new UploadMultipleFilesService();
		String syntaxScoreString = xmlToJsonConverterService.convert(file);
		 syntaxScoreFloat = new SyntaxScoreCalForLesionSubScore(syntaxScoreString);
		syntaxScoreFloat.createObservation();
		parseXmlToDataModel  = new ParseXmlToDataModel();
		parseXmlToDataModel.parseDataModel(syntaxScoreString, lesionNumber);
		syntaxScoreCalculator.initSyntaxScoreCalculator();
		response = syntaxScoreRequest.getSyntaxScore();
		String responseString = String.valueOf(response);
		syntaxScoreCodeableConceptCodeValue.reset();
		return responseString;
	}
	/**
	 * This function is used to calculate the sub score
	 * 
	 * @inheritDoc : override super class SyntaxScoreCalculateController.
	 * 
	 * @return String encodedString
	 */
	@Hidden
	@PostMapping(value = "/syntaxScore-summary-app")
	@Operation(summary = "calculate the subscore-value")
	public String syntaxScorevalues(String jsonString) {
		TreeMap<String, Float> totalSyntaxScore = syntaxScoreRequest.getTotalSyntaxScore();
		response = syntaxScoreRequest.getSyntaxScore();
		TreeMap<String, Float> syntaxScoreHeader = new TreeMap<>((a, b) -> 1);
		syntaxScoreHeader.put("SYNTAX Score I", FirstSegmentConstantLeft.L_SYNTAXSCORE);
		TreeMap<String, Float> totalSyntaxScoreValue = new TreeMap<>((a, b) -> 1);
		List<Float> floatSyntaxScoreList = syntaxScoreRequest.getListLesions();
		float finalSyntaxScore = 0.0f;
		for (Float floatSyntaxScore : floatSyntaxScoreList) {
			finalSyntaxScore += floatSyntaxScore;
		}	
		totalSyntaxScoreValue.put("Total ", finalSyntaxScore);
		TreeMap<String, Float> syntaxScoreFinal = new TreeMap<>((a, b) -> 1);
		syntaxScoreFinal.putAll(syntaxScoreHeader);
		syntaxScoreFinal.putAll(totalSyntaxScore);
		syntaxScoreFinal.putAll(totalSyntaxScoreValue);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		jsonString = gson.toJson(syntaxScoreFinal);
		String encodedString = Base64.getUrlEncoder().encodeToString(jsonString.getBytes());
		syntaxScoreRequest.reset();
		syntaxScoreHeader.clear();
		syntaxScoreFinal.clear();
		floatSyntaxScoreList.clear();
		syntaxScoreCodeableConceptCodeValue.reset();
		return encodedString;
	}
	
	/**
	 * This function is used to calculate the sub score
	 * 
	 * @inheritDoc : override super class SyntaxScoreCalculateController.
	 * 
	 * @return String : display float as string in swagger UI
	 * @throws IOException 
	 */
	@PostMapping(value = "/syntaxScore-summary")
	@Operation(summary = "display syntax score summary")
	public String syntaxScoreSumary() {
		TreeMap<String, Float> totalSyntaxScore = syntaxScoreRequest.getTotalSyntaxScore();
		response = syntaxScoreRequest.getSyntaxScore();
		TreeMap<String, Float> syntaxScoreHeader = new TreeMap<>((a, b) -> 1);
		syntaxScoreHeader.put("SYNTAX Score I", FirstSegmentConstantLeft.L_SYNTAXSCORE);
		TreeMap<String, Float> totalSyntaxScoreValue = new TreeMap<>((a, b) -> 1);
		List<Float> floatSyntaxScoreList = syntaxScoreRequest.getListLesions();
		float finalSyntaxScore = 0.0f;
		for (Float floatSyntaxScore : floatSyntaxScoreList) {
			finalSyntaxScore += floatSyntaxScore;
		}		
		totalSyntaxScoreValue.put("Total ", finalSyntaxScore);
		TreeMap<String, Float> syntaxScoreFinal = new TreeMap<>((a, b) -> 1);
		syntaxScoreFinal.putAll(syntaxScoreHeader);
		syntaxScoreFinal.putAll(totalSyntaxScore);
		syntaxScoreFinal.putAll(totalSyntaxScoreValue);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonString = gson.toJson(syntaxScoreFinal);
		String mapValue = jsonString.replace("\\{", "").replace("\\}", "").replace("-1.0,", "").replace(":", " : ");
		syntaxScoreCodeableConceptCodeValue.reset();
		syntaxScoreRequest.reset();
		syntaxScoreHeader.clear();
		syntaxScoreFinal.clear();
		floatSyntaxScoreList.clear();
		return mapValue;
	}
	
	/**
	 * This function is used to calculate the sub score
	 * 
	 * @inheritDoc : override super class SyntaxScoreCalculateController.
	 * 
	 * @return String encodedString
	 */
	@PostMapping(value = "/syntax-score-value")
	@Operation(summary = "display syntax score ")
	public String syntaxScorevalue(String observationList) {
	    syntaxScoreCalForLesionSubScore= new SyntaxScoreCalForLesionSubScore(observationList);
		syntaxScoreCalForLesionSubScore.createObservation();
		List<Float> floatSyntaxScoreList = syntaxScoreRequest.getListLesions();
		float finalSyntaxScore = 0.0f;
		for (Float floatSyntaxScore : floatSyntaxScoreList) {
			finalSyntaxScore += floatSyntaxScore;
		}
	     syntaxScoreObservationFloat = new SyntaxScoreObservationFloat(observationList);
		return syntaxScoreObservationFloat.createObservation();
	}
	public String syntaxScoreObservation() {
		List<Float> floatSyntaxScoreList = syntaxScoreRequest.getListLesions();
		float finalSyntaxScore = 0.0f;
		for (Float floatSyntaxScore : floatSyntaxScoreList) {
			finalSyntaxScore += floatSyntaxScore;
		}
		return String.valueOf(finalSyntaxScore);
	}
}