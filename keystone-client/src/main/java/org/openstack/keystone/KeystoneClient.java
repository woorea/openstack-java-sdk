package org.openstack.keystone;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.keystone.api.EndpointsResource;
import org.openstack.keystone.api.RolesResource;
import org.openstack.keystone.api.ServicesResource;
import org.openstack.keystone.api.TenantsResource;
import org.openstack.keystone.api.TokensResource;
import org.openstack.keystone.api.UsersResource;

public class KeystoneClient extends OpenStackClient {
	
	public KeystoneClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}
	
	public KeystoneClient(String endpoint) {
		this(endpoint, null);
	}
	
	public TokensResource tokens() {
		return new TokensResource(this);
	}
	
	public TenantsResource tenants() {
		return new TenantsResource(this);
	}
	
	public UsersResource users() {
		return new UsersResource(this);
	}
	
	public RolesResource roles() {
		return new RolesResource(this);
	}
	
	public ServicesResource services() {
		return new ServicesResource(this);
	}
	
	public EndpointsResource endpoints() {
		return new EndpointsResource(this);
	}

}
