package org.openstack.model.compute.nova.floatingip;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.ServerAction;
import org.openstack.model.compute.nova.NovaServer;

@JsonRootName("addFloatingIp")
public class AssociateFloatingIpAction implements Serializable, ServerAction {

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public Class<? extends Serializable> getReturnType() {
		return NovaServer.class;
	}
	
}
