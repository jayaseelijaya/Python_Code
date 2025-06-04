package com.philips.hsdp.research.fhdl.fhirservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;
import com.philips.hsdp.research.fhdl.fhirservice.constant.Constants;
import com.philips.research.fhdl.common.vault.VaultService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

/*
 * @author Rajeshwar Tondare
 */
@OpenAPIDefinition(info = @Info(title = "Fhir Service API", version = "1.0", description = "Fhir Service API Information"))
@SecurityScheme(name = "fhir interface api", scheme = "Bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
@SpringBootApplication
public class FhirServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FhirServiceApplication.class, args);
	}

	@PostConstruct
	public void loadAppProperties() {
		VaultService.intializeVaultProperties(Constants.VAULT_KEYS);

	}
}