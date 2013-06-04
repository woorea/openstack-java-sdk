package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Flavors implements Iterable<Flavor>, Serializable {

	@JsonProperty("flavors")
	private List<Flavor> list;

	/**
	 * @return the list
	 */
	public List<Flavor> getList() {
		return list;
	}
	
	@Override
	public Iterator<Flavor> iterator() {
		return list.iterator();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Flavors [list=" + list + "]";
	}

}
