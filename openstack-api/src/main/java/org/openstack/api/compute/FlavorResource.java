package org.openstack.api.compute;

import java.util.HashMap;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.client.OpenStackSession;
import org.openstack.client.SimpleLinkResolver;
import org.openstack.model.atom.Link;
import org.openstack.model.compute.NovaFlavor;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class FlavorResource extends Resource {

	public FlavorResource(Target target) {
		super(target);
	}

	public FlavorResource(final OpenStackSession session, NovaFlavor flavor) {
		initialize(session, Iterables.find(flavor.getLinks(), new Predicate<Link>() {

			@Override
			public boolean apply(Link link) {
				if ("bookmark".equals(link.getRel())) {
					// This is the bookmark i get from trunk (wihout protocol version)
					// http://192.168.1.49:8774/7da90d9067ab4890ae94779a1859db8a/servers/d87c6d44-8118-4c11-8259-b9c784965d59
					SimpleLinkResolver.fixLinkHref(session, link);
					return true;
				} else {
					return false;
				}
			}
		}).getHref());
	}

	public NovaFlavor get(HashMap<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).get(NovaFlavor.class);
	}

	

}
