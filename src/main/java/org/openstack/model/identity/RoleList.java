package org.openstack.model.identity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.ListWithAtomLinks;

@XmlRootElement(name="roles")
@XmlAccessorType(XmlAccessType.NONE)
public class RoleList extends ListWithAtomLinks {

	@XmlElement(name="role")
	private List<Role> list;

	public List<Role> getList() {
		return list;
	}

	public void setList(List<Role> list) {
		this.list = list;
	}
	
}
