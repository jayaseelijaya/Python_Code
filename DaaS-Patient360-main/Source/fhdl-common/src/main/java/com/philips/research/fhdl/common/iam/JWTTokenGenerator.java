/*

(C) Koninklijke Philips Electronics N.V. 2021
All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
the copyright owner.

 */
package com.philips.research.fhdl.common.iam;

import static com.philips.research.fhdl.common.constants.Constants.JWT_HEADER_NAME_ALGORITHM;
import static com.philips.research.fhdl.common.constants.Constants.JWT_HEADER_NAME_TYPE;
import static com.philips.research.fhdl.common.constants.Constants.JWT_HSDP_AUD_ENDPOINT;
import static com.philips.research.fhdl.common.constants.Constants.JWT_SIG_ALG_RS256;
import static com.philips.research.fhdl.common.constants.Constants.JWT_TOKEN_GENERATION_FAILED;
import static com.philips.research.fhdl.common.constants.Constants.JWT_TOKEN_VALIDITY;
import static com.philips.research.fhdl.common.constants.Constants.JWT_TYPE;
import static com.philips.research.fhdl.common.constants.Constants.PRIVATE_KEY_BEGIN;
import static com.philips.research.fhdl.common.constants.Constants.PRIVATE_KEY_BEGIN_NO_SPACE;
import static com.philips.research.fhdl.common.constants.Constants.PRIVATE_KEY_END;
import static com.philips.research.fhdl.common.constants.Constants.PRIVATE_KEY_END_NO_SPACE;
import static com.philips.research.fhdl.common.constants.Constants.RSA_KF_ALGORITHM;
import static com.philips.research.fhdl.common.constants.Constants.ZONE_UTC;

import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author Reshmy R
 *
 */

@Log4j2
public class JWTTokenGenerator {
	private static Logger log = LoggerFactory.getLogger(JWTTokenGenerator.class);
	private static final String ERROR_MESSAGE = "...{}";
	private JWTTokenGenerator() {
		// Static class
	}

	/**
	 * 
	 * Generates a JWT token for the configured HSDP Service Identity as allowed by
	 * the HSDP services
	 * 
	 * @param serviceId
	 * @param privateKey
	 * @return jwtToken
	 */
	public static String generateJWTToken(String hsdpIAMHost, String serviceIdentityServiceId, String privateKey) {
		log.info("Generating a new JWT token for the configured HSDP Service Identity...");
		String jwtToken = null;
		try {
			HashMap<String, Object> jwtHeaders = new HashMap<>(3);
			jwtHeaders.put(JWT_HEADER_NAME_ALGORITHM, JWT_SIG_ALG_RS256);
			jwtHeaders.put(JWT_HEADER_NAME_TYPE, JWT_TYPE);
			Date now = Calendar.getInstance(TimeZone.getTimeZone(ZONE_UTC)).getTime();
			Date expireAfter = new Date(now.getTime() + JWT_TOKEN_VALIDITY);
			jwtToken = Jwts.builder().setHeader(jwtHeaders).setAudience(hsdpIAMHost + JWT_HSDP_AUD_ENDPOINT)
					.setIssuer(serviceIdentityServiceId).setSubject(serviceIdentityServiceId).setExpiration(expireAfter)
					.setIssuedAt(now).signWith(SignatureAlgorithm.RS256, preparePrivateKey(privateKey)).compact();
		} catch (Exception exception) {
			log.error(JWT_TOKEN_GENERATION_FAILED + ERROR_MESSAGE, exception.getMessage());
		}
		log.info("Generated a new JWT token for the configured HSDP Service Identity");
		return jwtToken;
	}

	/**
	 * prepares the private key
	 * 
	 * @param privateKeyz
	 * @return formatted key
	 */
	public static Key preparePrivateKey(String privateKey) {
		log.info("Converting the private key from string format to algorithm-specific signing key format...");
		PrivateKey rsaPrivateKey = null;
		try {
			byte[] privateKeyAsBytes = Base64.decodeBase64(privateKey.replaceAll("\\s", "")
					.replace(PRIVATE_KEY_BEGIN, "").replace(PRIVATE_KEY_BEGIN_NO_SPACE, "").replace(PRIVATE_KEY_END, "")
					.replace(PRIVATE_KEY_END_NO_SPACE, ""));
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyAsBytes);
			KeyFactory keyFactory = KeyFactory.getInstance(RSA_KF_ALGORITHM);
			rsaPrivateKey = keyFactory.generatePrivate(keySpec);
			log.info("Converted the private key from string format to algorithm-specific signing key format");
		} catch (InvalidKeySpecException | NoSuchAlgorithmException exception) {
			log.error(JWT_TOKEN_GENERATION_FAILED + "KeyFactory Algorithm used = " + RSA_KF_ALGORITHM + ERROR_MESSAGE,
					exception.getMessage());
		} catch (Exception exception) {
			log.error(JWT_TOKEN_GENERATION_FAILED + ERROR_MESSAGE, exception.getMessage());
		}
		return rsaPrivateKey;
	}
}
