package com.woorea.openstack.nova.model;

import java.util.Iterator;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model for List of Hypervisors
 *
 */
public class Hypervisors implements Iterable<Hypervisor> {

    @JsonProperty("hypervisors")
    private List<Hypervisor> list;

    public List<Hypervisor> getList() {
        return list;
    }

    public void setList(List<Hypervisor> list) {
        this.list = list;
    }

    @Override
    public Iterator<Hypervisor> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return "Hypervisors [list=" + list + "]";
    }
}
