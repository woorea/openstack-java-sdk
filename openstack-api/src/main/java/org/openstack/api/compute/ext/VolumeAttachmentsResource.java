package org.openstack.api.compute.ext;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.volume.NovaVolumeAttachment;


public class VolumeAttachmentsResource extends Resource {

	protected VolumeAttachmentsResource(Target target) {
		super(target);
	}
	
	public Response post(NovaVolumeAttachment attachment) {
		return target.request().post(Entity.entity(attachment, MediaType.APPLICATION_JSON));
	}
	
	public VolumeAttachmentResource attachment(Integer id) {
		return new VolumeAttachmentResource(target.path("/{volumeId}").pathParam("volumeId", id));
	}
	
	

}
