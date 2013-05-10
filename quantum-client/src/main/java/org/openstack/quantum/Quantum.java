package org.openstack.quantum;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.quantum.api.NetworksResource;
import org.openstack.quantum.api.PortsResource;
import org.openstack.quantum.api.SubnetsResource;

public class Quantum extends OpenStackClient {
	
	private final NetworksResource NETWORKS;
	
	private final PortsResource PORTS;
	
	private final SubnetsResource SUBNETS;
	
	public Quantum(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		NETWORKS = new NetworksResource(this);
		PORTS = new PortsResource(this);
		SUBNETS = new SubnetsResource(this);
	}
	
	public Quantum(String endpoint) {
		this(endpoint, null);
	}
	
	public NetworksResource networks() {
		return NETWORKS;
	}
	
	public PortsResource ports() {
		return PORTS;
	}
	
	public SubnetsResource subnets() {
		return SUBNETS;
	}

}
