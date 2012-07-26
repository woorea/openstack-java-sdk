package org.openstack.keystone.model;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("role")
public class Role implements Serializable {

	private String id;
	
	private String name;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
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

	
	
}
