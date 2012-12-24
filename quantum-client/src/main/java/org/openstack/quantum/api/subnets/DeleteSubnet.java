package org.openstack.quantum.api.subnets;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.quantum.client.QuantumCommand;

public class DeleteSubnet implements QuantumCommand<Void> {

private String id;
	
	public DeleteSubnet(String SubnetId){
		this.id = SubnetId;
	}

	public Void execute(WebTarget target) {
		target.path("v2.0").path("subnets").path(id).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}

}
