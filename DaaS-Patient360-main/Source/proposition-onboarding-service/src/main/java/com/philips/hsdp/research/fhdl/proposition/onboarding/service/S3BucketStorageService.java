/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.fhdl.proposition.onboarding.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3URI;
import com.amazonaws.services.s3.model.S3Object;

/* @author Sunil Kumar */
@Service
public class S3BucketStorageService {

	@Autowired
	private AmazonS3 amazonS3Client;

	public String getProfileStructureContent(String profileStructureUri) throws URISyntaxException, IOException {
		String result = null;
		InputStream reader = null;
		S3Object s3Object = null;
		URI fileToBeDownloaded = new URI(profileStructureUri);
		AmazonS3URI s3URI = new AmazonS3URI(fileToBeDownloaded);
		s3Object = amazonS3Client.getObject(s3URI.getBucket(), s3URI.getKey());
		reader = new BufferedInputStream(s3Object.getObjectContent());
		result = new BufferedReader(new InputStreamReader(reader)).lines().parallel().collect(Collectors.joining("\n"));
		reader.close();
		return result;
	}
}