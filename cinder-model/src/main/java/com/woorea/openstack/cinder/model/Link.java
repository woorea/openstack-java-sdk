package com.woorea.openstack.cinder.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Model for Link
 *
 * @author VAL Informatique
 */
public class Link {

    @JsonProperty("href")
    private String href;
    @JsonProperty("rel")
    private String rel;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    @Override
    public String toString() {
        return "Link{"
                + "href='" + href + '\''
                + ", rel='" + rel + '\''
                + '}';
    }
}
