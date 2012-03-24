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
public class KeystoneRoleList implements Serializable {

	@XmlElement(name="role")
	private List<KeystoneRole> roles = new ArrayList<KeystoneRole>();

	public List<KeystoneRole> getList() {
		return roles;
	}

	public void setList(List<KeystoneRole> list) {
		this.roles = list;
	}

	@Override
	public String toString() {
		return "KeyStoneRoleList [roles=" + roles + "]";
	}
	
}
