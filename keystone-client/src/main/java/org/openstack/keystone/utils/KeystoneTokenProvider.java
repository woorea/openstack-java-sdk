package org.openstack.keystone.utils;

import java.net.PasswordAuthentication;
import java.util.concurrent.ConcurrentHashMap;

import org.openstack.base.client.OpenStackTokenProvider;
import org.openstack.keystone.Keystone;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.authentication.UsernamePassword;

public class KeystoneTokenProvider {

	protected Keystone keystone;

	protected String username;

	protected String password;

	ConcurrentHashMap<String, Access> hashTenantAccess;

	public KeystoneTokenProvider(String endpoint, String username, String password) {
		this.keystone = new Keystone(endpoint);
		this.username = username;
		this.password = password;
		this.hashTenantAccess = new ConcurrentHashMap<String, Access>();
	}

	public Access getAccessByTenant(String tenantName) {
		Access access = hashTenantAccess.get(tenantName);
		if (access == null) {
			access = keystone.tokens().authenticate(new UsernamePassword(username, password))
				.withTenantName(tenantName)
				.execute();
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
