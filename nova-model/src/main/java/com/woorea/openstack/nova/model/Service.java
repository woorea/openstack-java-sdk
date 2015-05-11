package com.woorea.openstack.nova.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Model for Service
 *
 */
@JsonRootName("service")
public class Service implements Serializable {

    private String status;
    private String binary;
    private String zone;
    private String state;
    private String host;
    
    @JsonProperty("updated_at")
    private String updatedAt;
    
    @JsonProperty("disabled_reason")
    private String disabledReason;
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBinary() {
        return binary;
    }

    public void setBinary(String binary) {
        this.binary = binary;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getState() {
    	return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public String getHost() {
    	return host;
    }
    
    public void setHost(String host) {
        this.host = host;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDisabledReason() {
        return disabledReason;
    }

    public void setDisabledReason(String disabledReason) {
        this.disabledReason = disabledReason;
    }
    
    @Override
    public String toString() {
        return "Service {"
        + "host='" + host
        + ", state='" + state
        + ", status='" + status
        + ", zone='" + zone
        + ", binary='" + binary
        + ", updated_at='" + updatedAt
        + ", disabled_reason='" + disabledReason
        + '}';
    }

}
