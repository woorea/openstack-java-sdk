package org.openstack.ceilometer.v1.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "extensions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Extensions implements Iterable<Extension>, Serializable {

	@JsonProperty("extensions")
	private List<Extension> list;

	/**
	 * @return the list
	 */
	public List<Extension> getList() {
		return list;
	}
	
	@Override
	public Iterator<Extension> iterator() {
		return list.iterator();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Extensions [list=" + list + "]";
	}

}
