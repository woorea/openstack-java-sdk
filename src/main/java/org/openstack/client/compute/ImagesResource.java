package org.openstack.client.compute;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.ImageList;

import com.sun.jersey.api.client.Client;

public class ImagesResource extends Resource {
	
	public ImagesResource(Client client, String resource) {
		super(client, resource);
	}

	public ImagesRepresentation list() {
		ImageList list = client.resource(resource).accept(MediaType.APPLICATION_XML).get(ImageList.class);
		return new ImagesRepresentation(client, list);
	}
	
	public ImagesRepresentation details() {
		ImageList list = client.resource(new StringBuffer().append("/detail").toString()).accept(MediaType.APPLICATION_XML).get(ImageList.class);
		return new ImagesRepresentation(client, list);
	}
	
	public ImageResource image(String id) {
		return new ImageResource(client, new StringBuilder(resource).append("/").append(id).toString());
	}
	
}
