
package com.philips.research.fhdl.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.philips.research.fhdl.common.vault.VaultService;

@SpringBootApplication
public class FhdlCommonApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(FhdlCommonApplication.class, args);
	}
	
} 

