package org.openstack.quantum.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Network;
import org.openstack.quantum.model.NetworkForCreate;
import org.openstack.quantum.model.Networks;

public class NetworksResource {
	
	private final OpenStackClient CLIENT;
	
	public NetworksResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Create create(NetworkForCreate net){
		return new Create(net);
	}
	
	public Delete delete(String netId){
		return new Delete(netId);
	}

	public Show show(String netId){
		return new Show(netId);
	}
	
	public class List extends OpenStackRequest<Networks> {

		public List() {
			method(HttpMethod.GET);
			path("networks");
			header("Accept", "application/json");
			returnType(Networks.class);
		}

	}
	
	public class Query extends OpenStackRequest<Networks> {

		public Query(Network network) {
			//super(network);
//			target = target.path("v2.0").path("networks");
//			target = queryParam(target);
//			return target.request(MediaType.APPLICATION_JSON).get(Networks.class);
		}

	}

	
	public class Create extends OpenStackRequest<Network> {
		
		private NetworkForCreate networkForCreate;
		
		public Create(NetworkForCreate net){
			this.networkForCreate=net;
			
			method(HttpMethod.POST);
			path("networks");
			header("Accept", "application/json");
			json(networkForCreate);
			returnType(Network.class);
		}
		
	}
	
	public class Show extends OpenStackRequest<Network> {
		
		private String id;
		
		public Show(String id) {
			this.id = id;
			method(HttpMethod.GET);
			path("networks/").path(id);
			header("Accept", "application/json");
			returnType(Network.class);
		}

	}
	
	public class Delete extends OpenStackRequest<Void> {
		
		private String id;
		
		public Delete(String netId){
			this.id = netId;
			method(HttpMethod.DELETE);
			path("networks/").path(id);
			header("Accept", "application/json");
		}
		
	}
	
}
