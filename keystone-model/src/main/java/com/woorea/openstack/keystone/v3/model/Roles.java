package com.woorea.openstack.keystone.v3.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Roles implements Iterable<Role>, Serializable {

	@JsonProperty("roles")
	private List<Role> list;

	/**
	 * @return the list
	 */
	public List<Role> getList() {
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Roles [list=" + list + "]";
	}

	@Override
	public Iterator<Role> iterator() {
		return list.iterator();
	}
	
}
