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
				if ("bookmark".equals(link.getRel())) {
					// This is the bookmark i get from trunk (wihout protocol version)
					// http://192.168.1.49:8774/7da90d9067ab4890ae94779a1859db8a/servers/d87c6d44-8118-4c11-8259-b9c784965d59
					if (!link.getHref().contains("/v1.1")) {
						link.setHref(link.getHref().replace(":8774/", ":8774/v1.1/"));
					}
					return true;
				} else {
					return false;
				}
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
