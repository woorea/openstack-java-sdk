package com.woorea.openstack.nova.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

public class NetworkForCreate {

	@JsonProperty("uuid")
	private String id;
	@JsonProperty("fixed_ip")
	private String fixedIp;
	@JsonProperty("port")
	private String port;	
	
	public String getId() {
		return id;
	}

	public String getFixedIp() {
		return fixedIp;
	}

	public String getPort() {
		return port;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setFixedIp(String fixedIp) {
		this.fixedIp = fixedIp;
	}

	public void setPort(String port) {
		this.port = port;
	}
}
