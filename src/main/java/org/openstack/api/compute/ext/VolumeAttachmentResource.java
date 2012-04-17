package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;

public class VolumeAttachmentResource extends Resource {

	public VolumeAttachmentResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public Response delete() {
		return target.request().delete();
	}

}
