package com.woorea.openstack.heat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("stack")
public class Stack {
    @JsonProperty("description")
    private String description;

    @JsonProperty("links")
    private List<Link> links;

    @JsonProperty("stack_status_reason")
    private String stackStatusReason;

    @JsonProperty("stack_name")
    private String stackName;

    @JsonProperty("updated_time")
    private Date updatedTime;

    @JsonProperty("creation_time")
    private Date creationTime;

    @JsonProperty("stack_status")
    private String stackStatus;

    @JsonProperty("id")
    private String id;

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getStackStatus() {
        return stackStatus;
    }

    public void setStackStatus(String stackStatus) {
        this.stackStatus = stackStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getStackName() {
        return stackName;
    }

    public void setStackName(String stackName) {
        this.stackName = stackName;
    }

    public String getStackStatusReason() {
        return stackStatusReason;
    }

    public void setStackStatusReason(String stackStatusReason) {
        this.stackStatusReason = stackStatusReason;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "description='" + description + '\'' +
                ", links=" + links +
                ", stackStatusReason='" + stackStatusReason + '\'' +
                ", stackName='" + stackName + '\'' +
                ", updatedTime=" + updatedTime +
                ", creationTime=" + creationTime +
                ", stackStatus='" + stackStatus + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
