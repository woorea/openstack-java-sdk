package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Snapshots implements Iterable<Snapshot>, Serializable {

	@JsonProperty("snapshots")
	private List<Snapshot> list;

	/**
	 * @return the list
	 */
	public List<Snapshot> getList() {
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Snapshots [list=" + list + "]";
	}

	@Override
	public Iterator<Snapshot> iterator() {
		return list.iterator();
	}
	
}
