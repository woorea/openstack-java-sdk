package com.woorea.openstack.quantum.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Please use {@link Subnet} directly.
 */
@SuppressWarnings("serial")
@JsonRootName("subnet")
@Deprecated
public class SubnetForCreate extends Subnet {

    /**
     * @return the ipVersion
     * @deprecated
     */
    @Deprecated
    @JsonIgnore
    public int getIpVersion() {
        return getIpversion().code();
    }

    /**
     * @param ipVersion
     *            the ipVersion to set
     * @deprecated
     */
    @Deprecated
    @JsonIgnore
    public void setIpVersion(int ipVersion) {
        setIpversion(IpVersion.valueOf(ipVersion));
    }
}
