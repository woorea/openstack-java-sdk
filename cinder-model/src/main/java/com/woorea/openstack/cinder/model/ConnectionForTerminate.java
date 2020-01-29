package com.woorea.openstack.cinder.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

@JsonRootName("os-terminate_connection")
public class ConnectionForTerminate extends BaseConnection implements Serializable {

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ConnectionForInitialize [connector=" + getConnector() + "]";
    }

}
