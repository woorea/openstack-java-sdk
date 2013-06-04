package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Extensions implements Iterable<Extension>, Serializable {

	@JsonProperty("extensions")
	private List<Extension> list;

	/**
	 * @return the list
	 */
	public List<Extension> getList() {
		return list;
	}
	
	@Override
	public Iterator<Extension> iterator() {
		return list.iterator();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Extensions [list=" + list + "]";
	}

}
