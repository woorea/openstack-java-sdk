package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class FloatingIps implements Iterable<FloatingIp>, Serializable {

	@JsonProperty("floating_ips")
	private List<FloatingIp> list;

	/**
	 * @return the list
	 */
	public List<FloatingIp> getList() {
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FloatingIps [list=" + list + "]";
	}

	@Override
	public Iterator<FloatingIp> iterator() {
		return list.iterator();
	}
	
}
