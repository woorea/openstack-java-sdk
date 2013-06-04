package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("extension")
public class Extension implements Serializable {

	private String alias;
	
	private String description;
	
	private String name;
	
	private String namespace;
	
	private Calendar updated;
	
	private List<Link> links;

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * @return the updated
	 */
	public Calendar getUpdated() {
		return updated;
	}

	/**
	 * @return the links
	 */
	public List<Link> getLinks() {
		return links;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Extension [alias=" + alias + ", description=" + description
				+ ", name=" + name + ", namespace=" + namespace + "]";
	}
	
}
