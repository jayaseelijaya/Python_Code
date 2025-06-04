/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.fhdl.proposition.onboarding;

import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.philips.hsdp.research.fhdl.proposition.onboarding.constants.Constants;
import com.philips.research.fhdl.common.vault.VaultService;

/* @author Sunil Kumar */
@SpringBootApplication

public class PropositionOnboardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropositionOnboardingApplication.class, args);
	}

	@PostConstruct
	public void loadAppProperties() {
		VaultService.intializeVaultProperties(Constants.VAULT_KEYS);
	}
}