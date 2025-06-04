/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.fhdl.proposition.onboarding.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.philips.hsdp.research.fhdl.proposition.onboarding.model.ResourceInfo;

/* @author Sunil Kumar */
@Service
public class MdmData {

	@Autowired
	private DynamoDBMapper dynamoDbMapper;

	/**
	 * This function is to get data from dynamodb by profileName index .
	 * 
	 * @param Map<String, String> : profileMap
	 * 
	 */
	public Map<String, String> getMdmData() {
		List<ResourceInfo> result = dynamoDbMapper.scan(ResourceInfo.class, new DynamoDBScanExpression());
		Iterator<ResourceInfo> iterator = result.iterator();
		Map<String, String> profileMap = new HashMap<>();
		while (iterator.hasNext()) {
			ResourceInfo itProfile = iterator.next();
			String value = itProfile.getProfileName();
			profileMap.put(itProfile.getProfileName(), value);
		}
		return profileMap;
	}
}