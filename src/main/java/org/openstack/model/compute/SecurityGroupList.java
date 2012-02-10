package org.openstack.model.compute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="security_groups")
@XmlAccessorType(XmlAccessType.NONE)
public class SecurityGroupList implements Serializable {

	@XmlElement(name="security_group")
	private List<SecurityGroup> list = new ArrayList<SecurityGroup>();

	public List<SecurityGroup> getList() {
		return list;
	}

	public void setList(List<SecurityGroup> list) {
		this.list = list;
	}
	
}
