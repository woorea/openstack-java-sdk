package org.openstack.glance.api;

import org.openstack.base.client.Entity;
import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.model.Image;
import org.openstack.glance.model.Images;

public class ImagesResource {

	private OpenStackClient client;
	
	public ImagesResource(OpenStackClient client) {
		this.client = client;
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
	
	public Update update(String id, Image image) {
		return new Update(id, image);
	}
	
	public Delete delete(String id) {
		return new Delete(id);
	}

	public class List extends OpenStackRequest<Images> {
		
		public List(boolean detail) {
			super(client, HttpMethod.GET, detail ? "/images/detail" : "images", null, Images.class);
		}

	}
	
	public class Create extends OpenStackRequest<Image> {

		private Image image;
		
		public Create(Image image) {
			super(client, HttpMethod.POST, "/images", Entity.json(image), Image.class);
			this.image = image;
		}
		
	}
	
	public class Show extends OpenStackRequest<Image> {
		
		public Show(String id) {
			super(client, HttpMethod.GET, new StringBuilder("/images/").append(id).toString(), null, Image.class);
		}

	}
	
	public class Update extends OpenStackRequest<Image> {
		
		private Image image;
		
		public Update(String id, Image image) {
			super(client, HttpMethod.PUT, new StringBuilder("/images/").append(id).toString(), Entity.json(image), Image.class);
			this.image = image;
		}

	}
	
	public class Delete extends OpenStackRequest<Void> {
		
		public Delete(String id) {
			super(client, HttpMethod.DELETE, new StringBuilder("/images/").append(id).toString(), null, Void.class);
		}
		
	}
	
}
