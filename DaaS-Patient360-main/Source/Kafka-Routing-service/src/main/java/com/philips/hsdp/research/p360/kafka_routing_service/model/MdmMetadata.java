/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.kafka_routing_service.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
/* @author Rajeshwar Tondare */
@Data
@DynamoDBTable(tableName = "proposition_metadata")
public class MdmMetadata {	
	@DynamoDBHashKey(attributeName = "propositionId")
    private String propositionId;
	@DynamoDBAttribute(attributeName = "profileName")
    private String profileName;
    private String propositionName;
    private String organizationName;
    private String departmentName;
    private String algorithmEndpoint;
    private String createdDateTime;
    private String resourceCreatedDateTime;
    private String propositionTags;
    private String profileStructure;
    private String organizationId;
    private String baseTopicName;
    private String requestTopicName;
    private String resultTopicName;
}