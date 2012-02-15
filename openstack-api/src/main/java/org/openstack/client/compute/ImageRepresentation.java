package org.openstack.client.compute;


import org.openstack.model.compute.Image;

import com.sun.jersey.api.client.Client;

public class ImageRepresentation {

	private Client client;

	private Image model;

	public ImageRepresentation(Client client, Image model) {
		this.client = client;
		this.model = model;
	}

	public Image getList() {
		return model;
	}

}
