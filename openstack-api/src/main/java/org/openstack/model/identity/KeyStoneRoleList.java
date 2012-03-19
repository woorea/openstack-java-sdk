package org.openstack.model.identity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="roles")
@XmlAccessorType(XmlAccessType.NONE)
public class KeyStoneRoleList implements Serializable {

	@XmlElement(name="role")
	private List<KeyStoneRole> roles = new ArrayList<KeyStoneRole>();

	public List<KeyStoneRole> getList() {
		return roles;
	}

	public void setList(List<KeyStoneRole> list) {
		this.roles = list;
	}

	@Override
	public String toString() {
		return "KeyStoneRoleList [roles=" + roles + "]";
	}
	
}
