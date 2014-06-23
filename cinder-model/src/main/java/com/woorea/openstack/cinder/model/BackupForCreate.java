package com.woorea.openstack.cinder.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Model for Creation of backup
 *
 * @author VAL Informatique
 */
@JsonRootName("backup")
public class BackupForCreate {

    private String name;
    private String description;
    private String container;
    @JsonProperty("volume_id")
    private String volumeId;

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

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }
}
