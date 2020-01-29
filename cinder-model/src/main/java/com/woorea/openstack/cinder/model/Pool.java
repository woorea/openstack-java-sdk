package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Model for Pool
 */
@JsonRootName("pool")
public class Pool implements Serializable {

    private String name;

    private Capabilities capabilities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Capabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    @Override
    public String toString() {
        return "Pool{"
                + "name='" + name
                + ", capabilities='" + capabilities
                + '}';
    }
}
