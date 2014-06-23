package com.woorea.openstack.cinder.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Model for Volume Attachment
 *
 * @author VAL Informatique
 */
public class Attachment {

    @JsonProperty("host_name")
    private String hostName;
    private String device;
    @JsonProperty("server_id")
    private String serverId;
    private String id;
    @JsonProperty("volume_id")
    private String volumeId;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    @Override
    public String toString() {
        return "Attachment {"
                + "host_name='" + hostName + '\''
                + ", device='" + device + '\''
                + ", server_id='" + serverId + '\''
                + ", id='" + id + '\''
                + ", volume_id='" + volumeId + '\''
                + '}';
    }
}
