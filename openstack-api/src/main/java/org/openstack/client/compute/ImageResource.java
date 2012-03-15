package org.openstack.client.compute;

import org.openstack.client.common.OpenStackSession;
import org.openstack.client.common.Resource;
import org.openstack.client.common.SimpleLinkResolver;
import org.openstack.model.atom.Link;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaMetadata;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class ImageResource extends Resource {

	private NovaImage representation;

	public ImageResource() {

	}

	public ImageResource(final OpenStackSession session, NovaImage image) {
		initialize(session, Iterables.find(image.getLinks(), new Predicate<Link>() {

			@Override
			public boolean apply(Link link) {
				if ("bookmark".equals(link.getRel())) {
					// This is the bookmark i get from trunk (wihout protocol version)
					SimpleLinkResolver.fixLinkHref(session, link);
					return true;
				} else {
					return false;
				}
			}
		}).getHref());
	}

	public ImageResource get() {
		representation = resource().get(NovaImage.class);
		return this;
	}

	public NovaImage show() {
		if (representation == null) {
			get();
		}
		return representation;
	}

	public void delete() {
		resource().delete();
	}

	public NovaMetadata metadata() {
		// /metadata
		return new NovaMetadata();
	}

}
