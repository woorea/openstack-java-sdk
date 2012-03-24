package org.openstack.model.identity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.NONE)
public class KeystoneUserList implements Serializable {

	@XmlElement(name = "user")
	private List<KeystoneUser> users;

	public List<KeystoneUser> getList() {
		return users;
	}

	public void setList(List<KeystoneUser> list) {
		this.users = list;
	}

	@Override
	public String toString() {
		return "KeyStoneUserList [users=" + users + "]";
	}

}
