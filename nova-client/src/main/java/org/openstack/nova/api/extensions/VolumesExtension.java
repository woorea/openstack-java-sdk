package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.VolumeAttachment;
import org.openstack.nova.model.VolumeForCreate;
import org.openstack.nova.model.Volumes;

public class VolumesExtension {
	
	public static class ListVolumes extends OpenStackRequest {
		
		public ListVolumes(boolean detail) {
			method(HttpMethod.GET);
		    path(detail ? "/os-volumes/detail" : "/os-volumes");
		    header("Accept", "application/json");
		    returnType(Volumes.class);
		}
		
		public ListVolumes() {
			this(false);
		}

	}

	
	public static class CreateVolume extends OpenStackRequest {

		private VolumeForCreate volumeForCreate;
		
		public CreateVolume(VolumeForCreate volumeForCreate) {
			this.volumeForCreate = volumeForCreate;
			//return target.path("os-volumes").request(MediaType.APPLICATION_JSON).post(Entity.json(volumeForCreate), Volume.class);
		}
		
	}
	
	public static class ShowVolume extends OpenStackRequest {

		private String id;
		
		public ShowVolume(String id) {
			this.id = id;
			//return target.path("os-volumes").path(id).request(MediaType.APPLICATION_JSON).get(Volume.class);
		}
		
	}

	
	public static class ShowVolumeMetadata extends OpenStackRequest {
		
		public ShowVolumeMetadata(String id) {
//			Metadata metadata = target.path("os-volumes").path(id).path("metadata").request(MediaType.APPLICATION_JSON).get(Metadata.class);
//			return metadata.getMetadata();
		}
		
	}

	
	public static class AttachVolumeToServer extends OpenStackRequest {
		
		private String serverId;
		
		private VolumeAttachment volumeAttachment;
		
		public AttachVolumeToServer(String serverId, String volumeId, String device) {
			this.serverId = serverId;
			volumeAttachment = new VolumeAttachment();
			volumeAttachment.setVolumeId(volumeId);
			volumeAttachment.setDevice(device);
//			target.path("servers").path(serverId).path("os-volume_attachments").request(MediaType.APPLICATION_JSON).post(Entity.json(volumeAttachment));
		}

	}
	
	public static class DetachVolumeFromServer extends OpenStackRequest {
		
		private String serverId;
		
		private String volumeId;
		
		public DetachVolumeFromServer(String serverId, String volumeId) {
			this.serverId = serverId;
			this.volumeId = volumeId;

//			target.path("servers").path(serverId).path("os-volume_attachments").path(volumeId).request(MediaType.APPLICATION_JSON).delete();
		}

	}
	
	public static class DeleteVolume extends OpenStackRequest {

		
		public DeleteVolume(String id) {

//			target.path("os-volumes").path(id).request(MediaType.APPLICATION_JSON).delete();
		}
		
	}
	
	public static ListVolumes listVolumes() {
		return new ListVolumes();
	}
	
	public static CreateVolume createVolume(VolumeForCreate volumeForCreate) {
		return new CreateVolume(volumeForCreate);
	}
	
	public static ShowVolume showVolume(String id) {
		return new ShowVolume(id);
	}
	
	public static ShowVolumeMetadata showVolumeMetadata(String id) {
		return new ShowVolumeMetadata(id);
	}
	
	public static DeleteVolume deleteVolume(String id) {
		return new DeleteVolume(id);
	}

	public static AttachVolumeToServer attachVolume(String serverId, String volumeId, String device) {
		return new AttachVolumeToServer(serverId, volumeId, device);
	}
	
	public static DetachVolumeFromServer detachVolume(String serverId, String volumeId) {
		return new DetachVolumeFromServer(serverId, volumeId);
	}
	
}
