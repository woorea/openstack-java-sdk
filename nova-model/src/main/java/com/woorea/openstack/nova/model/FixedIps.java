package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class FixedIps implements Iterable<FixedIp>, Serializable {

	@JsonProperty("fixed_ips")
	private List<FixedIp> list;

	/**
	 * @return the list
	 */
	public List<FixedIp> getList() {
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FixedIps [list=" + list + "]";
	}

	@Override
	public Iterator<FixedIp> iterator() {
		return list.iterator();
	}

}
