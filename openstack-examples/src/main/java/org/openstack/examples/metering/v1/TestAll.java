package org.openstack.examples.metering.v1;

import org.openstack.ceilometer.CeilometerClient;
import org.openstack.ceilometer.v1.api.ProjectList;
import org.openstack.ceilometer.v1.api.ResourceList;
import org.openstack.ceilometer.v1.api.UserList;
import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Authentication;
import org.openstack.keystone.model.Authentication.PasswordCredentials;

public class TestAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		KeystoneClient keystone = new KeystoneClient(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		Authentication authentication = new Authentication();
		PasswordCredentials passwordCredentials = new PasswordCredentials();
		passwordCredentials.setUsername(ExamplesConfiguration.KEYSTONE_USERNAME);
		passwordCredentials.setPassword(ExamplesConfiguration.KEYSTONE_PASSWORD);
		authentication.setTenantName("admin");
		authentication.setPasswordCredentials(passwordCredentials);
		
		//access with unscoped token
		Access access = keystone.execute(new Authenticate(authentication));
		
		CeilometerClient ceilometer = new CeilometerClient(ExamplesConfiguration.CEILOMETER_ENDPOINT);
		ceilometer.token(access.getToken().getId());
		ceilometer.execute(new UserList());
		ceilometer.execute(new ProjectList());
		//ceilometer.execute(new SourceList());
		ceilometer.execute(new ResourceList());

	}

}
