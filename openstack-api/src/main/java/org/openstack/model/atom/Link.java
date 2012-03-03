package org.openstack.model.atom;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="link")
@XmlAccessorType(XmlAccessType.NONE)
public class Link implements Serializable {

	@XmlAttribute
	private String rel;
	
	@XmlAttribute
	private String href;
	
	@XmlAttribute
	private String type;

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Link [rel=" + rel + ", href=" + href + ", type=" + type + "]";
	}
	
}
