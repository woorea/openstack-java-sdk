package com.woorea.openstack.heat.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;
import java.util.List;

public class Resource {
    @JsonProperty("resource_name")
    private String name;

    @JsonProperty("links")
    private List<Link> links;

    @JsonProperty("resource_status")
    private String status;

    @JsonProperty("physical_resource_id")
    private String physicalResourceId;

    @JsonProperty("logical_resource_id")
    private String logicalResourceId;

    @JsonProperty("required_by")
    private List<String> requiredBy;

    @JsonProperty("updated_time")
    private Date updatedTime;

    @JsonProperty("resource_type")
    private String type;

    @JsonProperty("resource_status_reason")
    private String statusReason;

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public String getLogicalResourceId() {
        return logicalResourceId;
    }

    public void setLogicalResourceId(String logicalResourceId) {
        this.logicalResourceId = logicalResourceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhysicalResourceId() {
        return physicalResourceId;
    }

    public void setPhysicalResourceId(String physicalResourceId) {
        this.physicalResourceId = physicalResourceId;
    }

    public List<String> getRequiredBy() {
        return requiredBy;
    }

    public void setRequiredBy(List<String> requiredBy) {
        this.requiredBy = requiredBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", links=" + links +
                ", status='" + status + '\'' +
                ", physicalResourceId='" + physicalResourceId + '\'' +
                ", logicalResourceId='" + logicalResourceId + '\'' +
                ", requiredBy=" + requiredBy +
                ", updatedTime=" + updatedTime +
                ", type='" + type + '\'' +
                ", statusReason='" + statusReason + '\'' +
                '}';
    }
}
