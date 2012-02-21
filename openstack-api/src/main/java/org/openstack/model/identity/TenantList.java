package org.openstack.model.identity;

import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.PagingListBase;

@XmlRootElement(name = "tenants")
@XmlAccessorType(XmlAccessType.NONE)
public class TenantList extends PagingListBase<Tenant> {

	@XmlElement(name = "tenant")
	private List<Tenant> list;

	public List<Tenant> getList() {
		return list;
	}

	public void setList(List<Tenant> list) {
		this.list = list;
	}

	@Override
	public Iterator<Tenant> iterateItemsOnPage() {
		return list.iterator();
	}

	@Override
	public String toString() {
		return "TenantList [list=" + list + "]";
	}

}
