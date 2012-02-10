package org.openstack.model.compute;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.ListWithAtomLinks;

@XmlRootElement(name="flavors")
@XmlAccessorType(XmlAccessType.NONE)
public class FlavorList extends ListWithAtomLinks {

	@XmlElement(name="flavor")
	private List<Flavor> list = new ArrayList<Flavor>();

	public List<Flavor> getList() {
		return list;
	}

	public void setList(List<Flavor> list) {
		this.list = list;
	}
	
}
