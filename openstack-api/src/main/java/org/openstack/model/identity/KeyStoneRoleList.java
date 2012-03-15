package org.openstack.model.identity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.ListWithAtomLinks;

@XmlRootElement(name="roles")
@XmlAccessorType(XmlAccessType.NONE)
public class KeyStoneRoleList extends ListWithAtomLinks {

	@XmlElement(name="role")
	private List<KeyStoneRole> list;

	public List<KeyStoneRole> getList() {
		return list;
	}

	public void setList(List<KeyStoneRole> list) {
		this.list = list;
	}
	
}
