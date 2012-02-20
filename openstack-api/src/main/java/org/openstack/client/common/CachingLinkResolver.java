package org.openstack.client.common;

import java.util.List;

import org.openstack.model.atom.Link;
import org.openstack.model.compute.Flavor;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * Resolves links with caching; typically by fetching the entire collection in one request
 */
public class CachingLinkResolver implements LinkResolver {

	private final OpenstackSession session;
	private List<Flavor> flavorCache;

	public CachingLinkResolver(OpenstackSession session) {
		this.session = session;
	}

	@Override
	public Flavor resolveFlavor(String flavorId, List<Link> links) {
		if (flavorCache == null) {
			flavorCache = Lists.newArrayList(session.getComputeClient().root().flavors().list(true));
		}

		for (Flavor flavor : flavorCache) {
			if (Objects.equal(flavor.getId(), flavorId))
				return flavor;
		}

		return null;
	}

}
