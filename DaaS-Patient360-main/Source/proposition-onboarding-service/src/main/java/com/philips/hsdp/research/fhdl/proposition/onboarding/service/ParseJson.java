/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.fhdl.proposition.onboarding.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/* @author Sunil Kumar */
@Component
public class ParseJson {

	/**
	 * This function is to get input of json and parse it and add in map.
	 * 
	 * @param JsonNode : request parameter json String
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public JSONObject convertJson(JsonNode response) throws IOException, JSONException {
		String stringToParse = response.toString();
		Map<String, String> map = null;
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonResponse = mapper.readTree(stringToParse);
		String profileName = jsonResponse.get("Profile Name").asText();
		String propositionName = jsonResponse.get("Proposition Name").asText();
		String organizationName = jsonResponse.get("Organization Name").asText();
		String departmentName = jsonResponse.get("Department Name").asText();
		String algorithmEndpoint = jsonResponse.get("Algorithm Endpoint").asText();
		String propositionTags = jsonResponse.get("Proposition Tags").asText();
		String profileStructure = jsonResponse.get("Profile Structure File").asText();
		if ((!"".equals(profileName)) && (!"".equals(propositionName)) && (!"".equals(organizationName))
				&& (!"".equals(departmentName)) && (!"".equals(algorithmEndpoint)) && (!"".equals(propositionTags))
				&& (!"".equals(profileStructure))) {
			map = new HashMap<>();
			map.put("profileName", profileName);
			map.put("propositionName", propositionName);
			map.put("organizationName", organizationName);
			map.put("departmentName", departmentName);
			map.put("algorithmEndpoint", algorithmEndpoint);
			map.put("propositionTags", propositionTags);
			map.put("profileStructure", profileStructure);
			return new JSONObject(map);
		} else {
			String jsonProfile = "{" + " \"Message\" " + ":" + " \"Invalid input\" " + "}";
			return new JSONObject(jsonProfile);
		}
	}

	/**
	 * This function is to create unique UUID.
	 * 
	 * @param String : UUID
	 * 
	 * @throws IOException
	 */
	public String createUUid() {
		UUID uid = null;
		String orgId = null;
		int num = 2;
		for (int uuidNumber = 1; uuidNumber < num; uuidNumber++) {
			uid = UUID.randomUUID();
			orgId = uid.toString();
		}
		return orgId;
	}
}