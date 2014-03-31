package com.woorea.openstack.quantum.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
public class Ports implements Iterable<Port>, Serializable {

    @JsonProperty("ports")
    private List<Port> list;

    /**
     * @return the list
     */
    public List<Port> getList() {
        return list;
    }

    /**
     * @param list
     *            the list to set
     */
    public void setList(List<Port> list) {
        this.list = list;
    }

    @Override
    public Iterator<Port> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return "Ports [list=" + list + "]";
    }

}
