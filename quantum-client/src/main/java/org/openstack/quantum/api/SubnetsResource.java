package org.openstack.quantum.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Subnet;
import org.openstack.quantum.model.SubnetForCreate;
import org.openstack.quantum.model.Subnets;

public class SubnetsResource {
	
	private final OpenStackClient CLIENT;
	
	public SubnetsResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Create create(SubnetForCreate net){
		return new Create(net);
	}
	
	public Delete delete(String netId){
		return new Delete(netId);
	}

	public Show show(String netId){
		return new Show(netId);
	}
	
	public class List extends OpenStackRequest<Subnets> {

		public List() {
			method(HttpMethod.GET);
			path("subnets");
			header("Accept", "application/json");
			returnType(Subnets.class);
		}

	}
	
	public class Query extends OpenStackRequest<Subnets> {

		public Query(Subnet subnet) {
			//super(subnet);
//			target = target.path("v2.0").path("subnets");
//			target = queryParam(target);
//			return target.request(MediaType.APPLICATION_JSON).get(Subnets.class);
		}

	}

	
	public class Create extends OpenStackRequest<Subnet> {
		
		private SubnetForCreate subnetForCreate;
		
		public Create(SubnetForCreate net){
			this.subnetForCreate=net;
			
			method(HttpMethod.POST);
			path("subnets");
			header("Accept", "application/json");
			json(subnetForCreate);
			returnType(Subnet.class);
		}
		
	}
	
	public class Show extends OpenStackRequest<Subnet> {
		
		private String id;
		
		public Show(String id) {
			this.id = id;
			method(HttpMethod.GET);
			path("subnets/").path(id);
			header("Accept", "application/json");
			returnType(Subnet.class);
		}

	}
	
	public class Delete extends OpenStackRequest<Void> {
		
		private String id;
		
		public Delete(String netId){
			this.id = netId;
			method(HttpMethod.DELETE);
			path("subnets/").path(id);
			header("Accept", "application/json");
		}
		
	}
	
}
