package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class VolumeTypes implements Iterable<VolumeType>, Serializable {

	@JsonProperty("volume-types")
	private List<VolumeType> list;

	/**
	 * @return the list
	 */
	public List<VolumeType> getList() {
		return list;
	}

	@Override
	public Iterator<VolumeType> iterator() {
		return list.iterator();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VolumeTypes [list=" + list + "]";
	}
	
}
