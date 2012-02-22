package org.openstack.client.compute;

import org.openstack.client.common.OpenstackSession;
import org.openstack.client.common.Resource;
import org.openstack.client.common.SimpleLinkResolver;
import org.openstack.model.atom.Link;
import org.openstack.model.compute.Flavor;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class FlavorResource extends Resource {

	private Flavor representation;

	public FlavorResource() {

	}

	public FlavorResource(OpenstackSession session, Flavor flavor) {
		initialize(session, Iterables.find(flavor.getLinks(), new Predicate<Link>() {

			@Override
			public boolean apply(Link link) {
				if ("bookmark".equals(link.getRel())) {
					// This is the bookmark i get from trunk (wihout protocol version)
					// http://192.168.1.49:8774/7da90d9067ab4890ae94779a1859db8a/servers/d87c6d44-8118-4c11-8259-b9c784965d59
					SimpleLinkResolver.fixLinkHref(link);
					return true;
				} else {
					return false;
				}
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
