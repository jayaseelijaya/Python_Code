/*
 * (C) Koninklijke Philips Electronics N.V. 2022
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.daas.cds.transformation.service;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.node.ObjectNode;

/* @author Sunil Kumar */
@Service
public interface CDRPatientDetailsService {
	public void updatePatientDetails(String accessToken, String cdrUrl, ObjectNode jsonObject2, String resourceType);
}