package org.openstack.client.compute;

import javax.ws.rs.core.MediaType;

import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.server.Server;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;

public class ServerRepresentation {

	private Client client;

	private Server model;

	public ServerRepresentation(Client client, Server model) {
		this.client = client;
		this.model = model;
	}

	public Server getModel() {
		return model;
	}

	public void fetchAll() {
		fetchFlavor();
		fetchImage();
	}

	public FlavorRepresentation fetchFlavor() {
		try {
			String href = model.getFlavor().getLinks().get(0).getHref().replace("/1/", "/v1.1/1/");
			System.out.println(href);
			Flavor flavor = client
					.resource(href)
					.accept(MediaType.APPLICATION_XML).get(Flavor.class);
			model.setFlavor(flavor);
			return new FlavorRepresentation(client, flavor);
		} catch (UniformInterfaceException e) {
			System.out.println(e.getResponse().getEntity(String.class));
			return null;
			//throw new RuntimeException(e.getResponse().getEntity(String.class), e);
		}

	}

	public ImageRepresentation fetchImage() {
		try {
			String href = model.getImage().getLinks().get(0).getHref().replace("/1/", "/v1.1/1/");
			Image image = client
					.resource(href)
					.accept(MediaType.APPLICATION_XML).get(Image.class);
			model.setImage(image);
			return new ImageRepresentation(client, image);
		} catch (UniformInterfaceException e) {
			System.out.println(e.getResponse().getEntity(String.class));
			return null;
			//throw new RuntimeException(e.getResponse().getEntity(String.class), e);
		}
		

	}

}
