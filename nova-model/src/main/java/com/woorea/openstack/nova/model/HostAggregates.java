package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class HostAggregates implements Iterable<HostAggregate>, Serializable {

	@JsonProperty("aggregates")
	private List<HostAggregate> list;

	/**
	 * @return the list
	 */
	public List<HostAggregate> getList() {
		return list;
	}
	
	@Override
	public Iterator<HostAggregate> iterator() {
		return list.iterator();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HostAggregates [list=" + list + "]";
	}

}
