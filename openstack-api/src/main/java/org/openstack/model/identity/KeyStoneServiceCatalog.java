package org.openstack.model.identity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.openstack.api.common.Namespaces;

@XmlType(namespace= Namespaces.NS_OPENSTACK_IDENTITY_2_0)
@XmlAccessorType(XmlAccessType.NONE)
public class KeyStoneServiceCatalog implements Serializable {

	@XmlElement(name = "service")
	private List<KeyStoneService> services = new ArrayList<KeyStoneService>();

	public List<KeyStoneService> getServices() {
		return services;
	}

	public void setServices(List<KeyStoneService> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "KeyStoneServiceCatalog [services=" + services + "]";
	}
	
}
