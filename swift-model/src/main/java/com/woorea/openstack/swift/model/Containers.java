package com.woorea.openstack.swift.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.woorea.openstack.swift.deserializer.ContainersDeserializer;

@JsonDeserialize(using = ContainersDeserializer.class)
public class Containers implements Iterable<Container>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("containers")
	private List<Container> list;

	public Containers(Container[] containersArray) {
		list = Arrays.asList(containersArray);
	}

	/**
	 * @return the list
	 */
	public List<Container> getList() {
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Containers [list=" + list + "]";
	}

	@Override
	public Iterator<Container> iterator() {
		return list.iterator();
	}

}
