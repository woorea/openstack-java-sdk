package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Model for List of volumes
 *
 * @author VAL Informatique
 */
public class Volumes implements Iterable<Volume>, Serializable {

    @JsonProperty("volumes")
    private List<Volume> list;

    public List<Volume> getList() {
        return list;
    }

    public void setList(List<Volume> list) {
        this.list = list;
    }

    @Override
    public Iterator<Volume> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return "Volumes [list=" + list + "]";
    }
}
