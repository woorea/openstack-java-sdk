package org.openstack.keystone.utils;

import java.util.concurrent.ConcurrentHashMap;

import org.openstack.base.client.OpenStackTokenProvider;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;

public class KeystoneTokenProvider {

	protected KeystoneClient keystone;

	protected String username;

	protected String password;

	ConcurrentHashMap<String, Access> hashTenantAccess;

	public KeystoneTokenProvider(String endpoint, String username, String password) {
		this.keystone = new KeystoneClient(endpoint);
		this.username = username;
		this.password = password;
		this.hashTenantAccess = new ConcurrentHashMap<String, Access>();
	}

	public Access getAccessByTenant(String tenantName) {
		Access access = hashTenantAccess.get(tenantName);
		if (access == null) {
			access = keystone.execute(Authenticate.withPasswordCredentials(
					username, password).withTenantName(tenantName));
			hashTenantAccess.put(tenantName, access);
		}
		return access;
	}

	public void expireAccessByTenant(String tenantName) {
		hashTenantAccess.remove(tenantName);
	}

	public OpenStackTokenProvider getProviderByTenant(final String tenantName) {
		final KeystoneTokenProvider keystoneTokenProvider = this;
		return new OpenStackTokenProvider() {
			@Override
			public String getToken() {
				return keystoneTokenProvider.getAccessByTenant(tenantName)
						.getToken().getId();
			}
			@Override
			public void expireToken() {
				keystoneTokenProvider.expireAccessByTenant(tenantName);
			}
		};
	}
}
