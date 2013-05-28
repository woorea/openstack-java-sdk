package org.openstack.quantum.api;

import org.openstack.base.client.Entity;
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
		    super(CLIENT, HttpMethod.GET, "subnets", null, Subnets.class);
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

		public Create(SubnetForCreate subnet){
		    super(CLIENT, HttpMethod.POST, "subnets", Entity.json(subnet), Subnet.class);
		}
	}

	public class Show extends OpenStackRequest<Subnet> {

		public Show(String id) {
            super(CLIENT, HttpMethod.GET, buildPath("subnets/", id), null, Subnet.class);
		}
	}

	public class Delete extends OpenStackRequest<Void> {

		public Delete(String id){
            super(CLIENT, HttpMethod.DELETE, buildPath("subnets/", id), null, Void.class);
		}
	}
}
