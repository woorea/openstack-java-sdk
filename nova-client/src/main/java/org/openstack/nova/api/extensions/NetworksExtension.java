package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Network;
import org.openstack.nova.model.Networks;

public class NetworksExtension {
	
	private final OpenStackClient CLIENT;
	
	public NetworksExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}

	public Show show(String id) {
		return new Show(id);
	}

	public Delete delete(String id) {
		return new Delete(id);
	}

	public Disassociate disassociate(String id) {
		return new Disassociate(id);
	}

	public class List extends OpenStackRequest<Networks> {


		public List() {
			OpenStackRequest request = new OpenStackRequest();
			method(HttpMethod.GET);
			path("/os-networks");
			header("Accept", "application/json");
			returnType(Networks.class);
		}

	}

	public class Create extends OpenStackRequest<Network> {

		private Network network;

		public Create(Network network) {
			this.network = network;
			method(HttpMethod.POST);
			path("/os-networks");
			header("Accept", "application/json");
			json(network);
			returnType(Network.class);
		}

	}

	public class Show extends OpenStackRequest<Network> {

		public Show(String id) {
			method(HttpMethod.GET);
			path("/os-networks/").path(id);
			header("Accept", "application/json");
			returnType(Network.class);
		}

	}

	public class Disassociate extends OpenStackRequest<Void> {

		public Disassociate(String id) {
			method(HttpMethod.POST);
			path("/os-networks/").path(id);
			header("Accept", "application/json");
			json("{\"action\":\"disassociate\"}");
		}

	}

	public class Delete extends OpenStackRequest<Void> {

		public Delete(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/os-networks/").append(id).toString(), null, Void.class);
		}

	}

	

}
