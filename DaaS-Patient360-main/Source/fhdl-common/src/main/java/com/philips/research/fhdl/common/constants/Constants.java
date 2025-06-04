/*

(C) Koninklijke Philips Electronics N.V. 2021
All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
the copyright owner.

*/
package com.philips.research.fhdl.common.constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Reshmy R
 *
 */
public class Constants {

	private Constants() {
		throw new IllegalStateException("Constants class");
	}

	public static final char AMPERSAND = '&';
	public static final char EQUALS_TO = '=';
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String API_VERSION = "api-version";
	public static final String FORM_KEY_GRANT_TYPE = "grant_type";
	public static final String API_VERSION_VALUE_2 = "2";

	public static final String JWT_HEADER_NAME_ALGORITHM = "alg";
	public static final String JWT_HEADER_NAME_TYPE = "typ";
	public static final String JWT_SIG_ALG_RS256 = "RS256";
	public static final String JWT_TYPE = "JWT";
	public static final String JWT_HSDP_AUD_ENDPOINT = "/oauth2/access_token";
	public static final String RSA_KF_ALGORITHM = "RSA";
	public static final String ZONE_UTC = "UTC";
	public static final int JWT_TOKEN_VALIDITY = 2 * 60 * 60 * 1000; // 2 hrs in milliseconds
	public static final String FORM_VALUE_JWT_BEARER = "urn:ietf:params:oauth:grant-type:jwt-bearer";
	public static final String FORM_KEY_ASSERTION = "assertion";
	public static final String HSDP_ENDPOINT_GET_IAM_ACCESS_TOKEN = "/authorize/oauth2/token";
	public static final String JWT_TOKEN_GENERATION_FAILED = "Failed to generate a JWT token";
	public static final String PRIVATE_KEY_BEGIN = "-----BEGIN\\sRSA\\sPRIVATE\\sKEY-----";
	public static final String PRIVATE_KEY_END = "-----END\\sRSA\\sPRIVATE\\sKEY-----";
	public static final String PRIVATE_KEY_BEGIN_NO_SPACE = "-----BEGINRSAPRIVATEKEY-----";
	public static final String PRIVATE_KEY_END_NO_SPACE = "-----ENDRSAPRIVATEKEY-----";
	public static final String ACCESS_TOKEN = "{\"access_token\":\"accessToken\"}";
	public static final String IAM_CHARSET = "utf-8";
	public static final String IAM_CONTENT_TYPE = "application/x-www-form-urlencoded"; //
	public static final String TOKEN_PATTERN = ".*\"access_token\"\\s*:\\s*\"([^\"]+)\".*";
}
