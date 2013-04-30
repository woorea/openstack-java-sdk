package org.openstack.quantum.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Port;
import org.openstack.quantum.model.PortForCreate;
import org.openstack.quantum.model.Ports;

public class PortsResource {
	
	private final OpenStackClient CLIENT;
	
	public PortsResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Create create(PortForCreate net){
		return new Create(net);
	}
	
	public Delete delete(String netId){
		return new Delete(netId);
	}

	public Show show(String netId){
		return new Show(netId);
	}
	
	public class List extends OpenStackRequest<Ports> {

		public List() {
			method(HttpMethod.GET);
			path("ports");
			header("Accept", "application/json");
			returnType(Ports.class);
		}

	}
	
	public class Query extends OpenStackRequest<Ports> {

		public Query(Port port) {
			//super(port);
//			target = target.path("v2.0").path("ports");
//			target = queryParam(target);
//			return target.request(MediaType.APPLICATION_JSON).get(Ports.class);
		}

	}

	
	public class Create extends OpenStackRequest<Port> {
		
		private PortForCreate portForCreate;
		
		public Create(PortForCreate net){
			this.portForCreate=net;
			
			method(HttpMethod.POST);
			path("ports");
			header("Accept", "application/json");
			json(portForCreate);
			returnType(Port.class);
		}
		
	}
	
	public class Show extends OpenStackRequest<Port> {
		
		private String id;
		
		public Show(String id) {
			this.id = id;
			method(HttpMethod.GET);
			path("ports/").path(id);
			header("Accept", "application/json");
			returnType(Port.class);
		}

	}
	
	public class Delete extends OpenStackRequest<Void> {
		
		private String id;
		
		public Delete(String netId){
			this.id = netId;
			method(HttpMethod.DELETE);
			path("ports/").path(id);
			header("Accept", "application/json");
		}
		
	}
	
}
