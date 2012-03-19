package org.openstack.client;

import java.util.List;

import org.openstack.model.atom.Link;
import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.exceptions.OpenstackException;

/**
 * Allows pluggable strategies for link resolution
 */
public interface LinkResolver {
	NovaFlavor resolveFlavor(String id, List<Link> links) throws OpenstackException;

	NovaImage resolveImage(String id, List<Link> links) throws OpenstackException;
}
