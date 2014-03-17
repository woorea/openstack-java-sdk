package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TenantNetworks implements Iterable<TenantNetwork>, Serializable {

	@JsonProperty("networks")
	private List<TenantNetwork> list;

	/**
	 * @return the list
	 */
	public List<TenantNetwork> getList() {
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenantNetworks [list=" + list + "]";
	}

	@Override
	public Iterator<TenantNetwork> iterator() {
		return list.iterator();
	}
	
}
