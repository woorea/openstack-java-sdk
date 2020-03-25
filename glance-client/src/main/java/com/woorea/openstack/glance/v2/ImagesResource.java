package com.woorea.openstack.glance.v2;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackResponse;
import com.woorea.openstack.glance.model.v2.Image;
import com.woorea.openstack.glance.model.v2.ImageDownload;
import com.woorea.openstack.glance.model.v2.Images;

public class ImagesResource {

	private final OpenStackClient CLIENT;
	
	public ImagesResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list(boolean detail) {
		return new List(detail);
	}
	
	public Create create(Image image) {
		return new Create(image);
	}
	
	public Show show(String id) {
		return new Show(id);
	}
	
	public Delete delete(String id) {
		return new Delete(id);
	}
	
	public Download download(String id) {
		return new Download(id);
	}
	
	public class List extends OpenStackRequest<Images> {
		
		public List(boolean detail) {
			super(CLIENT, HttpMethod.GET, "/images", null, Images.class);
		}

	}

	public class Create extends OpenStackRequest<Image> {

		public Create(Image image) {
			super(CLIENT, HttpMethod.POST, "/images", Entity.json(image), Image.class);
		}

	}

	public class Delete extends OpenStackRequest<Void> {
		
		public Delete(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/images/").append(id).toString(), null, Void.class);
		}
		
	}
	
	public class Show extends OpenStackRequest<Image> {
		
		public Show(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/images/").append(id).toString(), null, Image.class);
		}
		
	}
	
	public class Download extends OpenStackRequest<ImageDownload> {

		public Download(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/images/").append(id).append("/file").toString(),
					null, ImageDownload.class);
			header("Accept", "application/octet-stream");
		}

		@Override
		public ImageDownload execute() {
			// custom parsing here
			OpenStackResponse response = CLIENT.request(this);
			ImageDownload imageDownload = new ImageDownload();
			imageDownload.setInputStream(response.getInputStream());
			return imageDownload;
		}

	}
}
