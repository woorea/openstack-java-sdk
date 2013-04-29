package org.openstack.quantum.api.ports;

import org.openstack.quantum.api.query.AbsOpenStackCmd;
import org.openstack.quantum.model.Port;

public class QueryPorts extends AbsOpenStackCmd<Port> {

	public QueryPorts(Port port) {
		super(port);
//		target = target.path("v2.0").path("ports");
//		target = queryParam(target);
//		return target.request(MediaType.APPLICATION_JSON).get(Ports.class);
	}

}
