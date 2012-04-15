package org.openstack.client;

import java.util.Map;

import org.openstack.api.images.ImagesResource;
import org.openstack.model.images.ImageList;

public class ImagesClient {

	private ImagesResource resource;
	
	public ImagesClient(ImagesResource resource) {
		this.resource = resource;
	}
	
	public ImageList listImages() {
		return resource.get();
	}
	
	public ImageList listImages(int offset, int max) {
		return resource.get();
	}

	public ImageList listImages(Map<String, Object> params) {
		return resource.get();
	}

}
