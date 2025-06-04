/*  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.algorithm.datamodel;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import lombok.Data;
import org.hl7.fhir.r4.model.Enumerations;
import java.util.Date;
import java.util.UUID;

/* @Author Raj Kumar*/
@Data
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

        gender = faker.bool().bool() ?
                Enumerations.AdministrativeGender.MALE :
                Enumerations.AdministrativeGender.FEMALE;

        this.patientName = name.firstName();
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
}