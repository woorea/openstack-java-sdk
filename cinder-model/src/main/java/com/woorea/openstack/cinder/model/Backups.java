package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Model for List of backups
 *
 * @author VAL Informatique
 */
public class Backups implements Iterable<Backup>, Serializable {

    @JsonProperty("backups")
    private List<Backup> list;

    public List<Backup> getList() {
        return list;
    }

    public void setList(List<Backup> list) {
        this.list = list;
    }

    @Override
    public Iterator<Backup> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return "Backups [list=" + list + "]";
    }
}
