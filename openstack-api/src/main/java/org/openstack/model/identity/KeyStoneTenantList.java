package org.openstack.model.identity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.atom.Link;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "tenants")
@XmlAccessorType(XmlAccessType.NONE)
public class KeystoneTenantList implements Serializable {
	
	@SerializedName("tenants")
	@XmlElement(name = "tenant")
	private List<KeystoneTenant> tenants;
	
	@SerializedName("tenants_links")
	private List<Link> links;

	public List<KeystoneTenant> getList() {
		return tenants;
	}

	public void setList(List<KeystoneTenant> list) {
		this.tenants = list;
	}
	
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
