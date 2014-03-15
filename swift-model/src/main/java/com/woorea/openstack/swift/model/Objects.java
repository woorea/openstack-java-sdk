package com.woorea.openstack.swift.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.woorea.openstack.swift.deserializer.ObjectsDeserializer;

@JsonDeserialize(using = ObjectsDeserializer.class)
public class Objects implements Iterable<com.woorea.openstack.swift.model.Object>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("objects")
	private List<com.woorea.openstack.swift.model.Object> list;

	public Objects(com.woorea.openstack.swift.model.Object[] objectsArray) {
		list = Arrays.asList(objectsArray);
	}

	/**
	 * @return the list
	 */
	public List<com.woorea.openstack.swift.model.Object> getList() {
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Objects [list=" + list + "]";
	}

	@Override
	public Iterator<com.woorea.openstack.swift.model.Object> iterator() {
		return list.iterator();
	}

}
