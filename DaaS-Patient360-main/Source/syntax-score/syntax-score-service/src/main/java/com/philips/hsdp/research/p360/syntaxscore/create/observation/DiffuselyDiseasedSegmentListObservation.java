/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.syntaxscore.create.observation;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.hl7.fhir.r4.model.Observation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.Segment;
import com.philips.hsdp.research.p360.syntaxscore.constant.Snomed;
import com.philips.hsdp.research.p360.syntaxscore.constant.TerminologyServer;
import com.philips.hsdp.research.p360.syntaxscore.create.ils.observation.ILSObservation;

/* @author Raj Kumar */
public class DiffuselyDiseasedSegmentListObservation extends ILSObservation {
	
	private static final String ILS_PROFILE_SELECTED_SEGMENT = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreSegment";
	private Observation diffusedSegmentsObservation = new Observation();
	private String segmentString;

	public DiffuselyDiseasedSegmentListObservation(String segmentString) {
		super();
		this.segmentString = segmentString;
	}

	/**
	 * Generates Diffusely Diseased Segment observation
	 * @return observation XML string
	 * @throws UnsupportedEncodingException 
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 */
	public String createObservation() throws JsonProcessingException  {

		byte[] decoded = Base64.getUrlDecoder().decode(this.segmentString);
		String segmentDecoded = new String(decoded, StandardCharsets.UTF_8);
		ObjectMapper objectMapper = new ObjectMapper();
		Segment segment = objectMapper.readValue(segmentDecoded, Segment.class);

		// Id
		initializeObservationId(diffusedSegmentsObservation);

		// Meta
		createMetaData(diffusedSegmentsObservation, ILS_PROFILE_SELECTED_SEGMENT);

		//Status
		setObservationStatus(diffusedSegmentsObservation);

		// Code
		createCodeableConcept(diffusedSegmentsObservation,Snomed.SNOMED_URL,
				Snomed.SNOMED_CODE_SELECTED_SEGMENT, Snomed.SNOMED_DISPLAY_SELECTED_SEGMENTT );

		// Category
		createCodeableConceptCategory(diffusedSegmentsObservation,TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY );
		
		// Subject
		setObservationSubject(diffusedSegmentsObservation);

		// EffectiveDateTime
		setEffectiveDateTime(diffusedSegmentsObservation);

		//bodySite
		String code = segment.getNumber();
		String display = segment.getName();
		createBodySite(diffusedSegmentsObservation, TerminologyServer.SYNTAXSCORE_URL, code, display);

		// Genrate XML
		String diffuselySegmentListObservationXml = generateObservationXML(diffusedSegmentsObservation);
		return diffuselySegmentListObservationXml;
	}
}