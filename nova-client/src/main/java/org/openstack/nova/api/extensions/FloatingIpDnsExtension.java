package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.FloatingIpDomain;
import org.openstack.nova.model.FloatingIpDomains;

public class FloatingIpDnsExtension {
	
	public class ListFloatingIpDomains extends OpenStackRequest<FloatingIpDomains> {

		public ListFloatingIpDomains() {
			method(HttpMethod.GET);
		    path("/os-floating-ip-dns/");
		    header("Accept", "application/json");
		    returnType(FloatingIpDomains.class);
		}

	}

	public static class CreateFloatingIpDomain extends OpenStackRequest {

		private FloatingIpDomain floatingIpDomain;
		
		public CreateFloatingIpDomain(FloatingIpDomain floatingIpDomain) {
			this.floatingIpDomain = floatingIpDomain;
			method(HttpMethod.GET);
		    path("/os-floating-ip-dns/");
		    header("Accept", "application/json");
		    json(floatingIpDomain);
		    returnType(FloatingIpDomain.class);
		}
		
	}
	
	public static class ShowFloatingIpDomain extends OpenStackRequest {
		
		public ShowFloatingIpDomain(String id) {
			//return target.path("os-floating-ip-dns").path(id).request(MediaType.APPLICATION_JSON).get(FloatingIpDomain.class);
		}
		
	}

	
	public static class UpdateFloatingIpDomain extends OpenStackRequest {

		private FloatingIpDomain floatingIpDomain;
		
		public UpdateFloatingIpDomain(FloatingIpDomain floatingIpDomain) {
			this.floatingIpDomain = floatingIpDomain;
			
			//return target.path("os-floating-ip-dns").request(MediaType.APPLICATION_JSON).post(Entity.json(floatingIpDomain), FloatingIpDomain.class);
		}
		
	}

	
	public class DeleteFloatingIpDomain extends OpenStackRequest {
		
		public DeleteFloatingIpDomain(String id) {
			//target.path("os-floating-ip-dns").path(id).request(MediaType.APPLICATION_JSON).delete();
		}
		
	}
	
	public ListFloatingIpDomains listFloatingIpDomains() {
		return new ListFloatingIpDomains();
	}
	
	public CreateFloatingIpDomain createFloatingIpDomain(FloatingIpDomain floatingIpDomain) {
		return new CreateFloatingIpDomain(floatingIpDomain);
	}
	
	public ShowFloatingIpDomain showFloatingIpDomain(String id) {
		return new ShowFloatingIpDomain(id);
	}
	
	public UpdateFloatingIpDomain updateFloatingIpDomain(FloatingIpDomain floatingIpDomain) {
		return new UpdateFloatingIpDomain(floatingIpDomain);
	}
	
	public DeleteFloatingIpDomain deleteFloatingIpDomain(String id) {
		return new DeleteFloatingIpDomain(id);
	}
	
}
