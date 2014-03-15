package com.woorea.openstack.nova.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NetworkForCreate {

	@JsonProperty("uuid")
	private String id;
	@JsonProperty("fixed_ip")
	private String fixedIp;

	public String getId() {
		return id;
	}

	public String getFixedIp() {
		return fixedIp;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFixedIp(String fixedIp) {
		this.fixedIp = fixedIp;
	}

}
