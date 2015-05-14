package com.woorea.openstack.nova.model;

import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Model for List of Services
 *
 */
public class Services implements Iterable<Service> {

    @JsonProperty("services")
    private List<Service> list;

    public List<Service> getList() {
        return list;
    }

    public void setList(List<Service> list) {
        this.list = list;
    }

    @Override
    public Iterator<Service> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return "Services [list=" + list + "]";
    }
}
