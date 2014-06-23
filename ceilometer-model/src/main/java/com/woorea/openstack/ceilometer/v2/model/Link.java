package com.woorea.openstack.ceilometer.v2.model;

import java.io.Serializable;

/**
 * Model for Link
 *
 * @author VAL Informatique
 */
public class Link implements Serializable {

    private String rel;
    private String href;

    /**
     * @return the rel
     */
    public String getRel() {
        return rel;
    }

    /**
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Link [rel=" + rel + ", href=" + href + "]";
    }
}
