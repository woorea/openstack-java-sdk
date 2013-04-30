package org.openstack.examples.hpcloud;

import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.Keystone;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.authentication.UsernamePassword;

public class KeystoneAuthentication {
	
	private static final String KEYSTONE_AUTH_URL = "https://region-a.geo-1.identity.hpcloudsvc.com:35357/v2.0";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Keystone keystone = new Keystone(KEYSTONE_AUTH_URL);
		
		//access with unscoped token
		Access access = keystone.tokens().authenticate(
				new UsernamePassword(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD))
				.execute();
		
		System.out.println(access);

	}

}
