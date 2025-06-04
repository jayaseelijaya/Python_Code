/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.datamodel;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.hl7.fhir.r4.model.Enumerations;
import java.util.Date;
import java.util.UUID;

/* @author Sunil Kumar */
public class PatientInfo {
	private String patientName;
	private String patientId;
	private Date dateOfBirth;
	private String familyName;
	private String middleName;
	private String mobileNumber;
	private String workPhoneNumber;
	private String fullAddress;
	private String streetAddress;
	private String cityName;
	private String district;
	private String state;
	private String zipCode;
	private String country;
	private Faker faker;
	private Name name;
	private Enumerations.AdministrativeGender gender;

	public PatientInfo(String patientName, String patientId, Date dateOfBirth) {
		this.patientName = patientName == null ? getFamilyName() : patientName;
		this.patientId = patientId == null ? UUID.randomUUID().toString() : patientId;
		this.dateOfBirth = dateOfBirth;

		faker = new Faker();
		name = faker.name();

		gender = faker.bool().bool() == true ? Enumerations.AdministrativeGender.MALE
				: Enumerations.AdministrativeGender.FEMALE;

		familyName = name.lastName();
		middleName = name.nameWithMiddle();
		mobileNumber = faker.phoneNumber().cellPhone();
		workPhoneNumber = faker.phoneNumber().phoneNumber();

		fullAddress = faker.address().fullAddress();
		streetAddress = faker.address().streetAddress();
		cityName = faker.address().cityName();
		district = faker.address().city();
		state = faker.address().state();
		zipCode = faker.address().zipCode();
		country = faker.address().country();
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public Enumerations.AdministrativeGender getGender() {
		return gender;
	}

	public void setGender(Enumerations.AdministrativeGender gender) {
		this.gender = gender;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}