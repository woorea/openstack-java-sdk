package org.openstack.examples.keystone;

import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.api.CreateTenant;
import org.openstack.keystone.api.DeleteTenant;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Tenant;

public class KeystoneCreateTenant {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeystoneClient keystone = new KeystoneClient(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		//access with unscoped token
		Access access = keystone.execute(Authenticate.withPasswordCredentials(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD));

		access = keystone.execute(Authenticate.withToken(access.getToken().getId()).withTenantName("admin"));

		Tenant tenant = new Tenant();
		tenant.setName("benn.cs");
		tenant.setDescription("benn.cs");
		tenant.setEnabled(true);
		//Get the adminURL client and use the token got above
		keystone = new KeystoneClient("http://keystone.x.org/v2.0", access.getToken().getId());
		tenant = keystone.execute(new CreateTenant(tenant));
		System.out.println(tenant);
		keystone.execute(new DeleteTenant(tenant.getId()));
	}
}
