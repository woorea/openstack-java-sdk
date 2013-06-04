package com.woorea.openstack.nova.api.extensions;


import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.FloatingIpDomain;
import com.woorea.openstack.nova.model.FloatingIpDomains;

public class FloatingIpDnsExtension {
	
	private final OpenStackClient CLIENT;
	
	public FloatingIpDnsExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public ListDomains listFloatingIpDomains() {
		return new ListDomains();
	}
	
	public CreateDomain create(FloatingIpDomain floatingIpDomain) {
		return new CreateDomain(floatingIpDomain);
	}
	
	public ShowDomain show(String id) {
		return new ShowDomain(id);
	}
	
	public UpdateDomain update(FloatingIpDomain floatingIpDomain) {
		return new UpdateDomain(floatingIpDomain);
	}
	
	public DeleteDomain delete(String id) {
		return new DeleteDomain(id);
	}
	
	public class ListDomains extends OpenStackRequest<FloatingIpDomains> {

		public ListDomains() {
			super(CLIENT, HttpMethod.GET, "/os-floating-ip-dns", null, FloatingIpDomains.class);
		}

	}

	public class CreateDomain extends OpenStackRequest<FloatingIpDomain> {

		private FloatingIpDomain floatingIpDomain;
		
		public CreateDomain(FloatingIpDomain floatingIpDomain) {
			super(CLIENT, HttpMethod.POST, "/os-floating-ip-dns", Entity.json(floatingIpDomain), FloatingIpDomain.class);
			this.floatingIpDomain = floatingIpDomain;
		}
		
	}
	
	public class ShowDomain extends OpenStackRequest<FloatingIpDomain> {
		
		public ShowDomain(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuffer("/os-floating-ip-dns/").append(id).toString(), null, FloatingIpDomain.class);
		}
		
	}

	
	public static class UpdateDomain extends OpenStackRequest<FloatingIpDomain> {

		private FloatingIpDomain floatingIpDomain;
		
		public UpdateDomain(FloatingIpDomain floatingIpDomain) {
			//super(CLIENT, HttpMethod.PUT, new StringBuffer("/os-floating-ip-dns/").append(id).toString(), Entity.json(floatingIpDomain), FloatingIpDomain.class);
			this.floatingIpDomain = floatingIpDomain;
		}
		
	}

	
	public class DeleteDomain extends OpenStackRequest<Void> {
		
		public DeleteDomain(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuffer("/os-floating-ip-dns/").append(id).toString(), null, Void.class);
		}
		
	}
	
	
	
}
