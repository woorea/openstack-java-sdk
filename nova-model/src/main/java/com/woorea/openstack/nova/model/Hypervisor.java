package com.woorea.openstack.nova.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Model for Hypervisor
 *
 */
@JsonRootName("hypervisor")
public class Hypervisor implements Serializable {

    private String id;
    private String hypervisor_hostname;

    public String getId() {
        return id;
    }

    public void setHypervisor_hostname(String hypervisor_hostname) {
        this.hypervisor_hostname = hypervisor_hostname;
    }

    public String getHypervisor_hostname() {
        return hypervisor_hostname;
    }

    @Override
    public String toString() {
        return "Hypervisor {"
        + "hypervisor_hostname='" + hypervisor_hostname
        + ", id='" + id
        + '}';
    }

}
