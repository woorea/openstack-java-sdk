package com.woorea.openstack.quantum.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

public class Routers implements Iterable<Router>, Serializable{
	
	@JsonProperty("routers")
	private List<Router> list;

	/**
	 * @return the list
	 */
	public List<Router> getList() {
		return list;
	}


	/**
	 * @param list the list to set
	 */
	public void setList(List<Router> list) {
		this.list = list;
	}


	public String toString() {
		return "Routers [list=" + list + "]";
	}


	public Iterator<Router> iterator() {
		return list.iterator();
	}
	
}
