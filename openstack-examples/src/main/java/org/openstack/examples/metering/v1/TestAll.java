package org.openstack.examples.metering.v1;

import org.openstack.base.client.OpenStackSimpleTokenProvider;
import org.openstack.ceilometer.CeilometerClient;
import org.openstack.ceilometer.v1.api.ProjectList;
import org.openstack.ceilometer.v1.api.ResourceList;
import org.openstack.ceilometer.v1.api.UserList;
import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.Keystone;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.authentication.UsernamePassword;

public class TestAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		Access access = keystone.tokens()
				.authenticate(new UsernamePassword(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD))
				.withTenantName("admin")
				.execute();
		
		CeilometerClient ceilometer = new CeilometerClient(ExamplesConfiguration.CEILOMETER_ENDPOINT);
		ceilometer.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));
		ceilometer.execute(new UserList());
		ceilometer.execute(new ProjectList());
		//ceilometer.execute(new SourceList());
		ceilometer.execute(new ResourceList());

	}

}
