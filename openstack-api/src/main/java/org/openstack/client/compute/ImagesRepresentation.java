package org.openstack.client.compute;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.openstack.model.compute.Image;
import org.openstack.model.compute.ImageList;

import com.sun.jersey.api.client.Client;

public class ImagesRepresentation {

	private Client client;

	private ImageList model;

	public ImagesRepresentation(Client client, ImageList model) {
		this.client = client;
		this.model = model;
	}

	public List<Image> getList() {
		return model.getList();
	}

	public void fetch(int index) {
		Image image = client
				.resource(
						model.getList().get(index).getLinks().get(0).getHref())
				.accept(MediaType.APPLICATION_XML).get(Image.class);
		model.getList().set(index, image);
	}

	public void fetchAll() {
		for (int i = 0; i < model.getList().size(); i++) {
			fetch(i);
		}
	}

	public ImagesRepresentation next() {
		ImageList tenantList = client.resource(
				model.getLinks().get(0).getHref()).get(ImageList.class);
		return new ImagesRepresentation(client, tenantList);
	}

}
