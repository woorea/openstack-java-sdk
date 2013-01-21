package org.openstack.examples.keystone;

import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.api.CreateTenant;
import org.openstack.keystone.api.DeleteTenant;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Tenant;
import org.openstack.keystone.utils.KeystoneUtils;

public class KeystoneCreateTenant {

	private static final String KEYSTONE_AUTH_URL = "http://10.1.245.150:5000/v2.0";

	private static final String KEYSTONE_USERNAME = "admin";

	private static final String KEYSTONE_PASSWORD = "admin";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeystoneClient keystone = new KeystoneClient(KEYSTONE_AUTH_URL);
		//access with unscoped token
		Access access = keystone.execute(Authenticate.withPasswordCredentials(KEYSTONE_USERNAME, KEYSTONE_PASSWORD));

		access = keystone.execute(Authenticate.withToken(access.getToken().getId()).withTenantName("admin"));

		Tenant tenant = new Tenant();
		tenant.setName("benn.cs");
		tenant.setDescription("benn.cs");
		tenant.setEnabled(true);
		//Get the adminURL client and use the token got above
		keystone = new KeystoneClient(KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "identity", null, "admin"),
				access.getToken().getId());
		tenant = keystone.execute(new CreateTenant(tenant));
		System.out.println(tenant);
		keystone.execute(new DeleteTenant(tenant.getId()));
	}
}
