package com.woorea.openstack.ceilometer.v2.model;

import java.util.List;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonProperty;

public class Resource {

    @JsonProperty("first_sample_timestamp")
    private String firstSampleTimestamp;
    @JsonProperty("last_sample_timestamp")
    private String lastSampleTimestamp;
    private List<Link> links;
    private Map<String, Object> metadata;
    @JsonProperty("project_id")
    private String project;
    @JsonProperty("resource_id")
    private String resource;
    @JsonProperty("user_id")
    private String user;

    public String getResource() {
        return resource;
    }

    public String getProject() {
        return project;
    }

    public String getUser() {
        return user;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public List<Link> getLinks() {
        return links;
    }

    public String getFirstSampleTimestamp() {
        return firstSampleTimestamp;
    }

    public String getLastSampleTimestamp() {
        return lastSampleTimestamp;
    }

    public void setFirstSampleTimestamp(String firstSampleTimestamp) {
        this.firstSampleTimestamp = firstSampleTimestamp;
    }

    public void setLastSampleTimestamp(String lastSampleTimestamp) {
        this.lastSampleTimestamp = lastSampleTimestamp;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Resource [resource=" + resource + ", first_sample_timestamp=" + firstSampleTimestamp
                + ", last_sample_timestamp=" + lastSampleTimestamp
                + ", project=" + project + ", user=" + user + ", metadata="
                + metadata + ", links=" + links + "]";
    }
}
