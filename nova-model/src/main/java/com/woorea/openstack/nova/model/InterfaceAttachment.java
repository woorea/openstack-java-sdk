package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("interfaceAttachment")
public class InterfaceAttachment implements Serializable {

	@JsonProperty("mac_addr")
	private String macAddress;

	@JsonProperty("net_id")
	private String networkId;

	@JsonProperty("port_id")
	private String portId;

	@JsonProperty("port_state")
	private String portState;

	@JsonProperty("fixed_ips")
	private List<FixedIp> fixedIps;

	/**
	 * @return the macAddress
	 */
	public String getMacAddress() {
		return macAddress;
	}

	/**
	 * @return the networkId
	 */
	public String getNetworkId() {
		return networkId;
	}

	/**
	 * @return the portId
	 */
	public String getPortId() {
		return portId;
	}

	/**
	 * @return the portState
	 */
	public String getPortState() {
		return portState;
	}

	/**
	 * @return the fixedIps
	 */
	public List<FixedIp> getFixedIps() {
		return fixedIps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InterfaceAttachment [macAddress=" + macAddress + ", networkId="
				+ networkId + ", portId=" + portId + ", portState=" + portState
				+ ", fixedIps=" + fixedIps + "]";
	}

}
