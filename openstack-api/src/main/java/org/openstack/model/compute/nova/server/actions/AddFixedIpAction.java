package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.compute.ServerAction;

@XmlRootElement(name="addFixedIp")
@XmlAccessorType(XmlAccessType.NONE)
public class AddFixedIpAction implements Serializable, ServerAction {

	@XmlAttribute
	private String networkId;

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}
	
}
