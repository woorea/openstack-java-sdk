package org.openstack.quantum.api;

import org.openstack.base.client.Entity;
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
		    super(CLIENT, HttpMethod.GET, "ports", null, Ports.class);
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

		public Create(PortForCreate port){
		    super(CLIENT, HttpMethod.POST, "ports", Entity.json(port), Port.class);
		}
	}

	public class Show extends OpenStackRequest<Port> {

		public Show(String id) {
		    super(CLIENT, HttpMethod.GET, buildPath("ports/", id), null, Port.class);
		}
	}

	public class Delete extends OpenStackRequest<Void> {

		public Delete(String id){
            super(CLIENT, HttpMethod.DELETE, buildPath("ports/", id), null, Void.class);
		}
	}
}
