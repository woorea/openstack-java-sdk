package org.openstack.model.compute;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="zone", namespace="http://docs.rackspacecloud.com/servers/api/v1.0")
@XmlAccessorType(XmlAccessType.NONE)
public class Zone implements Serializable {
	
	@XmlAttribute
	private String id;
	
	@XmlAttribute
	private String name;
	
	@XmlElement
	private Metadata metadata = new Metadata();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	
}
