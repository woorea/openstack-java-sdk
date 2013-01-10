package org.openstack.quantum.api.subnets;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.AbsOpenStackCmd;
import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Subnet;
import org.openstack.quantum.model.Subnets;

public class QuerySubnets extends AbsOpenStackCmd<Subnet> implements QuantumCommand<Subnets> {

	public QuerySubnets(Subnet subnet) {
		super(subnet);
	}

	public Subnets execute(WebTarget target)
	{
		target = target.path("v2.0").path("subnets");
		target = queryParam(target);
		return target.request(MediaType.APPLICATION_JSON).get(Subnets.class);
	}

}
