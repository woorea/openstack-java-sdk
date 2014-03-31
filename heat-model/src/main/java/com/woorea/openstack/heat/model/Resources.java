package com.woorea.openstack.heat.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Resources implements Iterable<Resource>, Serializable {
    @JsonProperty("resources")
    private List<Resource> list;

    public List<Resource> getList() {
        return list;
    }

    @Override
    public Iterator<Resource> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return "Resources{" +
                "list=" + list +
                '}';
    }
}