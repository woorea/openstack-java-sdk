package org.openstack.model.compute.nova.floatingip;

import java.io.Serializable;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.ServerAction;

@JsonRootElement("addFloatingIp")
public class AssociateFloatingIpAction implements Serializable, ServerAction {

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
