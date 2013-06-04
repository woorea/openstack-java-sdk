package com.woorea.openstack.nova.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Image;
import com.woorea.openstack.nova.model.Images;
import com.woorea.openstack.nova.model.Metadata;

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
	
	public ShowMetadata showMetadata(String id) {
		return new ShowMetadata(id);
	}

	
	public Delete delete(String id) {
		return new Delete(id);
	}

	public class List extends OpenStackRequest<Images> {
		
		public List(boolean detail) {
			super(CLIENT, HttpMethod.GET, detail ? "/images/detail" : "/images", null, Images.class);
		}

	}
	
	public class Create extends OpenStackRequest<Image> {

		private Image image;
		
		public Create(Image image) {
			super(CLIENT, HttpMethod.POST, "/images", Entity.json(image), Image.class);
			this.image = image;
		}
		
	}
	
	public class Show extends OpenStackRequest<Image> {
		
		public Show(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/images/").append(id).toString(), null, Image.class);
		}

	}
	
	public class ShowMetadata extends OpenStackRequest<Metadata> {
		
		public ShowMetadata(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/images/").append(id).append("/metadata").toString(), null, Metadata.class);
		}

	}
	
	public class Delete extends OpenStackRequest<Void> {
		
		public Delete(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/images/").append(id).toString(), null, Void.class);
		}
		
	}
	
}

