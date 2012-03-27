package org.openstack.model.identity.keystone;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.identity.Endpoint;

@XmlRootElement(namespace="http://docs.openstack.org/identity/api/ext/OS-KSCATALOG/v1.0")
@XmlAccessorType(XmlAccessType.NONE)
public class KeystoneEndpoint implements Serializable, Endpoint {
	
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

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#getRegion()
	 */
	@Override
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#getType()
	 */
	@Override
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#getPublicUrl()
	 */
	@Override
	public String getPublicUrl() {
		return publicUrl;
	}

	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#getInternalUrl()
	 */
	@Override
	public String getInternalUrl() {
		return internalUrl;
	}

	public void setInternalUrl(String internalUrl) {
		this.internalUrl = internalUrl;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#getAdminURL()
	 */
	@Override
	public String getAdminURL() {
		return adminURL;
	}

	public void setAdminURL(String adminURL) {
		this.adminURL = adminURL;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Endpoint#isGlobal()
	 */
	@Override
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

