package org.openstack.nova.api.extensions;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Host;
import org.openstack.nova.model.Hosts;

public class HostsExtension {

	public static class ListHosts implements NovaCommand<Hosts>{

		@Override
		public Hosts execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-hosts");
		    request.header("Accept", "application/json");
		    return connector.execute(request, Hosts.class);
		}

	}

	public static class ShowHost implements NovaCommand<Host> {

		private String id;
		
		public ShowHost(String id) {
			this.id = id;
		}

		@Override
		public Host execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-hosts/").path(id);
		    request.header("Accept", "application/json");
		    return connector.execute(request, Host.class);
		}
		
	}

	public static ListHosts listHosts() {
		return new ListHosts();
	}
	
	public static ShowHost showHost(String id) {
		return new ShowHost(id);
	}
	
}
