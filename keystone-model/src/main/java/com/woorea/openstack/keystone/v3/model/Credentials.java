package com.woorea.openstack.keystone.v3.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials implements Iterable<Credential>,  Serializable {

	@JsonProperty("credentials")
	private List<Credential> list;

	/**
	 * @return the list
	 */
	public List<Credential> getList() {
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Credentials [list=" + list + "]";
	}

	@Override
	public Iterator<Credential> iterator() {
		return list.iterator();
	}
	
}
