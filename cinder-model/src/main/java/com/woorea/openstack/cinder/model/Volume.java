package com.woorea.openstack.cinder.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@JsonRootName("volume")
public class Volume implements Serializable {

    private String id;

    private String status;

    private String name;

    private String description;

    @JsonProperty("availability_zone")
    private String availabilityZone;

    @JsonProperty("volume_type")
    private String volumeType;

    @JsonProperty("snapshot_id")
    private String snapshotId;

    @JsonProperty("source_volid")
    private String sourceVolid;

    @JsonProperty("bootable")
    private Boolean bootable;

    private List<Map<String, Object>> attachments;

    private Map<String, String> metadata;

    @JsonProperty("created_at")
    private String createdAt;

    private Integer size;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the availabilityZone
     */
    public String getAvailabilityZone() {
        return availabilityZone;
    }

    /**
     * @return the volumeType
     */
    public String getVolumeType() {
        return volumeType;
    }

    /**
     * @return the snapshotId
     */
    public String getSnapshotId() {
        return snapshotId;
    }

    /**
     * @return the ID of an existing volume (specify in order to create a volume from an existing volume)
     */
    public String getSourceVolid() {
        return sourceVolid;
    }

    /**
     * @param sourceVolid
     *            to set
     */
    public void setSourceVolid(String sourceVolid) {
        this.sourceVolid = sourceVolid;
    }

    /**
     * @param volumeType
     *            to set
     */
    public void setVolumeType(String volumeType) {
        this.volumeType = volumeType;
    }

    /**
     * @return the bootable flag to set
     */
    public Boolean getBootable() {
        return bootable;
    }

    /**
     * @return the attachments
     */
    public List<Map<String, Object>> getAttachments() {
        return attachments;
    }

    /**
     * @return the metadata
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Volume [id=" + id + ", status=" + status +
                ", name=" + name + ", description=" + description +
                ", availabilityZone=" + availabilityZone + ", volumeType=" + volumeType +
                ", snapshotId=" + snapshotId + ", attachments=" + attachments +
                ", metadata=" + metadata + ", createdAt=" + createdAt + ", size=" + size + "]";
    }

}
