package org.openstack.model.compute.nova.securitygroup;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.SecurityGroupForCreate;

@XmlRootElement(name = "security_group")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("security_group")
public class NovaSecurityGroupForCreate implements Serializable, SecurityGroupForCreate {

	@XmlAttribute
    protected String name;

    @XmlAttribute
    protected String description;

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupForCreate#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupForCreate#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupForCreate#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.securitygroup.SecurityGroupForCreate#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "NovaSecurityGroupForCreate [name=" + name + ", description=" + description + "]";
	}

}
