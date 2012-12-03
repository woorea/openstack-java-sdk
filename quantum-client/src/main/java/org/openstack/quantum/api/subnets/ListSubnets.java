package org.openstack.quantum.api.subnets;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Subnets;

public class ListSubnets implements QuantumCommand<Subnets> {

	public ListSubnets() {
	}
	
	public Subnets execute(WebTarget target) {
		return target.path("v2.0").path("subnets").request(MediaType.APPLICATION_JSON).get(Subnets.class);
	}

}
