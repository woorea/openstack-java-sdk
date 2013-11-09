package com.woorea.openstack.quantum.model;

import java.io.Serializable;

public class HostRoute implements Serializable {

	private String destination;
	private String nexthop;

	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getNexthop() {
		return nexthop;
	}
	public void setNexthop(String nexthop) {
		this.nexthop = nexthop;
	}

	@Override public String toString() {
		return "[destination=" + destination + ", nexthop=" + nexthop + "]";
	}
}
