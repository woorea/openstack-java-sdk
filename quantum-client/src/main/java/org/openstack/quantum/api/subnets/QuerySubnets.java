package org.openstack.quantum.api.subnets;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.api.query.AbsOpenStackCmd;
import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Subnet;
import org.openstack.quantum.model.Subnets;

public class QuerySubnets extends AbsOpenStackCmd<Subnet> implements QuantumCommand<Subnets> {

	public QuerySubnets(Subnet subnet) {
		super(subnet);
	}

	public OpenStackRequest execute(OpenStackClient client) {
//		target = target.path("v2.0").path("subnets");
//		target = queryParam(target);
//		return target.request(MediaType.APPLICATION_JSON).get(Subnets.class);
		return null;
	}

}
