package org.openstack.api.compute;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaMetadata;

public class ImageResource extends Resource {

	public ImageResource(Target target) {
		super(target);
	}

	public NovaImage get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaImage.class);
	}

	public Response delete() {
		return target.request().delete();
	}

	public NovaMetadata metadata() {
		// /metadata
		return new NovaMetadata();
	}

}
