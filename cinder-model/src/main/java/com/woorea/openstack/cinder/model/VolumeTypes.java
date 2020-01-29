package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VolumeTypes implements Iterable<VolumeType>, Serializable {

    @JsonProperty("volume_types")
    private List<VolumeType> list;

    /**
     * @return the list
     */
    public List<VolumeType> getList() {
        return list;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Volume Types [list=" + list + "]";
    }

    @Override
    public Iterator<VolumeType> iterator() {
        return list.iterator();
    }

}
