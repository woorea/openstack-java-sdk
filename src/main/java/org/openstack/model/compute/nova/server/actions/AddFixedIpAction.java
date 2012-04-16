package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.ServerAction;
import org.openstack.model.compute.nova.NovaServer;

@XmlRootElement(name="addFixedIp")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("addFixedIp")
public class AddFixedIpAction implements Serializable, ServerAction {

	@XmlAttribute
	private String networkId;

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	@Override
	public Class<? extends Serializable> getReturnType() {
		return NovaServer.class;
	}
	
	
	
}
