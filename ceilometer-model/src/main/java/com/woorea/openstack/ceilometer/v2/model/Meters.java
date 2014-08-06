package com.woorea.openstack.ceilometer.v2.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * Model for List of Meters
 *
 * @author VAL Informatique
 */
public class Meters implements Serializable {

    private List<Meter> list;

    /**
     * @return the list
     */
    public List<Meter> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    @JsonDeserialize(contentAs = Meter.class)
    public void setList(List<Meter> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Meters [list=" + list + "]";
    }
}
