package com.woorea.openstack.keystone.v3.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("domain")
public class Domain {

	private String id;
	
	private String name;
	
	private String description;
	
	private Boolean enabled;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
