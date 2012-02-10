package org.openstack.client.compute;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.FlavorList;

import com.sun.jersey.api.client.Client;

public class FlavorsRepresentation {

	private Client client;

	private FlavorList model;

	public FlavorsRepresentation(Client client, FlavorList model) {
		this.client = client;
		this.model = model;
	}

	public List<org.openstack.model.compute.Flavor> getList() {
		return model.getList();
	}

	public void fetch(int index) {
		Flavor flavor = client
				.resource(
						model.getList().get(index).getLinks().get(0).getHref())
				.accept(MediaType.APPLICATION_XML).get(Flavor.class);
		model.getList().set(index, flavor);
	}

	public void fetchAll() {
		for (int i = 0; i < model.getList().size(); i++) {
			fetch(i);
		}
	}

	public FlavorsRepresentation next() {
		FlavorList tenantList = client.resource(
				model.getLinks().get(0).getHref()).get(FlavorList.class);
		return new FlavorsRepresentation(client, tenantList);
	}

}
