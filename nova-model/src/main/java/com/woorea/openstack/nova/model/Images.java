package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Images implements Iterable<Image>, Serializable {

	@JsonProperty("images")
	private List<Image> list;

	/**
	 * @return the list
	 */
	public List<Image> getList() {
		return list;
	}
	
	@Override
	public Iterator<Image> iterator() {
		return list.iterator();
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Images [list=" + list + "]";
	}

}
