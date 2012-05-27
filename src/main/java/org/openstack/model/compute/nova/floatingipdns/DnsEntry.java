package org.openstack.model.compute.nova.floatingipdns;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("dns_entry")
public class DnsEntry {
	
	private String id;
	
	private String name;

	private String ip;
	
	private String domain;
	
	private String type;
	
	@JsonProperty("dns_type")
	private String dnsType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDnsType() {
		return dnsType;
	}

	public void setDnsType(String dnsType) {
		this.dnsType = dnsType;
	}
	
}
