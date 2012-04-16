package org.openstack.model.compute.nova.securitygroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupList;

@XmlRootElement(name = "security_groups")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaSecurityGroupList implements Serializable, SecurityGroupList {

	@XmlElementWrapper(name = "security_groups")
	@XmlElement(name = "security_group")
	@JsonProperty("security_groups")
	@JsonDeserialize(as=List.class, contentAs=NovaSecurityGroup.class)
	private List<SecurityGroup> list = new ArrayList<SecurityGroup>();

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.SecurityGroupList#getList()
	 */
	@Override
	public List<SecurityGroup> getList() {
		return list;
	}

	@Override
	public String toString() {
		return "NovaSecurityGroupList [list=" + list + "]";
	}

}
