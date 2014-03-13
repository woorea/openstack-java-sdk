package com.woorea.openstack.heat.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

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
