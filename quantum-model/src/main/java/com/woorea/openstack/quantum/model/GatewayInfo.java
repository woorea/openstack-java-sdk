package com.woorea.openstack.quantum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GatewayInfo implements Serializable {

	@JsonProperty("network_id")
	private String networkId;

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String id) {
		this.networkId = id;
	}

	@Override public String toString() {
		return "[networkId=" + networkId + "]";
	}
}
