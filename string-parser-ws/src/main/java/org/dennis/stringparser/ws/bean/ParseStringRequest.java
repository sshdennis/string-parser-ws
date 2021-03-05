package org.dennis.stringparser.ws.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Author:   dsu01
 * Date:     2021/2/28 4:22 下午
 * Description: For parse string API request.
 */
public class ParseStringRequest {

    @JsonProperty("input_string")
    private String inputString;

    @JsonProperty("limit")
    private Integer limit;

    public String getInputString() {
        return this.inputString;
    }

    public void setInputString(final String inputString) {
        this.inputString = inputString;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(final Integer limit) {
        this.limit = limit;
    }
}
