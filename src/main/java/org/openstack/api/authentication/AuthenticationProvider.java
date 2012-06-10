package org.openstack.api.authentication;

import java.util.Properties;

public abstract class AuthenticationProvider {

	public abstract Properties authenticate(Properties properties);
	
}
