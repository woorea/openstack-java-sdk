package com.woorea.openstack.ceilometer.v2.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Meter {

    @JsonProperty("user_id")
    private String user;
    private String name;
    @JsonProperty("resource_id")
    private String resource;
    private String source;
    @JsonProperty("project_id")
    private String project;
    @JsonProperty("meter_id")
    private String meter;
    private String type;
    private String unit;

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getResource() {
        return resource;
    }

    public String getProject() {
        return project;
    }

    public String getType() {
        return type;
    }

    public String getUnit() {
        return unit;
    }

    public String getMeter() {
        return meter;
    }

    public String getSource() {
        return source;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setMeter(String meter) {
        this.meter = meter;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Meter [id=" + meter + "user=" + user + ", name=" + name + ", resource="
                + resource + ", project=" + project + ", type=" + type
                + ", unit=" + unit + ", source=" + source + "]";
    }
}
