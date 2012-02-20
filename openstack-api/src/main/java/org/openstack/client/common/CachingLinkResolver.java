package org.openstack.client.common;

import java.util.List;

import org.openstack.client.OpenstackException;
import org.openstack.model.atom.Link;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * Resolves links with caching; typically by fetching the entire collection in one request
 */
public class CachingLinkResolver extends SimpleLinkResolver {

	private List<Flavor> flavorCache;
	private List<Image> imageCache;

	public CachingLinkResolver(OpenstackSession session) {
		super(session);
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

	@Override
	public Image resolveImage(String imageId, List<Link> links) throws OpenstackException {
		if (imageCache == null) {
			imageCache = Lists.newArrayList(session.getComputeClient().root().images().list(true));
		}

		for (Image image : imageCache) {
			if (Objects.equal(image.getId(), imageId))
				return image;
		}

		return null;
	}

}
