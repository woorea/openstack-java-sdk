package org.openstack.examples.keystone;

import org.openstack.base.client.OpenStackSimpleTokenProvider;
import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.Keystone;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.User;

public class KeystoneCreateUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		//access with unscoped token
		Access access = keystone.execute(Authenticate.withPasswordCredentials(
				ExamplesConfiguration.KEYSTONE_USERNAME, 
				ExamplesConfiguration.KEYSTONE_PASSWORD).withTenantName("admin"));

		User user = new User();
		user.setEmail("luis@woorea.es");
		user.setUsername("luis.gervaso");
		user.setPassword("password.0");
		user.setName("Luis");
		user.setEnabled(Boolean.TRUE);

		keystone = new Keystone("http://keystone.x.org/v2.0");
		keystone.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));
		//keystone.enableLogging(Logger.getLogger("keystone"), 10000);
		user = keystone.users().create(user).execute();
		System.out.println(user);
		keystone.users().delete(user.getId()).execute();
	}
}
