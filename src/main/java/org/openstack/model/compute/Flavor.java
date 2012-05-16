package org.openstack.model.compute;

import java.util.List;

import org.openstack.model.atom.Link;

public interface Flavor {

	String getId();

	String getName();

	int getRam();

	int getVcpus();

	float getRxTxFactor();

	int getDisk();
	
	int getEphemeralGb();
	
	void setEphemeralGb(int value);

	String getSwap();

	List<Link> getLinks();

	Link getLink(final String rel);

}