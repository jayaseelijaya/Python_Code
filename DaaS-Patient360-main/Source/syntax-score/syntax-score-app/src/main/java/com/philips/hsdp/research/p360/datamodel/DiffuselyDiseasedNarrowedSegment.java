/*
 *  Copyright(C) Koninklijke Philips Electronics N.V. 2022
 *
 *  All rights are reserved. Reproduction or transmission in whole or in part, in
 *  any form or by any means, electronic, mechanical or otherwise, is prohibited
 *  without the prior written permission of the copyright owner.
 */
package com.philips.hsdp.research.p360.datamodel;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** @author Raj Kumar */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "present",
    "diffusely_diseased_narrowed_segment_list"
})
@Generated("jsonschema2pojo")
public class DiffuselyDiseasedNarrowedSegment {

    @JsonProperty("present")
    private Boolean present;
    @JsonProperty("diffusely_diseased_narrowed_segment_list")
    private List<String> diffuselyDiseasedNarrowedSegmentList = new ArrayList<String>();

    /* No args constructor for use in serialization */
    public DiffuselyDiseasedNarrowedSegment() {}

    /** 
     * @param diffuselyDiseasedNarrowedSegmentList
     * @param present
     */
    public DiffuselyDiseasedNarrowedSegment(Boolean present, List<String> diffuselyDiseasedNarrowedSegmentList) {
        super();
        this.present = present;
        this.diffuselyDiseasedNarrowedSegmentList = diffuselyDiseasedNarrowedSegmentList;
    }

    @JsonProperty("present")
    public Boolean getPresent() {
        return present;
    }

    @JsonProperty("present")
    public void setPresent(Boolean present) {
        this.present = present;
    }

    @JsonProperty("diffusely_diseased_narrowed_segment_list")
    public List<String> getDiffuselyDiseasedNarrowedSegmentList() {
        return diffuselyDiseasedNarrowedSegmentList;
    }

    @JsonProperty("diffusely_diseased_narrowed_segment_list")
    public void setDiffuselyDiseasedNarrowedSegmentList(List<String> diffuselyDiseasedNarrowedSegmentList) {
        this.diffuselyDiseasedNarrowedSegmentList = diffuselyDiseasedNarrowedSegmentList;
    }
}