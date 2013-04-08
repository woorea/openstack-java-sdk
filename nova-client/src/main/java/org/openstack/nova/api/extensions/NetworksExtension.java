package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Network;
import org.openstack.nova.model.Networks;

public class NetworksExtension {

	public static class ListNetworks implements NovaCommand<Networks> {

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/os-networks");
			request.header("Accept", "application/json");
			request.returnType(Networks.class);
			return request;
		}

	}

	public static class CreateNetwork implements NovaCommand<Network> {

		private Network network;

		public CreateNetwork(Network network) {
			this.network = network;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.POST);
			request.path("/os-networks");
			request.header("Accept", "application/json");
			request.json(network);
			request.returnType(Network.class);
			return request;
		}

	}

	public class ShowNetwork implements NovaCommand<Network> {

		private String id;

		public ShowNetwork(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/os-networks/").path(id);
			request.header("Accept", "application/json");
			request.returnType(Network.class);
			return request;
		}

	}

	public static class DisassociateNetwork implements NovaCommand<Void> {

		private String id;

		public DisassociateNetwork(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.POST);
			request.path("/os-networks/").path(id);
			request.header("Accept", "application/json");
			request.json("{\"action\":\"disassociate\"}");

			return null;
		}

	}

	public static class DeleteNetwork implements NovaCommand<Void> {

		private String id;

		public DeleteNetwork(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.DELETE);
			request.path("/os-networks/").path(id);
			request.header("Accept", "application/json");

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
