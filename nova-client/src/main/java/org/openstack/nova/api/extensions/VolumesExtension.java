package org.openstack.nova.api.extensions;

import java.util.Map;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Volume;
import org.openstack.nova.model.VolumeAttachment;
import org.openstack.nova.model.VolumeForCreate;
import org.openstack.nova.model.Volumes;

public class VolumesExtension {
	
	public static class ListVolumes implements NovaCommand<Volumes>{

		boolean detail;
		
		public ListVolumes(boolean detail) {
			this.detail = detail;
		}
		
		public ListVolumes() {
			this(false);
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
		    request.path(detail ? "/os-volumes/detail" : "/os-volumes");
		    request.header("Accept", "application/json");
		    request.returnType(Volumes.class);
		return request;
		}

	}

	
	public static class CreateVolume implements NovaCommand<Volume> {

		private VolumeForCreate volumeForCreate;
		
		public CreateVolume(VolumeForCreate volumeForCreate) {
			this.volumeForCreate = volumeForCreate;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			//return target.path("os-volumes").request(MediaType.APPLICATION_JSON).post(Entity.json(volumeForCreate), Volume.class);
			return null;
		}
		
	}
	
	public static class ShowVolume implements NovaCommand<Volume> {

		private String id;
		
		public ShowVolume(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			//return target.path("os-volumes").path(id).request(MediaType.APPLICATION_JSON).get(Volume.class);
			return null;
		}
		
	}

	
	public static class ShowVolumeMetadata implements NovaCommand<Map<String, String>> {

		private String id;
		
		public ShowVolumeMetadata(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
//			Metadata metadata = target.path("os-volumes").path(id).path("metadata").request(MediaType.APPLICATION_JSON).get(Metadata.class);
//			return metadata.getMetadata();
			return null;
		}
		
	}

	
	public static class AttachVolumeToServer implements NovaCommand<Void> {
		
		private String serverId;
		
		private VolumeAttachment volumeAttachment;
		
		public AttachVolumeToServer(String serverId, String volumeId, String device) {
			this.serverId = serverId;
			volumeAttachment = new VolumeAttachment();
			volumeAttachment.setVolumeId(volumeId);
			volumeAttachment.setDevice(device);
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
//			target.path("servers").path(serverId).path("os-volume_attachments").request(MediaType.APPLICATION_JSON).post(Entity.json(volumeAttachment));
			return null;
		}

	}
	
	public static class DetachVolumeFromServer implements NovaCommand<Void> {
		
		private String serverId;
		
		private String volumeId;
		
		public DetachVolumeFromServer(String serverId, String volumeId) {
			this.serverId = serverId;
			this.volumeId = volumeId;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
//			target.path("servers").path(serverId).path("os-volume_attachments").path(volumeId).request(MediaType.APPLICATION_JSON).delete();
			return null;
		}

	}
	
	public static class DeleteVolume implements NovaCommand<Void> {

		private String id;
		
		public DeleteVolume(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
//			target.path("os-volumes").path(id).request(MediaType.APPLICATION_JSON).delete();
			return null;
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
