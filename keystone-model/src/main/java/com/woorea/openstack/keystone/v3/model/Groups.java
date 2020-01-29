package com.woorea.openstack.keystone.v3.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Groups implements Iterable<Group>,  Serializable {

	@JsonProperty("groups")
	private List<Group> list;

	/**
	 * @return the list
	 */
	public List<Group> getList() {
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Groups [list=" + list + "]";
	}

	@Override
	public Iterator<Group> iterator() {
		return list.iterator();
	}
	
}
