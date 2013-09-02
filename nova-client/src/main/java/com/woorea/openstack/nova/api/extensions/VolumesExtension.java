package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Metadata;
import com.woorea.openstack.nova.model.Volume;
import com.woorea.openstack.nova.model.VolumeForCreate;
import com.woorea.openstack.nova.model.VolumeForImageCreate;
import com.woorea.openstack.nova.model.Volumes;

public class VolumesExtension {

	private final OpenStackClient CLIENT;

	public VolumesExtension(OpenStackClient client) {
		CLIENT = client;
	}

	public List list(boolean detail) {
		return new List(detail);
	}

	public Create create(VolumeForCreate volume) {
		return new Create(volume);
	}

	public UploadToImage uploadToImage(VolumeForImageCreate volumeForImage) {
		return new UploadToImage(volumeForImage);
	}

	public Show show(String id) {
		return new Show(id);
	}

	public ShowMetadata showMetadata(String id) {
		return new ShowMetadata(id);
	}

	public Delete delete(String id) {
		return new Delete(id);
	}

	public class List extends OpenStackRequest<Volumes> {

		public List(boolean detail) {
			super(CLIENT, HttpMethod.GET, detail ? "/os-volumes/detail"
					: "/os-volumes", null, Volumes.class);
		}

	}

	public class Create extends OpenStackRequest<Volume> {

		// private Volume volume;

		public Create(VolumeForCreate volume) {
			super(CLIENT, HttpMethod.POST, "/os-volumes", Entity.json(volume),
					Volume.class);
			// this.volume = volume;
		}

	}

	// Upload volume to image service as image

	public class UploadToImage extends OpenStackRequest<Void> {

		public UploadToImage(VolumeForImageCreate volumeForImageCreate) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/volumes/")
					.append(volumeForImageCreate.getVolumeId() + "/action"),
					Entity.json(volumeForImageCreate), Void.class);
		}

	}

	public class Show extends OpenStackRequest<Volume> {

		public Show(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/os-volumes/")
					.append(id).toString(), null, Volume.class);
		}

	}

	public class ShowMetadata extends OpenStackRequest<Metadata> {

		public ShowMetadata(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/os-volumes/")
					.append(id).append("/metadata").toString(), null,
					Metadata.class);
		}

	}

	public class Delete extends OpenStackRequest<Void> {

		public Delete(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/os-volumes/")
					.append(id).toString(), null, Void.class);
		}

	}

}
