package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Model for List of snapshots
 *
 * @author VAL Informatique
 */
public class Snapshots implements Iterable<Snapshot>, Serializable {

    @JsonProperty("snapshots")
    private List<Snapshot> list;

    public List<Snapshot> getList() {
        return list;
    }

    public void setList(List<Snapshot> list) {
        this.list = list;
    }

    @Override
    public Iterator<Snapshot> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return "Snapshots [list=" + list + "]";
    }
}
