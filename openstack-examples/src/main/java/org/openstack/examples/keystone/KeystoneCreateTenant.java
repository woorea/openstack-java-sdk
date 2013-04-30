package org.openstack.examples.keystone;

import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.Keystone;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Tenant;

public class KeystoneCreateTenant {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		//access with unscoped token
		Access access = keystone.execute(Authenticate.withPasswordCredentials(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD));

		access = keystone.execute(Authenticate.withToken(access.getToken().getId()).withTenantName("admin"));

		Tenant tenant = new Tenant();
		tenant.setName("benn.cs");
		tenant.setDescription("benn.cs");
		tenant.setEnabled(true);
		//Get the adminURL client and use the token got above
		keystone = new Keystone("http://keystone.x.org/v2.0");
		keystone.token(access.getToken().getId());
		tenant = keystone.tenants().create(tenant).execute();
		System.out.println(tenant);
		keystone.tenants().delete(tenant.getId());
	}
}
