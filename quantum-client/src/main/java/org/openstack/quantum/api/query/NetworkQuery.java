package org.openstack.quantum.api.query;

import org.openstack.quantum.api.networks.QueryNetworks;
import org.openstack.quantum.api.ports.QueryPorts;
import org.openstack.quantum.api.subnets.QuerySubnets;
import org.openstack.quantum.model.Network;
import org.openstack.quantum.model.Port;
import org.openstack.quantum.model.Subnet;

public class NetworkQuery {

	public static QueryNetworks queryNetworks(Network network) {
		return new QueryNetworks(network);
	}

	public static QueryPorts queryPorts(Port port) {
		return new QueryPorts(port);
	}

	public static QuerySubnets querySubnets(Subnet subnet) {
		return new QuerySubnets(subnet);
	}
}
