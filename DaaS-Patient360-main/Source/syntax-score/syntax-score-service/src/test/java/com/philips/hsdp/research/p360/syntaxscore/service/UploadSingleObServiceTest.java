/*
 * (C) Koninklijke Philips Electronics N.V. 2021
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.UploadSingleObservationService;

/* @author Priyanka Mallick */
@ExtendWith(MockitoExtension.class)
class UploadSingleObServiceTest {

	@InjectMocks
	UploadSingleObservationService uploadSingleObservationService;

	@Test
	void testConvert() throws Exception {
		MockMultipartFile file = new MockMultipartFile("file", "test.json", MediaType.APPLICATION_JSON_VALUE,
				"{\"name\" : \"Test\"}".getBytes());
		String result = uploadSingleObservationService.convert(file);
		assertNotNull(result);
	}
}