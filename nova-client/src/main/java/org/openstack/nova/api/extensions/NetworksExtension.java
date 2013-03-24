package org.openstack.nova.api.extensions;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Network;
import org.openstack.nova.model.Networks;

public class NetworksExtension {
	
	public static class ListNetworks implements NovaCommand<Networks>{

		@Override
		public Networks execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-networks");
		    request.header("Accept", "application/json");
		    return connector.execute(request, Networks.class);
		}

	}

	public static class CreateNetwork implements NovaCommand<Network> {

		private Network network;
		
		public CreateNetwork(Network network) {
			this.network = network;
		}

		@Override
		public Network execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/os-networks");
		    request.header("Accept", "application/json");
		    request.json(network);
		    return connector.execute(request, Network.class);
		}
		
	}
	
	public class ShowNetwork implements NovaCommand<Network>{

		private String id;
		
		public ShowNetwork(String id) {
			this.id = id;
		}
		
		@Override
		public Network execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-networks/").path(id);
		    request.header("Accept", "application/json");
		    return connector.execute(request, Network.class);
		}

	}

	
	public static class DisassociateNetwork implements NovaCommand<Void>{

		private String id;
		
		public DisassociateNetwork(String id) {
			this.id = id;
		}
		
		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/os-networks/").path(id);
		    request.header("Accept", "application/json");
		    request.json("{\"action\":\"disassociate\"}");
		    connector.execute(request);
		    return null;
		}

	}
	
	public static class DeleteNetwork implements NovaCommand<Void>{

		private String id;
		
		public DeleteNetwork(String id) {
			this.id = id;
		}
		
		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("DELTE");
		    request.path("/os-networks/").path(id);
		    request.header("Accept", "application/json");
		    connector.execute(request);
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
