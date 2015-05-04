package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Model for List of pools
 */
public class Pools implements Iterable<Pool>, Serializable {

    @JsonProperty("pools")
    private List<Pool> list;

    public List<Pool> getList() {
        return list;
    }

    public void setList(List<Pool> list) {
        this.list = list;
    }

    @Override
    public Iterator<Pool> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return "Pools [list=" + list + "]";
    }
}
