/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.kafka_routing_service.service;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.philips.hsdp.research.p360.kafka_routing_service.constants.Constants;
import com.philips.hsdp.research.p360.kafka_routing_service.model.MdmMetadata;

/* @author Rajeshwar Tondare */
@Service
public class Consumer {
	private static final Logger log = LoggerFactory.getLogger(Consumer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private DynamoDBMapper dynamoDbMapper;
	
	@KafkaListener(topics="${kafka.topic_name}")
	public void kafkaListener(JSONObject dataFromTopic1, @Headers MessageHeaders messageHeaders) {
		log.info("============================");
		String data = dataFromTopic1.toString(4);
		log.info("Consumed data at kafka 1: {}", data);
		JSONObject headerDetails = new JSONObject();
		String propositionIdValue = "";
		for (String key : messageHeaders.keySet()) {
			Object value = messageHeaders.get(key);
			if (key.equals(Constants.PROPOSITIONID)) {
				propositionIdValue = new String((byte[]) value, StandardCharsets.UTF_8);
				log.info("kafka 1 topic: {}", Constants.TOPIC1);
				log.info("Reading propositionid from header {}: {}", key, propositionIdValue);
			} else {
				log.info("{}: {}", key, value);
			}
		}
		for (String key : messageHeaders.keySet()) {
			Object value = messageHeaders.get(key);
			if (key.equals(Constants.ORGID)) {
				headerDetails.put(Constants.ORGID, new String((byte[]) value, StandardCharsets.UTF_8));
			} else if (key.equals(Constants.PROFILENAME)) {
				headerDetails.put(Constants.PROFILENAME, new String((byte[]) value, StandardCharsets.UTF_8));

			} else if (key.equals(Constants.PROPOSITIONID)) {
				headerDetails.put(Constants.PROPOSITIONID, new String((byte[]) value, StandardCharsets.UTF_8));

			} else {
				log.info("{}: {}", key, value);
			}		
		}
		if (propositionIdValue != null) {
			getMetaInfoFromMdm(propositionIdValue);
			publishDataToRequestTopic(headerDetails, data);
		}
	}
	
	/**
	 * This function is used to get metadata from MDM using propositionId
	 * @param propositionId 
	 * @return data of proposition
	 */
	public void getMetaInfoFromMdm(String propositionId) {
		MdmMetadata metadata = new MdmMetadata();
		metadata.setPropositionId(propositionId);
		DynamoDBQueryExpression<MdmMetadata> queryExpression = new DynamoDBQueryExpression<MdmMetadata>()
				.withHashKeyValues(metadata).withLimit(10);

		List<MdmMetadata> result = dynamoDbMapper.query(MdmMetadata.class, queryExpression);
		JSONObject jsonObject = null ;
		for(MdmMetadata mdm:result) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonInString = gson.toJson(mdm);
			jsonObject = new JSONObject(jsonInString);
				log.info("Pulling meta info from MDM using proposition Id::{}",jsonObject.toString(4));			
		}		
	}
	
	/**
	 * This function is used to publish data to request topic
	 * @param headerDetails 
	 * @param dataOfProposition
	 */
	String publishDataToRequestTopic(JSONObject headerDetails,String dataOfProposition) {
		ProducerRecord<String, String> producerRecord = new ProducerRecord<>(Constants.TOPIC2, dataOfProposition);
        producerRecord
        .headers()
        .add(Constants.ORGID,headerDetails.get(Constants.ORGID).toString().getBytes(StandardCharsets.UTF_8))
        .add(Constants.PROFILENAME,headerDetails.get(Constants.PROFILENAME).toString().getBytes(StandardCharsets.UTF_8))
        .add(Constants.PROPOSITIONID,headerDetails.get(Constants.PROPOSITIONID).toString().getBytes(StandardCharsets.UTF_8));
        
		log.info("Publishing details to topic 2 :{}......", Constants.TOPIC2);
		log.info("data of Proposition :{}......", headerDetails);
		this.kafkaTemplate.send(producerRecord);
		return headerDetails.toString();
	}
}