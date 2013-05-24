package org.openstack.keystone.api;

import org.openstack.base.client.Entity;
import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Roles;
import org.openstack.keystone.model.Tenant;
import org.openstack.keystone.model.Tenants;
import org.openstack.keystone.model.Users;

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
	
	public ListUsers listUsers(String tenantId) {
		return new ListUsers(tenantId);
	}
	
	public AddUser addUser(String tenantId, String userId, String roleId) {
		return new AddUser(tenantId, userId, roleId);
	}
	
	public RemoveUser removeUser(String tenantId, String userId, String roleId) {
		return new RemoveUser(tenantId, userId, roleId);
	}
	
	public ListUserRoles listUserRoles(String tenantId, String userId) {
		return new ListUserRoles(tenantId, userId);
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
	
	public class ListUsers extends OpenStackRequest<Users> {
		
		public ListUsers(String tenantId) {
			super(client, HttpMethod.GET, new StringBuilder("/tenants/").append(tenantId).append("/users").toString(), null, Users.class);
		}

	}
	
	public class AddUser extends OpenStackRequest<Void> {
		
		public AddUser(String tenantId, String userId, String roleId) {
			super(client, HttpMethod.PUT, new StringBuilder("/tenants/").append(tenantId).append("/users/").append(userId).append("/roles/OS-KSADM/").append(roleId).toString(), null, Void.class);
		}

	}
	
	public class RemoveUser extends OpenStackRequest<Void> {
		
		public RemoveUser(String tenantId, String userId, String roleId) {
			super(client, HttpMethod.DELETE, new StringBuilder("/tenants/").append(tenantId).append("/users/").append(userId).append("/roles/OS-KSADM/").append(roleId).toString(), null, Void.class);
		}

	}
	
	public class ListUserRoles extends OpenStackRequest<Roles> {
		
		public ListUserRoles(String tenantId, String userId) {
			super(client, HttpMethod.GET, new StringBuilder("/tenants/").append(tenantId).append("/users/").append(userId).append("/roles").toString(), null, Roles.class);
		}

	}
	
}
