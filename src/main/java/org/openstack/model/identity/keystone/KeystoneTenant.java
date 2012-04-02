package org.openstack.model.identity.keystone;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.identity.Tenant;

@XmlRootElement(name="tenant")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("tenant")
public class KeystoneTenant implements Serializable, Tenant {
	
	@XmlAttribute
	private String id;
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private boolean enabled;
	
	@XmlElement
	private String description;

	public KeystoneTenant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KeystoneTenant(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Tenant#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Tenant#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Tenant#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Tenant#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Tenant [id=" + id + ", name=" + name + ", enabled=" + enabled
				+ ", description=" + description + "]";
	}
	
}

