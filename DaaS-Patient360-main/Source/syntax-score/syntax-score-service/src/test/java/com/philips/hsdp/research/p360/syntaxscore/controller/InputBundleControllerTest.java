/*
 * (C) Koninklijke Philips Electronics N.V. 2021
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.controller;

import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import java.text.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.InputBundleService;

/** @author Raj Kumar */
@SuppressWarnings("deprecation")
class InputBundleControllerTest {
	
	@InjectMocks
	InputBundleController inputBundleController;
	
	@Mock
	InputBundleService inputBundle;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void getPatientTest() throws IOException, ParseException {
		String jsonString = "{\"selected_dominance\":\"RIGHT\",\"lesion_profile\":[{\"lesion\":{\"number\":1,\"segments_list\":[{\"segment\":{\"number\":\"12\",\"name\":\"Intermediate/anterolateral\",\"description\":\"\"}}],\"totalocclusion\":true,\"first_totalocclusion_segment_number\":\"12\",\"is_totalocclusion_age_gt_3months\":\"YES\",\"blunt_stump\":false,\"bridging\":true,\"sidebranch_at_the_origin_of_occlusion\":\"NO\",\"severe_tortuosity\":true,\"heavy_calcification\":true,\"thrombus\":true,\"comments\":\"\"}}],\"diffusely_diseased_narrowed_segment\":{\"present\":true,\"diffusely_diseased_narrowed_segment_list\":[\"12b\"]}}";
		ResponseEntity<String> result = inputBundleController.getPatient(jsonString, "application/fhir+json; fhirVersion=4.0", "application/fhir+json; fhirVersion=4.0");
		assertNotNull(result);
	}
}