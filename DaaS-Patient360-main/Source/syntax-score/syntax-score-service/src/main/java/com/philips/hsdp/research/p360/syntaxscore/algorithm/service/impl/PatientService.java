/*  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Meta;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Service;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel.PatientInfo;

/** @author Raj Kumar */
@Service
public class PatientService {

	/**
	 * Generates patient resource
	 * @return Patient object
	 * @throws ParseException
	 */
	public Patient getPatientInfo() throws ParseException {
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		Date birthDay = dateFormatter.parse("12-08-1980");
		PatientInfo patientInfo = new PatientInfo("John Doe", null, birthDay);
		final Patient patient = new Patient();
		patient.setId(patientInfo.getPatientId());
		Meta meta = new Meta();
		List<CanonicalType> profiles = new ArrayList<>();
		profiles.add(new CanonicalType(
				"https://www.fhir.philips.com/4.0/StructureDefinition/common/resource/general/patient-v1/ILSPatient"));
		profiles.add(new CanonicalType("http://hl7.org/fhir/StructureDefinition/Patient"));
		meta.setProfile(profiles);
		patient.setMeta(meta);
		patient.addName().setUse(HumanName.NameUse.OFFICIAL).setFamily(patientInfo.getPatientName())
				.addGiven(patientInfo.getMiddleName());
		patient.setGender(patientInfo.getGender());
		patient.addTelecom().setSystem(ContactPoint.ContactPointSystem.PHONE).setValue(patientInfo.getWorkPhoneNumber())
				.setUse(ContactPoint.ContactPointUse.WORK).setRank(1);
		patient.addTelecom().setSystem(ContactPoint.ContactPointSystem.PHONE).setValue(patientInfo.getMobileNumber())
				.setUse(ContactPoint.ContactPointUse.MOBILE).setRank(2);
		patient.setBirthDate(patientInfo.getDateOfBirth());
		patient.setDeceased(new BooleanType(false));
		patient.addAddress().setUse(Address.AddressUse.HOME).setType(Address.AddressType.BOTH)
				.setText(patientInfo.getFullAddress()).addLine(patientInfo.getStreetAddress())
				.setCity(patientInfo.getCityName()).setDistrict(patientInfo.getDistrict())
				.setState(patientInfo.getState()).setPostalCode(patientInfo.getZipCode())
				.setCountry(patientInfo.getCountry());
		return patient;
	}
}