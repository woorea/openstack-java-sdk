package org.openstack.quantum.api.ports;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.common.command.AbsOpenStackCmd;
import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Port;
import org.openstack.quantum.model.Ports;

public class QueryPorts extends AbsOpenStackCmd<Port> implements QuantumCommand<Ports> {

	public QueryPorts(Port port) {
		super(port);
	}

	public Ports execute(WebTarget target)
	{
		target = target.path("v2.0").path("ports");
		target = queryParam(target);
		return target.request(MediaType.APPLICATION_JSON).get(Ports.class);
	}

}
