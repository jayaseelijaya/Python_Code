/*

(C) Koninklijke Philips Electronics N.V. 2021
All rights are reserved. Reproduction or transmission in whole or in part, in any form or by any
means, electronic, mechanical or otherwise, is prohibited without the prior written consent of
the copyright owner.

*/
package com.philips.research.fhdl.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Reshmy R
 *
 */
@Getter
@Setter
public class IAMAccessToken {

	@JsonProperty(value = "access_token")
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
