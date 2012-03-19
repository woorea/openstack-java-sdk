package org.openstack.api.compute;

import java.util.HashMap;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.client.OpenStackSession;
import org.openstack.client.SimpleLinkResolver;
import org.openstack.model.atom.Link;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaMetadata;
import org.openstack.model.identity.KeyStoneRole;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class ImageResource extends Resource {

	public ImageResource(Target target) {
		super(target);
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

	public NovaImage get(HashMap<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).get(NovaImage.class);
	}

	public void delete(HashMap<String, Object> properties) {
		target.request().delete();
	}

	public NovaMetadata metadata() {
		// /metadata
		return new NovaMetadata();
	}

}
