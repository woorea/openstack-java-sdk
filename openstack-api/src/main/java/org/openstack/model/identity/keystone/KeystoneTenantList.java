package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.atom.Link;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "tenants")
@XmlAccessorType(XmlAccessType.NONE)
public class KeystoneTenantList implements Serializable, TenantList {
	
	@XmlElement(name = "tenant", type = KeystoneTenant.class)
	@SerializedName("tenants")
	private List<KeystoneTenant> tenants;
	
	@SerializedName("tenants_links")
	private List<Link> links;

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.TenantList#getList()
	 */
	@Override
	public List<Tenant> getList() {
		return (List<Tenant>) (List<?>) tenants;
	}

	
	public void setList(List<KeystoneTenant> list) {
		this.tenants = list;
	}
	
	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.TenantList#getLinks()
	 */
	@Override
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "KeyStoneTenantList [tenants=" + tenants + ", links=" + links + "]";
	}

}
