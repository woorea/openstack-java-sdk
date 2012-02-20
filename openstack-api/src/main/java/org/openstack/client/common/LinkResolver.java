package org.openstack.client.common;

import java.util.List;

import org.openstack.client.OpenstackException;
import org.openstack.model.atom.Link;
import org.openstack.model.compute.Flavor;

/**
 * Allows pluggable strategies for link resolution
 */
public interface LinkResolver {
	Flavor resolveFlavor(String id, List<Link> links) throws OpenstackException;
}
