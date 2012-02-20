package org.openstack.client.common;

import java.util.List;

import org.openstack.client.OpenstackException;
import org.openstack.model.atom.Link;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;

/**
 * Allows pluggable strategies for link resolution
 */
public interface LinkResolver {
	Flavor resolveFlavor(String id, List<Link> links) throws OpenstackException;

	Image resolveImage(String id, List<Link> links) throws OpenstackException;
}
