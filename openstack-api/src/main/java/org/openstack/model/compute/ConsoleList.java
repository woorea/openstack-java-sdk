package org.openstack.model.compute;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.ListWithAtomLinks;

@XmlRootElement(name="consoles", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public class ConsoleList extends ListWithAtomLinks {

	@XmlElement(name="console", namespace="")
	private List<Console> list = new ArrayList<Console>();

	public List<Console> getList() {
		return list;
	}

	public void setList(List<Console> list) {
		this.list = list;
	}
	
}
