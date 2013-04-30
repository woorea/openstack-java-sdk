package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Host;
import org.openstack.nova.model.Hosts;

public class HostsExtension {
	
	private final OpenStackClient CLIENT;
	
	public HostsExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Show show(String id) {
		return new Show(id);
	}

	public class List extends OpenStackRequest<Hosts> {

		public List() {
			super(CLIENT, HttpMethod.GET, "/os-hosts", null, Hosts.class);
		}

	}

	public class Show extends OpenStackRequest<Host> {
		
		public Show(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuffer("/os-hosts/").append(id).toString(), null, Host.class);
		}
		
	}

	
	
}
