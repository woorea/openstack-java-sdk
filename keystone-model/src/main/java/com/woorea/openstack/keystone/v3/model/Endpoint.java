package com.woorea.openstack.keystone.v3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("endpoint")
public class Endpoint {

	private String id;
	
	@JsonProperty("interface")
	private String iface;
	
	private String name;
	
	@JsonProperty("service_id")
	private String serviceId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInterface() {
		return iface;
	}

	public void setInterface(String iface) {
		this.iface = iface;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
}
