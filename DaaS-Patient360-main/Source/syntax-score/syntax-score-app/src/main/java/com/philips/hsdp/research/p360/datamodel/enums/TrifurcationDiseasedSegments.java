/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */

package com.philips.hsdp.research.p360.datamodel.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)

/** @author Raj Kumar */
public enum TrifurcationDiseasedSegments {

    ONE_DISEASED_SEGMENT_INVOLVED (1),
    TWO_DISEASED_SEGMENT_INVOLVED (2),
    THREE_DISEASED_SEGMENT_INVOLVED (3),
    FOUR_DISEASED_SEGMENT_INVOLVED (4);

    private int value;
    private TrifurcationDiseasedSegments(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}