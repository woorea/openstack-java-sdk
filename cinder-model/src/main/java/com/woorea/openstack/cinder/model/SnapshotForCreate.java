package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Model for Creation of a Snapshot
 *
 * @author VAL Informatique
 */
@JsonRootName("snapshot")
public class SnapshotForCreate implements Serializable {

    private String name;
    private String description;
    @JsonProperty("volume_id")
    private String volumeId;
    private boolean force;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }
}
