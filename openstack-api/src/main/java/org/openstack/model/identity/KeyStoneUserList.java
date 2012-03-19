package org.openstack.model.identity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.NONE)
public class KeyStoneUserList implements Serializable {

	@XmlElement(name = "user")
	private List<KeyStoneUser> users;

	public List<KeyStoneUser> getList() {
		return users;
	}

	public void setList(List<KeyStoneUser> list) {
		this.users = list;
	}

	@Override
	public String toString() {
		return "KeyStoneUserList [users=" + users + "]";
	}

}
