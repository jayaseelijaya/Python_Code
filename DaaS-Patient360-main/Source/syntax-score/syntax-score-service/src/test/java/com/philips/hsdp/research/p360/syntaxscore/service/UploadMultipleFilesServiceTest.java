/*
 * (C) Koninklijke Philips Electronics N.V. 2021
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.service;

import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import com.philips.hsdp.research.p360.syntaxscore.algorithm.service.impl.UploadMultipleFilesService;

/* @author Priyanka Mallick */
@ExtendWith(MockitoExtension.class)
class UploadMultipleFilesServiceTest {

	@InjectMocks
	UploadMultipleFilesService uploadMultipleFilesService;
	
	@Test
	void convertTest() throws IOException {
	 MockMultipartFile file = new MockMultipartFile("file", "test.xml", MediaType.APPLICATION_XML_VALUE, "<Observation></Observation>".getBytes());
	 MockMultipartFile[] fileNew = {file};
	 String str = uploadMultipleFilesService.convert(fileNew);
	 assertNotNull(str);
	}

	@Test
	void convertJsonTest() throws Exception {
		 MockMultipartFile file = new MockMultipartFile("file", "test.json", MediaType.APPLICATION_JSON_VALUE, "{\"name\" : \"Test\"}".getBytes());
		 MockMultipartFile[] fileNew = {file};
		 String str = uploadMultipleFilesService.convertJson(fileNew);
		 assertNotNull(str);
	}
}