package com.woorea.openstack.cinder.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Model for Restoration of backup
 *
 * @author VAL Informatique
 */
@JsonRootName("restore")
public class BackupForRestore {

    @JsonProperty("volume_id")
    private String volumeId;

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }
}