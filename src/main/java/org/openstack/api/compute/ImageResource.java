package org.openstack.api.compute;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.nova.NovaImage;

public class ImageResource extends Resource {

	public ImageResource(Target target) {
		super(target);
	}

	public Image get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaImage.class);
	}

	public Response delete() {
		return target.request().delete();
	}

	/*
	public Metadata metadata() {
		// /metadata
		return new NovaMetadata();
	}
	*/

}
