package com.woorea.openstack.keystone.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("tenant")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Tenant implements Serializable {

	private String id;
	
	private String name;
	
	private String description;
	
	private Boolean enabled;
	
	public Tenant(String name, String description, Boolean enabled) {
		this.name = name;
		this.description = description;
		this.enabled = enabled;
	}
	
	public Tenant(String name, String description) {
		this(name, description, Boolean.TRUE);
	}
	
	public Tenant(String name) {
		this(name, null);
	}
	
	public Tenant() {
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tenant [id=" + id + ", name=" + name + ", description="
				+ description + ", enabled=" + enabled + "]";
	}
	
}
