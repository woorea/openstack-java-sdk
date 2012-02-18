package org.openstack.client.compute;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerList;

import com.sun.jersey.api.client.Client;

public class ServersRepresentation {

		private Client client;

		private ServerList model;

		public ServersRepresentation(Client client, ServerList model) {
			this.client = client;
			this.model = model;
		}

		public List<Server> getList() {
			return model.getList();
		}
		
		public ServerList getModel() {
			return model;
		}
		
		public ServerRepresentation fetch(int index) {
			Server server = client
					.resource(
							model.getList().get(index).getLinks().get(0).getHref())
					.accept(MediaType.APPLICATION_XML).get(Server.class);
			model.getList().set(index, server);
			return new ServerRepresentation(client, server);
		}

		public void fetchAll() {
			for (int i = 0; i < model.getList().size(); i++) {
				ServerRepresentation sr = fetch(i);
				sr.fetchAll();
			}
		}

		public ServersRepresentation next() {
			ServerList tenantList = client.resource(
					model.getLinks().get(0).getHref()).get(ServerList.class);
			return new ServersRepresentation(client, tenantList);
		}


}
