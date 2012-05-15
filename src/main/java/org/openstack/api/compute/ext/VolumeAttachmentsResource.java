package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.volume.NovaVolumeAttachment;


public class VolumeAttachmentsResource extends Resource {

	public VolumeAttachmentsResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public Response post(NovaVolumeAttachment attachment) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(attachment, MediaType.APPLICATION_JSON));
	}
	
	public VolumeAttachmentResource attachment(String id) {
		return new VolumeAttachmentResource(target.path("/{volumeId}").pathParam("volumeId", id), properties);
	}
	
	

}
