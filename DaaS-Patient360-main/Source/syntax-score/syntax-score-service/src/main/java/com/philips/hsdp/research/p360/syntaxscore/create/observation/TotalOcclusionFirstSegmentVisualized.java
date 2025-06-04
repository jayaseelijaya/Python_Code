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
public class TotalOcclusionFirstSegmentVisualized extends ILSObservation {
	
	private static final String ILS_PROFILE_TO_VISUALIZED = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscoreTotalOcclusion/LesionSyntaxSubscoreTotalOcclusionFirstSegmentVisualized";
	private Observation toFirstSegmentVisualized = new Observation();
	private String segmentString;

	public TotalOcclusionFirstSegmentVisualized(String segmentString) {
		super();
		this.segmentString = segmentString;
	}

	/**
	 * Generates  TotalOcclusion first segment Visualized observation
	 * @return observation XML string
	 * @throws JsonProcessingException 
	 * @throws UnsupportedEncodingException 
	 */
	public String createObservation() throws JsonProcessingException, UnsupportedEncodingException {
		
		String code = "";
		String display = "";
		byte[] decoded = Base64.getUrlDecoder().decode(this.segmentString);
		String json = new String(decoded, "UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		Segment segment = objectMapper.readValue(json, Segment.class);

		if(segment.getNumber().isEmpty()){
			code = "None";
			display = "None";
		}else {
			code = segment.getNumber();
			display = segment.getName();
		}
		// Id
		initializeObservationId(toFirstSegmentVisualized);

		// Meta
		createMetaData(toFirstSegmentVisualized, ILS_PROFILE_TO_VISUALIZED);

		//Status
		setObservationStatus(toFirstSegmentVisualized);	

		// Category
		createCodeableConceptCategory(toFirstSegmentVisualized, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Code
		createCodeableConcept(toFirstSegmentVisualized, TerminologyServer.CAD_SUMMARY_CODE_URL,
				Snomed.SNOMED_CODE_FIRST_SEGMENT_VISUALIZED,
				Snomed.SNOMED_CODE_FIRST_SEGMENT_VISUALIZED);

		// Subject
		setObservationSubject(toFirstSegmentVisualized);

		// EffectiveDateTime
		setEffectiveDateTime(toFirstSegmentVisualized);

		//bodySite
		createBodySite(toFirstSegmentVisualized, TerminologyServer.SYNTAXSCORE_URL, code, display);

		// Genrate XML
		String TOFirstSegmentVisualizedObservationXml = generateObservationXML(toFirstSegmentVisualized);
		return TOFirstSegmentVisualizedObservationXml;

	}
}