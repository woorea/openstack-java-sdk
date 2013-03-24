package org.openstack.nova.api.extensions;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.FloatingIpDomain;
import org.openstack.nova.model.FloatingIpDomains;

public class FloatingIpDnsExtension {
	
	public class ListFloatingIpDomains implements NovaCommand<FloatingIpDomains>{

		@Override
		public FloatingIpDomains execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-floating-ip-dns/");
		    request.header("Accept", "application/json");
		    return connector.execute(request, FloatingIpDomains.class);
		}

	}

	public static class CreateFloatingIpDomain implements NovaCommand<FloatingIpDomain> {

		private FloatingIpDomain floatingIpDomain;
		
		public CreateFloatingIpDomain(FloatingIpDomain floatingIpDomain) {
			this.floatingIpDomain = floatingIpDomain;
		}

		@Override
		public FloatingIpDomain execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-floating-ip-dns/");
		    request.header("Accept", "application/json");
		    request.json(floatingIpDomain);
		    return connector.execute(request, FloatingIpDomain.class);
		}
		
	}
	
	public static class ShowFloatingIpDomain implements NovaCommand<FloatingIpDomain> {

		private String id;
		
		public ShowFloatingIpDomain(String id) {
			this.id = id;
		}

		@Override
		public FloatingIpDomain execute(OpenStackClientConnector connector, OpenStackRequest request) {
			//return target.path("os-floating-ip-dns").path(id).request(MediaType.APPLICATION_JSON).get(FloatingIpDomain.class);
			return null;
		}
		
	}

	
	public static class UpdateFloatingIpDomain implements NovaCommand<FloatingIpDomain> {

		private FloatingIpDomain floatingIpDomain;
		
		public UpdateFloatingIpDomain(FloatingIpDomain floatingIpDomain) {
			this.floatingIpDomain = floatingIpDomain;
		}

		@Override
		public FloatingIpDomain execute(OpenStackClientConnector connector, OpenStackRequest request) {
			//return target.path("os-floating-ip-dns").request(MediaType.APPLICATION_JSON).post(Entity.json(floatingIpDomain), FloatingIpDomain.class);
			return null;
		}
		
	}

	
	public class DeleteFloatingIpDomain implements NovaCommand<Void> {

		private String id;
		
		public DeleteFloatingIpDomain(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
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
