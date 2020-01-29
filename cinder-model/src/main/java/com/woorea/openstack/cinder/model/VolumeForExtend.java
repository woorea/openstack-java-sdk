package com.woorea.openstack.cinder.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("os-extend")
public class VolumeForExtend implements Serializable {

    @JsonProperty("new_size")
    private Integer size;

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size
     *            the size to set
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "VolumeForExtend [size=" + size + "]";
    }

}
