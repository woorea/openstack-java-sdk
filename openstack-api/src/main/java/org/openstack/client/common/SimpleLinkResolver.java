package org.openstack.client.common;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openstack.client.OpenstackException;
import org.openstack.model.atom.Link;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;

import com.google.common.base.Objects;

/**
 * Resolves links by fetching the linked-to item
 */
public class SimpleLinkResolver implements LinkResolver {

	protected final OpenstackSession session;

	public SimpleLinkResolver(OpenstackSession session) {
		this.session = session;
	}

	@Override
	public Flavor resolveFlavor(String flavorId, List<Link> links) {
		Flavor flavor = null;
		Link link = findLink(links, "bookmark");
		if (link != null) {
			fixLinkHref(link);
			flavor = link.follow(session, "GET", Flavor.class);
		}

		if (flavor == null && flavorId != null) {
			flavor = session.getComputeClient().root().flavors().flavor(flavorId).show();
		}

		return flavor;
	}

	private void fixLinkHref(Link link) {
		// dirty hack since urls are not correct in the XML
		// may this is fixed in the current revision
		// so simply comment this

		// This may actually be because the link shouldn't embed the client version?
		// If this isn't just a hack, we should probably avoid changing the Link URI!

		try {
			URI uri = URI.create(link.getHref());
			String path = uri.getPath();
			if (!path.startsWith("/v1.1")) {
				path = "/v1.1" + path;
				uri = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), path, uri.getQuery(),
						uri.getFragment());
				link.setHref(uri.toString());
			}
		} catch (URISyntaxException e) {
			throw new IllegalStateException("Error parsing link href", e);
		}
	}

	@Override
	public Image resolveImage(String imageId, List<Link> links) throws OpenstackException {
		Image image = null;
		Link link = findLink(links, "bookmark");
		if (link != null) {
			fixLinkHref(link);
			image = link.follow(session, "GET", Image.class);
		}

		if (image == null && imageId != null) {
			image = session.getComputeClient().root().images().image(imageId).show();
		}

		return image;
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
