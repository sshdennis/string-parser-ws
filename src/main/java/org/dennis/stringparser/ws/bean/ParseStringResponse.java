package org.dennis.stringparser.ws.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Author:   dsu01
 * Date:     2021/2/28 4:32 下午
 * Description: For parse string API response.
 */
public class ParseStringResponse {

    @JsonProperty("string_result_list")
    private List<Long> stringResults;

    public ParseStringResponse(final List<Long> stringResults) {
        this.stringResults = stringResults;
    }

    public List<Long> getStringResults() {
        return this.stringResults;
    }

    public void setStringResults(final List<Long> stringResults) {
        this.stringResults = stringResults;
    }
}
