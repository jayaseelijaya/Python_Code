/*
 * (C) Koninklijke Philips Electronics N.V. 2022
 *
 * All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
 * means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
 * the copyright owner.
 */

package com.philips.hsdp.research.daas.cds.transformation;

import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.philips.hsdp.research.daas.cds.transformation.constants.Constants;
import com.philips.research.fhdl.common.vault.VaultService;

/* @author Sunil Kumar */
@SpringBootApplication
public class CdsTransformationApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(CdsTransformationApplication.class, args);
	}

	@PostConstruct
	public void loadAppProperties() {
		 VaultService.intializeVaultProperties(Constants.VAULT_KEYS);
		}
}