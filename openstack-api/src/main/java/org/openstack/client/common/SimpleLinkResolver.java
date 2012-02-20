package org.openstack.client.common;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openstack.model.atom.Link;
import org.openstack.model.compute.Flavor;

import com.google.common.base.Objects;

/**
 * Resolves links by fetching the linked-to item
 */
public class SimpleLinkResolver implements LinkResolver {

	private final OpenstackSession session;

	public SimpleLinkResolver(OpenstackSession session) {
		this.session = session;
	}

	public Flavor resolveFlavor(String flavorId, List<Link> links) {
		Flavor flavor = null;
		Link link = findLink(links, "bookmark");
		if (link != null) {
			// dirty hack since urls are not correct in the XML
			// may this is fixed in the current revision
			// so simply comment this

			try {
				URI uri = URI.create(link.getHref());
				String path = uri.getPath();
				if (!path.startsWith("v1.1")) {
					path = "/v1.1" + path;
					uri = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), path,
							uri.getQuery(), uri.getFragment());
					link.setHref(uri.toString());
				}
			} catch (URISyntaxException e) {
				throw new IllegalStateException("Error parsing link href", e);
			}
			flavor = link.follow(session, "GET", Flavor.class);
		}

		if (flavor == null && flavorId != null) {
			flavor = session.getComputeClient().root().flavors().flavor(flavorId).show();
		}

		return flavor;
	}

	private Link findLink(List<Link> links, String findRel) {
		for (Link link : links) {
			if (Objects.equal(link.getRel(), findRel)) {
				return link;
			}
		}
		return null;
	}

}
