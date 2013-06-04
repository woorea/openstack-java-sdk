package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Volumes implements Iterable<Volume>, Serializable {

	@JsonProperty("volumes")
	private List<Volume> list;

	/**
	 * @return the list
	 */
	public List<Volume> getList() {
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Volumes [list=" + list + "]";
	}

	@Override
	public Iterator<Volume> iterator() {
		return list.iterator();
	}
	
}
