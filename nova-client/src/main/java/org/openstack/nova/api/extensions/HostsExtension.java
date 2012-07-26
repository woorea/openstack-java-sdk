package org.openstack.nova.api.extensions;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Host;
import org.openstack.nova.model.Hosts;

public class HostsExtension {

	public static class ListHosts implements NovaCommand<Hosts>{

		@Override
		public Hosts execute(WebTarget target) {
			return target.path("os-hosts").request(MediaType.APPLICATION_JSON).get(Hosts.class);
		}

	}

	public static class ShowHost implements NovaCommand<Host> {

		private String id;
		
		public ShowHost(String id) {
			this.id = id;
		}

		@Override
		public Host execute(WebTarget target) {
			return target.path("os-hosts").path(id).request(MediaType.APPLICATION_JSON).get(Host.class);
		}
		
	}

	public static ListHosts listHosts() {
		return new ListHosts();
	}
	
	public static ShowHost showHost(String id) {
		return new ShowHost(id);
	}
	
}
