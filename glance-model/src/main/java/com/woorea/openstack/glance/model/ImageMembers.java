package com.woorea.openstack.glance.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ImageMembers implements Iterable<ImageMember>, Serializable {

	@JsonProperty("members")
	private List<ImageMember> list;

	/**
	 * @return the list
	 */
	public List<ImageMember> getList() {
		return list;
	}

	@Override
	public Iterator<ImageMember> iterator() {
		return list.iterator();
	}
	
}