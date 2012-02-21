package org.openstack.client.compute;

import org.openstack.client.common.OpenstackSession;
import org.openstack.client.common.Resource;
import org.openstack.model.atom.Link;
import org.openstack.model.compute.Flavor;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class FlavorResource extends Resource {

	private Flavor representation;

	public FlavorResource(OpenstackSession session, Flavor flavor) {
		initialize(session, Iterables.find(flavor.getLinks(), new Predicate<Link>() {

			@Override
			public boolean apply(Link link) {
				return "bookmark".equals(link.getRel());
			}
		}).getHref());
	}

	public Flavor show() {
		return representation;
	}

	public FlavorResource get() {
		representation = resource().get(Flavor.class);
		return this;
	}

}
