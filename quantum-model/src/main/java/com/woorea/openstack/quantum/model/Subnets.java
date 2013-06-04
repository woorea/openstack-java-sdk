package com.woorea.openstack.quantum.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Subnets implements Serializable, Iterable<Subnet> {
	
	@JsonProperty("subnets")
	private List<Subnet> list;
	
	/**
	 * @return the list
	 */
	public List<Subnet> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Subnet> list) {
		this.list = list;
	}

	public String toString() {
		return "Subnets [list=" + list + "]";
	}
	
	public Iterator<Subnet> iterator() {
		return list.iterator();
	}

}
