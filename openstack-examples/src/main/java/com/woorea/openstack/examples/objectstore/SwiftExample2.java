package com.woorea.openstack.examples.objectstore;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.woorea.openstack.base.client.OpenStackSimpleTokenProvider;
import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.Role;
import com.woorea.openstack.keystone.model.Roles;
import com.woorea.openstack.keystone.model.Tenant;
import com.woorea.openstack.keystone.model.User;
import com.woorea.openstack.keystone.model.authentication.TokenAuthentication;
import com.woorea.openstack.keystone.model.authentication.UsernamePassword;

public class SwiftExample2 {

	private static Logger logger = Logger.getLogger(SwiftExample2.class
			.getName());

	public static void main(String[] args) throws Exception {
		Map<String, Role> roles = new HashMap<String, Role>();
		Keystone keystone = new Keystone(
				ExamplesConfiguration.KEYSTONE_AUTH_URL);
		Keystone adminKeystone = new Keystone(
				ExamplesConfiguration.KEYSTONE_ADMIN_AUTH_URL);
		// access with unscoped token
		Access access = keystone.tokens()
				.authenticate(new UsernamePassword("admin", "adminPassword"))
				.execute();

		Access adminAccess = keystone
				.tokens()
				.authenticate(
						new TokenAuthentication(access.getToken().getId()))
				.withTenantName("admin").execute();

		// use the token in the following requests
		keystone.setTokenProvider(new OpenStackSimpleTokenProvider(access
				.getToken().getId()));
		adminKeystone.token(adminAccess.getToken().getId());

		
		logger.info(adminKeystone.users().show("d07fca2858ba4774ab5076614100d353").execute().toString());
		
		Roles rolesList = adminKeystone.roles().list().execute();
		for (Role role : rolesList) {
			roles.put(role.getName(), role);
		}

		User user = new User();
		user.setUsername("daniele2");
		user.setName("daniele2");
		user.setPassword("clown123");
		user.setEmail("daniele.ulrich@niceneasy.ch");
		user.setEnabled(true);
		user = adminKeystone.users().create(user).execute();
		Tenant tenant = new Tenant();
		tenant.setName(user.getUsername());
		tenant.setEnabled(true);
		tenant.setDescription("tenant for user " + user.getName());
		tenant = adminKeystone.tenants().create(tenant).execute();
		user.setTenantId(tenant.getId());
		try {
		adminKeystone
				.tenants()
				.addUser(tenant.getId(), user.getId(),
						roles.get("admin").getId()).execute();
		adminKeystone
				.tenants()
				.addUser(tenant.getId(), user.getId(),
						roles.get("Member").getId()).execute();

		logger.info(user.toString());

			user = adminKeystone.users().update(user.getId(), user).execute();
			user = adminKeystone.users().update(user.getId(), user).execute();
			logger.info(user.toString());
			Access adminAccess2 = keystone
					.tokens()
					.authenticate(
							new UsernamePassword(user.getName(), user
									.getPassword()))
					.withTenantName(user.getName()).execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		adminKeystone.tenants().delete(tenant.getId()).execute();
		adminKeystone.users().delete(user.getId()).execute();

	}

}
