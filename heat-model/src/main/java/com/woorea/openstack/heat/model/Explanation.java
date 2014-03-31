package com.woorea.openstack.heat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("error")
public class Explanation {
    @JsonProperty("explanation")
    private String explanation;

    @JsonProperty("code")
    private int code;

    @JsonRootName("error")
    public static class Error {
        @JsonProperty("message")
        private String message;

        @JsonProperty("traceback")
        private String traceback;

        @JsonProperty("type")
        private String type;

        @JsonProperty("title")
        private String title;
    }
}
