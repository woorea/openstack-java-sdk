package com.woorea.openstack.cinder.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("os-initialize_connection")
public class ConnectionForInitialize implements Serializable {

    @JsonProperty("connector")
    private Map<String, Object> connector = new HashMap<>();

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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ConnectionForInitialize [connector=" + connector + "]";
    }

}
