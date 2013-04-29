package org.openstack.keystone.api;

import org.openstack.base.client.Entity;
import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Tenant;
import org.openstack.keystone.model.Tenants;

public class TenantsResource {
	
	private OpenStackClient client;
	
	public TenantsResource(OpenStackClient client) {
		this.client = client;
	}
	
	public List list() {
		return new List();
	}
	
	public Create create(Tenant tenant) {
		return new Create(tenant);
	}
	
	public Show show(String id) {
		return new Show(id);
	}
	
	public Update update(String id, Tenant tenant) {
		return new Update(id, tenant);
	}
	
	public Delete delete(String id) {
		return new Delete(id);
	}

	public class List extends OpenStackRequest<Tenants> {
		
		public List() {
			super(client, HttpMethod.GET, "/tenants", null, Tenants.class);
		}

	}
	
	public class Create extends OpenStackRequest<Tenant> {

		private Tenant tenant;
		
		public Create(Tenant tenant) {
			super(client, HttpMethod.POST, "/tenants", Entity.json(tenant), Tenant.class);
			this.tenant = tenant;
		}
		
	}
	
	public class Show extends OpenStackRequest<Tenant> {
		
		public Show(String id) {
			super(client, HttpMethod.GET, new StringBuilder("/tenants/").append(id).toString(), null, Tenant.class);
		}

	}
	
	public class Update extends OpenStackRequest<Tenant> {
		
		private Tenant tenant;
		
		public Update(String id, Tenant tenant) {
			super(client, HttpMethod.PUT, new StringBuilder("/tenants/").append(id).toString(), Entity.json(tenant), Tenant.class);
			this.tenant = tenant;
		}

	}
	
	public class Delete extends OpenStackRequest<Void> {
		
		public Delete(String id) {
			super(client, HttpMethod.DELETE, new StringBuilder("/tenants/").append(id).toString(), null, Void.class);
		}
		
	}
	
}
