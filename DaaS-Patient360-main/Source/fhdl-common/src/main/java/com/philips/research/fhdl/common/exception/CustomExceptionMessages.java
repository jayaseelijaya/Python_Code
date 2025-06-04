/*

(C) Koninklijke Philips Electronics N.V. 2021
All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
the copyright owner.

*/
package com.philips.research.fhdl.common.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.PRECONDITION_FAILED;

public class CustomExceptionMessages {

	public static final String IAM_ACCESSTOKEN_API_FAILED = "Failed to get an IAM access token from HSDP";
	
	private static final int ERROR_CODE_1XXX = 1000;
	public static final CustomException UNKNOWN = prepareCustomException(INTERNAL_SERVER_ERROR.value(), ERROR_CODE_1XXX, "Unknown error");
	public static final CustomException MISSING_ENV_VARIABLE = prepareCustomException(PRECONDITION_FAILED.value(), ERROR_CODE_1XXX + 1,
			"Missing environment variable");

	private CustomExceptionMessages() {
		throw new IllegalStateException("Constants class. Cannot instantiate.");
	}

	private static CustomException prepareCustomException(int httpsStatusCode, int code, String generalMessage) {
		return new CustomException(httpsStatusCode, code, generalMessage);

	}
}
