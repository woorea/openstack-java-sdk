package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("volume")
public class VolumeForCreate implements Serializable {

    private Integer size;

    @JsonProperty("availability_zone")
    private String availabilityZone;

    @JsonProperty("display_name")
    private String name;

    @JsonProperty("display_description")
    private String description;

    @JsonProperty("snapshot_id")
    private String snapshotId;

    @JsonProperty("source_volid")
    private String sourceVolid;

    @JsonProperty("imageRef")
    private String imageRef;

    @JsonProperty("volume_type")
    private String volumeType;

    @JsonProperty("bootable")
    private Boolean bootable;

    private Map<String, String> metadata;

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size
     *            the size to set
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return the availabilityZone
     */
    public String getAvailabilityZone() {
        return availabilityZone;
    }

    /**
     * @param availabilityZone
     *            the availabilityZone to set
     */
    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the snapshotId
     */
    public String getSnapshotId() {
        return snapshotId;
    }

    /**
     * @param snapshotId
     *            the snapshotId to set
     */
    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
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
     * @return the ID of the image from which you want to create the volume (required to create a bootable volume)
     */
    public String getImageRef() {
        return imageRef;
    }

    /**
     * @param imageRef
     *            to set
     */
    public void setImageRef(String imageRef) {
        this.imageRef = imageRef;
    }

    /**
     * @return the associated volume type
     */
    public String getVolumeType() {
        return volumeType;
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
     * Enables or disables the bootable attribute. You can boot an instance from a bootable volume.
     *
     * @param bootable
     *            flag
     */
    public void setBootable(Boolean bootable) {
        this.bootable = bootable;
    }

    /**
     * @return the metadata
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * @param metadata
     *            the metadata to set
     */
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "VolumeForCreate [size=" + size +
                ", availabilityZone=" + availabilityZone +
                ", name=" + name +
                ", description=" + description +
                ", snapshotId=" + snapshotId +
                ", source_volid=" + sourceVolid +
                ", imageRef=" + imageRef +
                ", volume_type=" + volumeType +
                ", bootable=" + bootable +
                ", metadata=" + metadata + "]";
    }

}
