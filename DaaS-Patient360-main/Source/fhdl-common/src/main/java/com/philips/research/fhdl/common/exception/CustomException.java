/*

(C) Koninklijke Philips Electronics N.V. 2021
All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
the copyright owner.

*/

package com.philips.research.fhdl.common.exception;

import lombok.Getter;

@Getter
public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	private final int httpStatusCode;
	private final int errorCode;
	private final String generalMessage;
	private String specificMessage;

	public CustomException(CustomException customException, String specificMessage) {
		this.httpStatusCode = customException.httpStatusCode;
		this.errorCode = customException.errorCode;
		this.generalMessage = customException.generalMessage;
		this.specificMessage = specificMessage;
	}

	public CustomException(CustomException customException, String specificMessage, Throwable e) {
		this.httpStatusCode = customException.httpStatusCode;
		this.errorCode = customException.errorCode;
		this.generalMessage = customException.generalMessage;
		this.specificMessage = concatenateSpecificMsgAndCause(specificMessage, e);
	}

	public CustomException(CustomException customException, Throwable e) {
		this.httpStatusCode = customException.httpStatusCode;
		this.errorCode = customException.errorCode;
		this.generalMessage = customException.generalMessage;
		this.specificMessage = getMessage(e);
	}

	public CustomException(int httpStatusCode, int code, String generalMessage) {
		this.httpStatusCode = httpStatusCode;
		this.errorCode = code;
		this.generalMessage = generalMessage;
		this.specificMessage = "";
	}
	
	private final String concatenateSpecificMsgAndCause(String specificMsg, Throwable e) {
		return "Msg : " + specificMsg + ". Exception : " + getMessage(e);
	}

	private final String getMessage(Throwable e) {
		return e.getClass().getName() + " : [ Message : " + e.getMessage() + ", Cause : " + getExceptionCause(e) + " ]";
	}

	private String getExceptionCause(Throwable e) {
		if (e.getCause() == null)
			return e.toString();
		return e.getCause().toString();
	}

	public String logMessage() {
		StringBuilder error = new StringBuilder();
		error.append("[ httpStatusCode = ").append(this.httpStatusCode).append(", errorCode = ").append(this.errorCode)
				.append(", generalMessage = ").append(this.generalMessage).append(", specificMessage = ")
				.append(this.specificMessage).append(" ]");
		return error.toString();
	}

}
