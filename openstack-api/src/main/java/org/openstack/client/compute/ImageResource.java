package org.openstack.client.compute;

import org.openstack.client.common.OpenstackSession;
import org.openstack.client.common.Resource;
import org.openstack.model.atom.Link;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.Metadata;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class ImageResource extends Resource {

	private Image representation;

	public ImageResource(OpenstackSession session, Image image) {
		initialize(session, Iterables.find(image.getLinks(), new Predicate<Link>() {

			@Override
			public boolean apply(Link link) {
				return "bookmark".equals(link.getRel());
			}
		}).getHref());
	}

	public Image show() {
		return representation;
	}

	public void delete() {
		resource().delete();
	}

	public Metadata metadata() {
		// /metadata
		return new Metadata();
	}

	public ImageResource get() {
		representation = resource().get(Image.class);
		return this;
	}

}
