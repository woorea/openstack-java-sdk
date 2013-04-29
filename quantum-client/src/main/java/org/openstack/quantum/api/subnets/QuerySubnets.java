package org.openstack.quantum.api.subnets;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.QuantumCommand;
import org.openstack.quantum.api.query.AbsOpenStackCmd;
import org.openstack.quantum.model.Subnet;
import org.openstack.quantum.model.Subnets;

public class QuerySubnets extends AbsOpenStackCmd<Subnet> implements OpenStackCommand<Subnets> {

	public QuerySubnets(Subnet subnet) {
		super(subnet);
	}

	public OpenStackRequest createRequest(OpenStackClient client) {
//		target = target.path("v2.0").path("subnets");
//		target = queryParam(target);
//		return target.request(MediaType.APPLICATION_JSON).get(Subnets.class);
		return null;
	}

}
