package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.RoleList;

@XmlRootElement(name="roles")
@XmlAccessorType(XmlAccessType.NONE)
public class KeystoneRoleList implements Serializable, RoleList {

	@XmlElement(name="role", type = KeystoneRole.class)
	@JsonDeserialize(as=List.class, contentAs=KeystoneRole.class)
	private List<Role> roles = new ArrayList<Role>();

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.RoleList#getList()
	 */
	@Override
	public List<Role> getList() {
		return roles;
	}

	public void setList(List<Role> list) {
		this.roles = list;
	}

	@Override
	public String toString() {
		return "KeyStoneRoleList [roles=" + roles + "]";
	}
	
}
