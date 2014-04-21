package com.woorea.openstack.nova.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NetworkForCreate {

	@JsonProperty("uuid")
	private String id;
	
	private String port;
	
	@JsonProperty("fixed_ip")
	private String fixedIp;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getFixedIp() {
		return fixedIp;
	}

	public void setFixedIp(String fixedIp) {
		this.fixedIp = fixedIp;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

}
