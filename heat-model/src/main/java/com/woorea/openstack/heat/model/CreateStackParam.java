package com.woorea.openstack.heat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CreateStackParam {
    @JsonProperty("stack_name")
    private String stackName;

    @JsonProperty("template_url")
    private String templateUrl;

    @JsonProperty
    private String template;

    @JsonProperty("parameters")
    private Map<String, String> parameters;

    @JsonProperty("timeout_mins")
    private int timeoutMinutes;

    @JsonProperty("environment")
    private String environment;

    public String getStackName() {
        return stackName;
    }

    public void setStackName(String stackName) {
        this.stackName = stackName;
    }

    public String getTemplateUrl() {
        return templateUrl;
    }

    /**
     * The URL of the template to instantiate. This value is ignored if the template is supplied inline.
     *
     * @param templateUrl a template url.
     */
    public void setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public String getTemplate() {
        return template;
    }

    /**
     * A JSON template to instantiate. This value takes precedence over the template URL if both are supplied.
     *
     * @param template a template json.
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public int getTimeoutMinutes() {
        return timeoutMinutes;
    }

    public void setTimeoutMinutes(int timeoutMinutes) {
        this.timeoutMinutes = timeoutMinutes;
    }

    public String getEnvironment() {
        return environment;
    }

    /**
     * A JSON environment for the stack.
     *
     * @param environment a environment.
     */
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "CreateStackParam{" +
                "stackName='" + stackName + '\'' +
                ", templateUrl='" + templateUrl + '\'' +
                ", template='" + template + '\'' +
                ", parameters=" + parameters +
                ", timeoutMinutes=" + timeoutMinutes +
                ", environment='" + environment + '\'' +
                '}';
    }
}
