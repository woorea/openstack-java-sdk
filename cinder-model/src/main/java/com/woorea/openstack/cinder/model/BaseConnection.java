package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public abstract class BaseConnection implements Serializable {
    @JsonProperty("connector")
    private Map<String, Object> connector = new HashMap<String, Object>();

    /**
     * @return the connector
     */
    public Map<String, Object> getConnector() {
        return connector;
    }

    /**
     * @param connector
     *            the connector to set
     */
    public void setConnector(Map<String, Object> connector) {
        this.connector = connector;
    }

}
