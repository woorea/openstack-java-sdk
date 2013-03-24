package org.openstack.quantum.api.ports;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.api.query.AbsOpenStackCmd;
import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Port;
import org.openstack.quantum.model.Ports;

public class QueryPorts extends AbsOpenStackCmd<Port> implements QuantumCommand<Ports> {

	public QueryPorts(Port port) {
		super(port);
	}

	public Ports execute(OpenStackClientConnector connector, OpenStackRequest request)
	{
//		target = target.path("v2.0").path("ports");
//		target = queryParam(target);
//		return target.request(MediaType.APPLICATION_JSON).get(Ports.class);
		return null;
	}

}
