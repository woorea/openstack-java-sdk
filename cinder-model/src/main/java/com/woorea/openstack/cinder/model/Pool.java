package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Model for Pool
 *
 * @author Ahmed Saba
 */
@JsonRootName("pool")
public class Pool implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("capabilities")
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
}
