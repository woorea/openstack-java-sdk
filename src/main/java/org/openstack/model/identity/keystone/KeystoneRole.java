package org.openstack.model.identity.keystone;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.identity.Role;

@XmlRootElement(name="role")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("role")
public class KeystoneRole implements Serializable, Role {
	
	@XmlAttribute
	private String id;
	
	@XmlAttribute
	private String name;

	@XmlAttribute
	private String serviceId;

	@XmlAttribute
	private String tenantId;
	
	public KeystoneRole() {
		
	}
	
	public KeystoneRole(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Role#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Role#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
}

