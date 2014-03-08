package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("fixed_ip")
public class FixedIp implements Serializable {

	@JsonProperty("subnet_id")
	private String subnetId;

	@JsonProperty("ip_address")
	private String ipAddress;

	/**
	 * @return the subnetId
	 */
	public String getSubnetId() {
		return subnetId;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FixedIp [subnetId=" + subnetId + ", ipAddress=" + ipAddress
				+ "]";
	}

}
