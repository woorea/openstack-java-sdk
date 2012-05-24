package org.openstack.model.compute.nova.floatingipdns;

import java.io.Serializable;

public class FloatingIpDns implements Serializable {

	private String ip;
	
	private String type;
	
	private String name;
	
	private String domain;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
}
