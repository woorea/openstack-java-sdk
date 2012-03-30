package org.openstack.api.compute.ext;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;

public class VolumeAttachmentResource extends Resource {

	protected VolumeAttachmentResource(Target target) {
		super(target);
	}
	
	public Response delete() {
		return target.request().delete();
	}

}
