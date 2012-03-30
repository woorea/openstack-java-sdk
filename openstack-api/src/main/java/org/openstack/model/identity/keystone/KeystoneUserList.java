package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.identity.User;
import org.openstack.model.identity.UserList;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement()
public class KeystoneUserList implements Serializable, UserList {

	@XmlElement(name = "user", type = KeystoneUser.class)
	private List<KeystoneUser> users;

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.UserList#getList()
	 */
	@Override
	public List<User> getList() {
		return (List<User>) (List<?>) users;
	}

	public void setList(List<KeystoneUser> list) {
		this.users = list;
	}

	@Override
	public String toString() {
		return "KeyStoneUserList [users=" + users + "]";
	}

}
