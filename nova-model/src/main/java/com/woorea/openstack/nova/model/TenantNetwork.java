package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("network")
public class TenantNetwork implements Serializable {

	private String id;

	private String cidr;
	
	private String label;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the cidr
	 */
	public String getCidr() {
		return cidr;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenantNetwork [id=" + id + ", cidr=" + cidr
			+ ", label=" + label + "]";
	}
	
}
