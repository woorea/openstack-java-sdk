package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Host;
import org.openstack.nova.model.Hosts;

public class HostsExtension {

	public static class ListHosts implements NovaCommand<Hosts>{

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
		    request.path("/os-hosts");
		    request.header("Accept", "application/json");
		    request.returnType(Hosts.class);
		return request;
		}

	}

	public static class ShowHost implements NovaCommand<Host> {

		private String id;
		
		public ShowHost(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
		    request.path("/os-hosts/").path(id);
		    request.header("Accept", "application/json");
		    request.returnType(Host.class);
		return request;
		}
		
	}

	public static ListHosts listHosts() {
		return new ListHosts();
	}
	
	public static ShowHost showHost(String id) {
		return new ShowHost(id);
	}
	
}
