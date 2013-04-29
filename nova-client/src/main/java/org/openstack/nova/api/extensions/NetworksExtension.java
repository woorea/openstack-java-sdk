package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Network;
import org.openstack.nova.model.Networks;

public class NetworksExtension {

	public static class ListNetworks extends OpenStackRequest {


		public ListNetworks() {
			OpenStackRequest request = new OpenStackRequest();
			method(HttpMethod.GET);
			path("/os-networks");
			header("Accept", "application/json");
			returnType(Networks.class);
		}

	}

	public static class CreateNetwork extends OpenStackRequest {

		private Network network;

		public CreateNetwork(Network network) {
			this.network = network;
			method(HttpMethod.POST);
			path("/os-networks");
			header("Accept", "application/json");
			json(network);
			returnType(Network.class);
		}

	}

	public class ShowNetwork extends OpenStackRequest {

		public ShowNetwork(String id) {
			method(HttpMethod.GET);
			path("/os-networks/").path(id);
			header("Accept", "application/json");
			returnType(Network.class);
		}

	}

	public static class DisassociateNetwork extends OpenStackRequest {

		public DisassociateNetwork(String id) {
			method(HttpMethod.POST);
			path("/os-networks/").path(id);
			header("Accept", "application/json");
			json("{\"action\":\"disassociate\"}");
		}

	}

	public static class DeleteNetwork extends OpenStackRequest {

		public DeleteNetwork(String id) {
			method(HttpMethod.DELETE);
			path("/os-networks/").path(id);
			header("Accept", "application/json");
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
