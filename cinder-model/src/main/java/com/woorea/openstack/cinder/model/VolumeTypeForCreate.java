package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("volume_type")
public class VolumeTypeForCreate implements Serializable {

    private String name;

    @JsonProperty("extra_specs")
    private Map<String, Object> extraSpecs;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the extraSpecs
     */
    public Map<String, Object> getExtraSpecs() {
        return extraSpecs;
    }

    /**
     * @param extraSpecs
     *            the extra_specs to set
     */
    public void setExtraSpecs(Map<String, Object> extraSpecs) {
        this.extraSpecs = extraSpecs;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "VolumeForCreate [name=" + name + ", metadata=" + extraSpecs + "]";
    }

}
