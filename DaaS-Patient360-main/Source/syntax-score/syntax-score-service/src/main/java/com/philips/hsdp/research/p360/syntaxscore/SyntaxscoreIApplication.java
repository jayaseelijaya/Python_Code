/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@ComponentScan(basePackages = {"com.philips.hsdp.research.p360.syntaxscore","com.philips.hsdp.research.p360.syntaxscore.algorithm.dataModel", "com.philips.hsdp.research.p360.syntaxscore.algorithm.processor", "com.philips.hsdp.research.p360.syntaxscore.algorithm.ServiceImpl"})
@OpenAPIDefinition(info = @Info(title = "SyntaxScore API", version = "1.0", description = "SyntaxScore API New"))
@SpringBootApplication
@EnableAutoConfiguration

/* @author Sunil Kumar*/
public class SyntaxscoreIApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SyntaxscoreIApplication.class, args);
	}
}