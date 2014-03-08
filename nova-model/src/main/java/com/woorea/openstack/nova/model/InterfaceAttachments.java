package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class InterfaceAttachments implements Iterable<InterfaceAttachment>,
		Serializable {

	@JsonProperty("interfaceAttachments")
	private List<InterfaceAttachment> list;

	/**
	 * @return the list
	 */
	public List<InterfaceAttachment> getList() {
		return list;
	}

	@Override
	public Iterator<InterfaceAttachment> iterator() {
		return list.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InterfaceAttachments [list=" + list + "]";
	}
}