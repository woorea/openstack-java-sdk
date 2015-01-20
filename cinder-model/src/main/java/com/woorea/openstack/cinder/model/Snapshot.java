package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("snapshot")
public class Snapshot implements Serializable {

    private String id;

    private String status;

    private String name;

    private String description;

    @JsonProperty("volume_id")
    private String volumeId;

    private Integer size;

    @JsonProperty("created_at")
    private String createdAt;

    private Map<String, String> metadata;

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
     * @return the volumeId
     */
    public String getVolumeId() {
        return volumeId;
    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the metadata
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Snapshot [id=" + id + ", status=" + status +
                ", name=" + name + ", description=" + description +
                ", volumeId=" + volumeId + ", size=" + size +
                ", createdAt=" + createdAt + ", metadata=" + metadata + "]";
    }

}
