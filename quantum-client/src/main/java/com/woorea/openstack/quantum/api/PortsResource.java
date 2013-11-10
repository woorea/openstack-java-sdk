package com.woorea.openstack.quantum.api;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.quantum.model.Port;
import com.woorea.openstack.quantum.model.Ports;

public class PortsResource {

	private final OpenStackClient CLIENT;

	public PortsResource(OpenStackClient client) {
		CLIENT = client;
	}

	public List list() {
		return new List();
	}

	public Create create(Port port){
		return new Create(port);
	}

	public Update update(Port port){
	    return new Update(port);
	}

	public Delete delete(String portId){
		return new Delete(portId);
	}

	public Show show(String portId){
		return new Show(portId);
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

		public Create(Port port){
		    super(CLIENT, HttpMethod.POST, "ports", Entity.json(port), Port.class);
		}
	}

	public class Update extends OpenStackRequest<Port> {

	    public Update(Port port){
	        super(CLIENT, HttpMethod.PUT, buildPath("ports/", port.getId()), Entity.json(port), Port.class);
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
