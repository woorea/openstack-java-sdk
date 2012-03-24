package org.openstack.model.identity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace="http://docs.openstack.org/identity/api/ext/OS-KSCATALOG/v1.0")
@XmlAccessorType(XmlAccessType.NONE)
public class KeystoneEndpointTemplates implements Serializable {
	
	@XmlAttribute
	private String id;
	
	@XmlAttribute
	private String region;
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private String type;
	
	@XmlAttribute(name="publicURL")
	private String publicUrl;
	
	@XmlAttribute(name="internalURL")
	private String internalUrl;
	
	@XmlAttribute(name="adminURL")
	private String adminURL;
	
	@XmlAttribute
	private boolean enabled;
	
	@XmlElement
	private boolean global;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPublicUrl() {
		return publicUrl;
	}

	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}

	public String getInternalUrl() {
		return internalUrl;
	}

	public void setInternalUrl(String internalUrl) {
		this.internalUrl = internalUrl;
	}

	public String getAdminURL() {
		return adminURL;
	}

	public void setAdminURL(String adminURL) {
		this.adminURL = adminURL;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isGlobal() {
		return global;
	}

	public void setGlobal(boolean global) {
		this.global = global;
	}

	@Override
	public String toString() {
		return "EndpointTemplate [id=" + id + ", region=" + region + ", name="
				+ name + ", type=" + type + ", publicUrl=" + publicUrl
				+ ", internalUrl=" + internalUrl + ", adminURL=" + adminURL
				+ ", enabled=" + enabled + ", global=" + global + "]";
	}
	
}

