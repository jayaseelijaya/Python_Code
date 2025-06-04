/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* @author Srinivasa */
@ControllerAdvice
public class SyntaxScoreException extends Exception {

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(value = FHIRException.class)
	public ResponseEntity<Object> exception(FHIRException exception) {
		return new ResponseEntity<>("Index out of bond exception", HttpStatus.NOT_FOUND);
	}
}