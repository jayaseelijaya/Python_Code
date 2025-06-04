/**
 * (C) Koninklijke Philips Electronics N.V. 2021
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner. 
 **/
package com.philips.hsdp.research.fhdl.fhirservice.util;

import java.io.IOException;

import org.hl7.fhir.common.hapi.validation.support.CommonCodeSystemsTerminologyService;
import org.hl7.fhir.common.hapi.validation.support.InMemoryTerminologyServerValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.ValidationSupportChain;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.validation.FhirValidator;
import ca.uhn.fhir.validation.ValidationResult;
import org.springframework.stereotype.Component;

/*
 * @author Raj Kumar
 */
@Component
public class FHIRValidatorUtil {

	private static final Logger log = LoggerFactory.getLogger(FHIRValidatorUtil.class);

	public ValidationResult validate(String content, String version) throws IOException {
		FhirContext fhirContext = null;
		if (version.equalsIgnoreCase("3.0")) {
			fhirContext = FhirContext.forDstu3();
			log.info("Validating with version STU3");
		} else if (version.equalsIgnoreCase("4.0")) {
			fhirContext = FhirContext.forR4();
			log.info("Validating with version R4");
		}
		return validateFHIR(content, fhirContext);
	}

	private ValidationResult validateFHIR(String input, FhirContext fhirContext) {
		ValidationSupportChain validationSupportChain = new ValidationSupportChain(
				new DefaultProfileValidationSupport(fhirContext),
				new InMemoryTerminologyServerValidationSupport(fhirContext),
				new CommonCodeSystemsTerminologyService(fhirContext));
		FhirValidator validator = fhirContext.newValidator();
		FhirInstanceValidator instanceValidator = new FhirInstanceValidator(validationSupportChain);
		validator.registerValidatorModule(instanceValidator);
		return validator.validateWithResult(input);
	}
}