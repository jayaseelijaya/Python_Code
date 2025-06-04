/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.syntaxscore.datamodel.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/* @author Sunil Kumar */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TriState {
    NO ("no"),
    YES ("yes"),
    UNKNOWN ("Unknown");

    private String value;
    private TriState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}