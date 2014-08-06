package com.woorea.openstack.cinder.model;

import java.util.Calendar;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Model for Backup
 *
 * @author VAL Informatique
 */
public class Backup {

    @JsonProperty("availability_zone")
    private String availabilityZone;
    private String container;
    @JsonProperty("created_at")
    private Calendar createdAt;
    private String description;
    @JsonProperty("fail_reason")
    private String failReason;
    private String id;
    private List<Link> links;
    private String name;
    @JsonProperty("object_count")
    private Integer objectCount;
    private Integer size;
    private String status;
    @JsonProperty("volume_id")
    private String volumeId;

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getObjectCount() {
        return objectCount;
    }

    public void setObjectCount(Integer objectCount) {
        this.objectCount = objectCount;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }
    
}
