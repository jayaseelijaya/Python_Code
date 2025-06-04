/*

(C) Koninklijke Philips Electronics N.V. 2021
All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
the copyright owner.

*/

package com.philips.research.fhdl.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;


//@Log4j2
@Slf4j
public class CustomExceptionHandler {
	private static Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);
	private CustomExceptionHandler() {
		throw new IllegalStateException("Exception handler class. Cannot instantiate.");
	}

	private static void handleCustomException(CustomException customException) {
		String errorMessage = customException.logMessage();
		log.error("Exception occurred : {}", errorMessage);
		
	}

	private static void handleException(Exception exception) {
		CustomException customException = new CustomException(CustomExceptionMessages.UNKNOWN,
				exception);
		String errorMessage = customException.logMessage();
		log.error("Exception occurred : {}", errorMessage);
	}

	public static void handle(Exception exception) {
		if (exception instanceof CustomException) {
			handleCustomException((CustomException) exception);
		} else {
			handleException(exception);
		}
	}

}
