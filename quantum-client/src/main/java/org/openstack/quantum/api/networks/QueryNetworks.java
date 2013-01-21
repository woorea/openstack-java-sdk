package org.openstack.quantum.api.networks;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.AbsOpenStackCmd;
import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Network;
import org.openstack.quantum.model.Networks;

public class QueryNetworks extends AbsOpenStackCmd<Network> implements QuantumCommand<Networks> {

	public QueryNetworks(Network network) {
		super(network);
	}

	public Networks execute(WebTarget target)
	{
		target = target.path("v2.0").path("networks");
		target = queryParam(target);
		return target.request(MediaType.APPLICATION_JSON).get(Networks.class);
	}

}
