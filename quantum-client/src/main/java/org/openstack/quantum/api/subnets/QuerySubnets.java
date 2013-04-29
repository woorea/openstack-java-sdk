package org.openstack.quantum.api.subnets;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.api.query.AbsOpenStackCmd;
import org.openstack.quantum.model.Subnet;

public class QuerySubnets extends AbsOpenStackCmd<Subnet> {

	public QuerySubnets(Subnet subnet) {
		super(subnet);
//		target = target.path("v2.0").path("subnets");
//		target = queryParam(target);
//		return target.request(MediaType.APPLICATION_JSON).get(Subnets.class);
	}

}
