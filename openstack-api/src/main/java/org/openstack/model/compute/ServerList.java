package org.openstack.model.compute;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.ListWithAtomLinks;

@XmlRootElement(name="servers")
@XmlAccessorType(XmlAccessType.NONE)
public class ServerList extends ListWithAtomLinks {

	@XmlElement(name="server")
	private List<Server> list = new ArrayList<Server>();

	public List<Server> getList() {
		return list;
	}

	public void setList(List<Server> list) {
		this.list = list;
	}
	
}
