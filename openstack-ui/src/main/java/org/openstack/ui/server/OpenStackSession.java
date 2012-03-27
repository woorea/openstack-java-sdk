package org.openstack.ui.server;

import java.io.Serializable;
import java.util.Properties;

import org.openstack.model.identity.KeystoneAccess;

public class OpenStackSession implements Serializable {

	private Properties properties;
	
	private KeystoneAccess access;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public KeystoneAccess getAccess() {
		return access;
	}

	public void setAccess(KeystoneAccess access) {
		this.access = access;
	}

}
