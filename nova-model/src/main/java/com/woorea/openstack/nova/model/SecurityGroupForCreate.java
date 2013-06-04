package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("security_group")
public class SecurityGroupForCreate implements Serializable {
	
	private String name;
	
	private String description;

	public SecurityGroupForCreate() {
		super();
	}
	
	public SecurityGroupForCreate(String name) {
		this.name = name;
	}

	public SecurityGroupForCreate(String name, String description) {
		this(name);
		this.description = description;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecurityGroupForCreate [name=" + name + ", description="
				+ description + "]";
	}
	
}
