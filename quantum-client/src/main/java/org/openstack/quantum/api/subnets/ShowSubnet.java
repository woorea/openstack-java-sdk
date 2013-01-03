package org.openstack.quantum.api.subnets;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Subnet;

public class ShowSubnet implements QuantumCommand<Subnet> {

private String id;
	
	public ShowSubnet(String id) {
		this.id = id;
	}
	
	public Subnet execute(WebTarget target) {
		return target.path("v2.0").path("subnets").path(id).request(MediaType.APPLICATION_JSON).get(Subnet.class);
	}	
}
