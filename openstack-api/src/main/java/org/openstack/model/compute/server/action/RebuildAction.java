package org.openstack.model.compute.server.action;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.Metadata;
import org.openstack.model.compute.server.Personality;

@XmlRootElement(name="rebuild")
@XmlAccessorType(XmlAccessType.NONE)
public class RebuildAction implements Serializable {

	@XmlAttribute
	private String name;
	
	@XmlAttribute(name="auto_disk_config")
	private String autoDiskConfig;
	
	@XmlElement
	private Metadata metadata;
	
	@XmlElement
	private Personality personality;
	
	@XmlElement
	private String imageRef;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAutoDiskConfig() {
		return autoDiskConfig;
	}

	public void setAutoDiskConfig(String autoDiskConfig) {
		this.autoDiskConfig = autoDiskConfig;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public Personality getPersonality() {
		return personality;
	}

	public void setPersonality(Personality personality) {
		this.personality = personality;
	}

	public String getImageRef() {
		return imageRef;
	}

	public void setImageRef(String imageRef) {
		this.imageRef = imageRef;
	}

}
