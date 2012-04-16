package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.openstack.model.atom.Link;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;

@XmlRootElement(name = "tenants")
@XmlAccessorType(XmlAccessType.NONE)
public class KeystoneTenantList implements Serializable, TenantList {
	
	@XmlElement(name = "tenant", type = KeystoneTenant.class)
	@JsonProperty("tenants")
	@JsonDeserialize(as=List.class, contentAs=KeystoneTenant.class)
	private List<Tenant> tenants;
	
	@JsonProperty("tenants_links")
	private List<Link> links;
	
	public KeystoneTenantList() {
		tenants = new ArrayList<Tenant>();
	}

	public KeystoneTenantList(Collection<KeystoneTenant> collection) {
		this.tenants = new ArrayList<Tenant>(collection);
	}


	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.TenantList#getList()
	 */
	@Override
	public List<Tenant> getList() {
		return tenants;
	}

	
	public void setList(List<Tenant> list) {
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
