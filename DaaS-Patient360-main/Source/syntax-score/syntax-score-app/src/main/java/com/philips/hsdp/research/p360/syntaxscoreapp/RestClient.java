/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.syntaxscoreapp;

import jakarta.ws.rs.core.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

/*@author Raj Kumar */
public class RestClient {
	/**
	 * This function is used to calculate Syntax score for Aorto Ostial of Left
	 * Dominance
	 *
	 * @Http Method post : to send request with success or failure http error code
	 * @param URL : send request as body to accept rest api
	 * @param :   to generate score in float value
	 * @return : response connection successfully
	 */
	static Response post(final URL url) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "application/xml");

		if (connection.getResponseCode() != 200) {
			throw new ConnectException("Failed : HTTP error code : " + connection.getResponseCode());
		} else {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder stringBuilder = new StringBuilder();

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line + '\n');
			}
			String response = stringBuilder.toString();
			return Response.status(Response.Status.OK).entity(response).build();
		}
	}

	private RestClient() {
	}
}