package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("volume_type")
public class VolumeType implements Serializable {

    private String id;

    private String name;

    @JsonProperty("extra_specs")
    private Map<String, String> extraSpecs;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the extra_specs
     */
    public Map<String, String> getExtraSpecs() {
        return extraSpecs;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "VolumeType [id=" + id + ", name=" + name + ", extra_specs=" + extraSpecs + "]";
    }

}
