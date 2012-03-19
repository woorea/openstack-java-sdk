package org.openstack.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.openstack.model.atom.Link;
import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.exceptions.OpenstackException;

import com.google.common.base.Objects;

/**
 * Resolves links by fetching the linked-to item
 */
public class SimpleLinkResolver implements LinkResolver {

	protected final OpenStackSession session;

	public SimpleLinkResolver(OpenStackSession session) {
		this.session = session;
	}

	@Override
	public NovaFlavor resolveFlavor(String flavorId, List<Link> links) {
		NovaFlavor flavor = null;
		Link link = findLink(links, "bookmark");
		if (link != null) {
			fixLinkHref(session, link);
			flavor = session.follow(link, "GET", NovaFlavor.class);
		}

		if (flavor == null && flavorId != null) {
			//flavor = session.getComputeClient().root().flavors().flavor(flavorId).get(new HashMap<String, Object>());
		}

		return flavor;
	}

	public static void fixLinkHref(OpenStackSession session, Link link) {
		// dirty hack since urls are not correct in the XML
		// may this is fixed in the current revision
		// so simply comment this

		// This may actually be because the link shouldn't embed the client version?
		// If this isn't just a hack, we should probably avoid changing the Link URI!

		try {
			URI uri = URI.create(link.getHref());
			String path = uri.getPath();

			URI rootUri = null; //URI.create(session.getComputeClient().getRootUrl());

			String version = "/v1.1";
			if (rootUri.getPath().startsWith("/v2/")) {
				version = "/v2";
			}

			if (!path.startsWith(version + "/")) {
				path = version + path;
				uri = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), path, uri.getQuery(),
						uri.getFragment());
				link.setHref(uri.toString());
			}
		} catch (URISyntaxException e) {
			throw new IllegalStateException("Error parsing link href", e);
		}
	}

	@Override
	public NovaImage resolveImage(String imageId, List<Link> links) throws OpenstackException {
		NovaImage image = null;
		Link link = findLink(links, "bookmark");
		if (link != null) {
			fixLinkHref(session, link);
			image = session.follow(link, "GET", NovaImage.class);
		}

		if (image == null && imageId != null) {
			//image = session.getComputeClient().root().images().image(imageId).get(new HashMap<String, Object>());
		}

		return image;
	}

	private Link findLink(List<Link> links, String findRel) {
		if (links == null)
			return null;

		for (Link link : links) {
			if (Objects.equal(link.getRel(), findRel)) {
				return link;
			}
		}
		return null;
	}

}
