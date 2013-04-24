package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.FloatingIpDomain;
import org.openstack.nova.model.FloatingIpDomains;

public class FloatingIpDnsExtension {
	
	public class ListFloatingIpDomains implements OpenStackCommand<FloatingIpDomains>{

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.GET);
		    request.path("/os-floating-ip-dns/");
		    request.header("Accept", "application/json");
		    request.returnType(FloatingIpDomains.class);
		return request;
		}

	}

	public static class CreateFloatingIpDomain implements OpenStackCommand<FloatingIpDomain> {

		private FloatingIpDomain floatingIpDomain;
		
		public CreateFloatingIpDomain(FloatingIpDomain floatingIpDomain) {
			this.floatingIpDomain = floatingIpDomain;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.GET);
		    request.path("/os-floating-ip-dns/");
		    request.header("Accept", "application/json");
		    request.json(floatingIpDomain);
		    request.returnType(FloatingIpDomain.class);
		return request;
		}
		
	}
	
	public static class ShowFloatingIpDomain implements OpenStackCommand<FloatingIpDomain> {

		private String id;
		
		public ShowFloatingIpDomain(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			//return target.path("os-floating-ip-dns").path(id).request(MediaType.APPLICATION_JSON).get(FloatingIpDomain.class);
			return null;
		}
		
	}

	
	public static class UpdateFloatingIpDomain implements OpenStackCommand<FloatingIpDomain> {

		private FloatingIpDomain floatingIpDomain;
		
		public UpdateFloatingIpDomain(FloatingIpDomain floatingIpDomain) {
			this.floatingIpDomain = floatingIpDomain;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			//return target.path("os-floating-ip-dns").request(MediaType.APPLICATION_JSON).post(Entity.json(floatingIpDomain), FloatingIpDomain.class);
			return null;
		}
		
	}

	
	public class DeleteFloatingIpDomain implements OpenStackCommand<Void> {

		private String id;
		
		public DeleteFloatingIpDomain(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			//target.path("os-floating-ip-dns").path(id).request(MediaType.APPLICATION_JSON).delete();
			return null;
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
