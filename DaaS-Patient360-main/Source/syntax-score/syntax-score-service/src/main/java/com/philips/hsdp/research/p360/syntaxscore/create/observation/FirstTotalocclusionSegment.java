/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.syntaxscore.create.observation;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import org.hl7.fhir.r4.model.Observation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.Segment;
import com.philips.hsdp.research.p360.syntaxscore.constant.Snomed;
import com.philips.hsdp.research.p360.syntaxscore.constant.TerminologyServer;
import com.philips.hsdp.research.p360.syntaxscore.create.ils.observation.ILSObservation;

/* @author Raj Kumar */
public class FirstTotalocclusionSegment extends ILSObservation {
	
	private static final String ILS_PROFILE_TO_FIRST_SEGMENT = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscoreTotalOcclusion/LesionSyntaxSubscoreTotalOcclusionFirstSegment";
	private Observation firstTOSegmentObservation = new Observation();
	private String segmentString;

	public FirstTotalocclusionSegment(String segmentString) {
		super();
		this.segmentString = segmentString;
	}

	/**
	 * Generates First TotalocclusionSegment observation
	 * @return observation XML string
	 * @throws UnsupportedEncodingException 
	 * @throws JsonProcessingException 
	 */
	public String createObservation() throws UnsupportedEncodingException, JsonProcessingException {
		
		byte[] decoded = Base64.getUrlDecoder().decode(this.segmentString);
		String json = new String(decoded, "UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		Segment segment = objectMapper.readValue(json, Segment.class);

		// Id
		initializeObservationId(firstTOSegmentObservation);

		// Meta
		createMetaData(firstTOSegmentObservation, ILS_PROFILE_TO_FIRST_SEGMENT);

		//Status
		setObservationStatus(firstTOSegmentObservation);	

		// Category
		createCodeableConceptCategory(firstTOSegmentObservation, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Code
		createCodeableConcept(firstTOSegmentObservation, TerminologyServer.CAD_SUMMARY_CODE_URL,
				Snomed.SNOMED_DISPLAY_FIRST_SEGMENT,
				Snomed.SNOMED_DISPLAY_FIRST_SEGMENT);

		// Subject
		setObservationSubject(firstTOSegmentObservation);

		// EffectiveDateTime
		setEffectiveDateTime(firstTOSegmentObservation);

		//bodySite
		String code = segment.getNumber();
		String display = segment.getName();
		createBodySite(firstTOSegmentObservation, TerminologyServer.SYNTAXSCORE_URL, code, display);

		// Genrate XML
		String FirstTOSegmentObservationXml = generateObservationXML(firstTOSegmentObservation);
		return FirstTOSegmentObservationXml;

	}
}