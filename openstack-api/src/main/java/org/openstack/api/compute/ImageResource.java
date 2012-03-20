package org.openstack.api.compute;

import java.util.HashMap;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaMetadata;

public class ImageResource extends Resource {

	public ImageResource(Target target) {
		super(target);
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
