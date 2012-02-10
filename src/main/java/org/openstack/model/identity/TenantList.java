package org.openstack.model.identity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.ListWithAtomLinks;

@XmlRootElement(name="tenants")
@XmlAccessorType(XmlAccessType.NONE)
public class TenantList extends ListWithAtomLinks {

	@XmlElement(name="tenant")
	private List<Tenant> list;

	public List<Tenant> getList() {
		return list;
	}

	public void setList(List<Tenant> list) {
		this.list = list;
	}
	
}
