package com.woorea.openstack.keystone.v3.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Projects implements Iterable<Project>,  Serializable {

	@JsonProperty("projects")
	private List<Project> list;

	/**
	 * @return the list
	 */
	public List<Project> getList() {
		return list;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Projects [list=" + list + "]";
	}

	@Override
	public Iterator<Project> iterator() {
		return list.iterator();
	}
	
}
