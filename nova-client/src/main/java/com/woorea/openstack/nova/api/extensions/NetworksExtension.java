package com.woorea.openstack.nova.api.extensions;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Network;
import com.woorea.openstack.nova.model.Networks;

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
			super(CLIENT, HttpMethod.GET, "/os-networks", null, Networks.class);
		}

	}

	public class Create extends OpenStackRequest<Network> {

		private Network network;

		public Create(Network network) {
			super(CLIENT, HttpMethod.POST, "/os-networks", Entity.json(network), Network.class);
			this.network = network;
		}

	}

	public class Show extends OpenStackRequest<Network> {

		public Show(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/os-networks/").append(id).toString(), null, Network.class);
		}

	}

	public class Disassociate extends OpenStackRequest<Void> {

		public Disassociate(String id) {
			super(CLIENT, HttpMethod.POST, new StringBuilder("/os-networks/").append(id).toString(), Entity.json("{\"action\":\"disassociate\"}"), Void.class);
			;
		}

	}

	public class Delete extends OpenStackRequest<Void> {

		public Delete(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/os-networks/").append(id).toString(), null, Void.class);
		}

	}

	

}
