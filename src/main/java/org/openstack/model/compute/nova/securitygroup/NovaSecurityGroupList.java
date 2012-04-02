package org.openstack.model.compute.nova.securitygroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupList;

import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "security_groups")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement()
public class NovaSecurityGroupList implements Serializable, SecurityGroupList {

	@XmlElementWrapper(name = "security_groups")
	@XmlElement(name = "security_group")
	@SerializedName("security_groups")
	private List<NovaSecurityGroup> list = new ArrayList<NovaSecurityGroup>();

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.SecurityGroupList#getList()
	 */
	@Override
	public List<SecurityGroup> getList() {
		if (list == null) {
			list = Lists.newArrayList();
		}
		return (List<SecurityGroup>) (List<?>) list;
	}

	@Override
	public String toString() {
		return "NovaSecurityGroupList [list=" + list + "]";
	}

}
