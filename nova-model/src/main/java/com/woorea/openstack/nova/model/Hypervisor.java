package com.woorea.openstack.nova.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

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
