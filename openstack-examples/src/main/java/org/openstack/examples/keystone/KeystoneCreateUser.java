package org.openstack.examples.keystone;

import java.util.logging.Logger;

import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.api.CreateUser;
import org.openstack.keystone.api.DeleteUser;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.User;

public class KeystoneCreateUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeystoneClient keystone = new KeystoneClient(ExamplesConfiguration.KEYSTONE_AUTH_URL);
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

		keystone = new KeystoneClient("http://keystone.x.org/v2.0");
		keystone.token(access.getToken().getId());
		//keystone.enableLogging(Logger.getLogger("keystone"), 10000);
		user = keystone.execute(new CreateUser(user));
		System.out.println(user);
		keystone.execute(new DeleteUser(user.getId()));
	}
}
