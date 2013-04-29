package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Host;
import org.openstack.nova.model.Hosts;

public class HostsExtension {

	public static class ListHosts extends OpenStackRequest {

		public ListHosts() {
		OpenStackRequest request = new OpenStackRequest();
		method(HttpMethod.GET);
		    path("/os-hosts");
		    header("Accept", "application/json");
		    returnType(Hosts.class);
		}

	}

	public static class ShowHost extends OpenStackRequest {
		
		public ShowHost(String id) {
			method(HttpMethod.GET);
		    path("/os-hosts/").path(id);
		    header("Accept", "application/json");
		    returnType(Host.class);
		}
		
	}

	public static ListHosts listHosts() {
		return new ListHosts();
	}
	
	public static ShowHost showHost(String id) {
		return new ShowHost(id);
	}
	
}
