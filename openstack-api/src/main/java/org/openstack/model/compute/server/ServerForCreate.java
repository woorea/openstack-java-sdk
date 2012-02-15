package org.openstack.model.compute.server;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.Metadata;
import org.openstack.model.compute.SecurityGroupList;

@XmlRootElement(name="server", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class ServerForCreate implements Serializable {

	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private String imageRef;
	
	@XmlAttribute
	private String flavorRef;
	
	@XmlAttribute(name="accessIPv4")
	private String accessIpV4;
	
	@XmlAttribute(name="accessIPv6")
	private String accessIpV6;
	
	@XmlAttribute
	private String zone;
	
	@XmlAttribute
	private String keyName;
	
	@XmlElement
	private Metadata metadata = new Metadata();
	
	@XmlElement
	private Personality personality = new Personality();
	
	@XmlElement
	private SecurityGroupList securityGroups = new SecurityGroupList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageRef() {
		return imageRef;
	}

	public void setImageRef(String imageRef) {
		this.imageRef = imageRef;
	}

	public String getFlavorRef() {
		return flavorRef;
	}

	public void setFlavorRef(String flavorRef) {
		this.flavorRef = flavorRef;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getAccessIpV4() {
		return accessIpV4;
	}

	public void setAccessIpV4(String accessIpV4) {
		this.accessIpV4 = accessIpV4;
	}

	public String getAccessIpV6() {
		return accessIpV6;
	}

	public void setAccessIpV6(String accessIpV6) {
		this.accessIpV6 = accessIpV6;
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

	public SecurityGroupList getSecurityGroups() {
		return securityGroups;
	}

	public void setSecurityGroups(SecurityGroupList securityGroups) {
		this.securityGroups = securityGroups;
	}
	
}
