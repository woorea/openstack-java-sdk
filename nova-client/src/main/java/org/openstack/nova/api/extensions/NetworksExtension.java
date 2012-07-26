package org.openstack.nova.api.extensions;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Network;
import org.openstack.nova.model.Networks;

public class NetworksExtension {
	
	public static class ListNetworks implements NovaCommand<Networks>{

		@Override
		public Networks execute(WebTarget target) {
			return target.path("os-networks").request(MediaType.APPLICATION_JSON).get(Networks.class);
		}

	}

	public static class CreateNetwork implements NovaCommand<Network> {

		private Network network;
		
		public CreateNetwork(Network network) {
			this.network = network;
		}

		@Override
		public Network execute(WebTarget target) {
			return target.path("os-networks").request(MediaType.APPLICATION_JSON).post(Entity.json(network), Network.class);
		}
		
	}
	
	public class ShowNetwork implements NovaCommand<Network>{

		private String id;
		
		public ShowNetwork(String id) {
			this.id = id;
		}
		
		@Override
		public Network execute(WebTarget target) {
			return target.path("os-networks").path(id).request(MediaType.APPLICATION_JSON).get(Network.class);
		}

	}

	
	public static class DisassociateNetwork implements NovaCommand<Void>{

		private String id;
		
		public DisassociateNetwork(String id) {
			this.id = id;
		}
		
		@Override
		public Void execute(WebTarget target) {
			target.path("os-networks").path(id).request(MediaType.APPLICATION_JSON).post(Entity.json("{\"action\":\"disassociate\"}"));
			return null;
		}

	}
	
	public static class DeleteNetwork implements NovaCommand<Void>{

		private String id;
		
		public DeleteNetwork(String id) {
			this.id = id;
		}
		
		@Override
		public Void execute(WebTarget target) {
			target.path("os-networks").path(id).request(MediaType.APPLICATION_JSON).delete();
			return null;
		}

	}
	
	public ListNetworks listNetworks() {
		return new ListNetworks();
	}
	
	public ShowNetwork showNetwork(String id) {
		return new ShowNetwork(id);
	}
	
	public DeleteNetwork deleteNetwork(String id) {
		return new DeleteNetwork(id);
	}
	
	public DisassociateNetwork disassociateNetwork(String id) {
		return new DisassociateNetwork(id);
	}
	
}
