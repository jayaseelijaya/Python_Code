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
public class SelectedSegmentObservation extends ILSObservation{
	
	private static final String ILS_PROFILE_SELECTED_SEGMENT = "https://www.fhir.philips.com/4.0/StructureDefinition/cardiology/coronaryArteryDisease/score/syntaxScore-v1/lesionSyntaxSubscore/LesionSyntaxSubscoreSegment";
	private Observation selectedSegmentsObservation = new Observation();
	private String segmentString;

	public SelectedSegmentObservation(String segmentString) {
		super();
		this.segmentString = segmentString;
	}
	
	/**
	 * Generates Selected Segment observation
	 * @return observation XML string
	 * @throws UnsupportedEncodingException 
	 * @throws JsonProcessingException 
	 */
	public String createObservation() throws UnsupportedEncodingException, JsonProcessingException  {
		
		byte[] decoded = Base64.getUrlDecoder().decode(this.segmentString);
		String json = new String(decoded, "UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		Segment segment = objectMapper.readValue(json, Segment.class);

		// Id
		initializeObservationId(selectedSegmentsObservation);

		// Meta
		createMetaData(selectedSegmentsObservation, ILS_PROFILE_SELECTED_SEGMENT);

		//Status
		setObservationStatus(selectedSegmentsObservation);	

		// Category
		createCodeableConceptCategory(selectedSegmentsObservation, TerminologyServer.TERIMOLOGY_URL,
				TerminologyServer.SURVEY, TerminologyServer.SURVEY);

		// Code
		createCodeableConcept(selectedSegmentsObservation, Snomed.SNOMED_URL,
				Snomed.SNOMED_CODE_SELECTED_SEGMENT,
				Snomed.SNOMED_DISPLAY_SELECTED_SEGMENTT);

		// Subject
		setObservationSubject(selectedSegmentsObservation);

		// EffectiveDateTime
		setEffectiveDateTime(selectedSegmentsObservation);

		//bodySite
		String code = segment.getNumber();
		String display = segment.getName();
		createBodySite(selectedSegmentsObservation, TerminologyServer.SYNTAXSCORE_URL, code, display);

		// Genrate XML
		String selectedSegmentsObservationXml = generateObservationXML(selectedSegmentsObservation);
		return selectedSegmentsObservationXml;
	}
}