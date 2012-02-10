package org.openstack.model.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.openstack.model.atom.Link;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class ListWithAtomLinks implements Serializable {

	@XmlElement(name="link", namespace="http://www.w3.org/2005/Atom")
	private List<Link> links = new ArrayList<Link>();
	
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
}
