package org.openstack.model.common;

import org.openstack.model.identity.KeystoneAccess;

public class OpenStackSession2 {
	
	private KeystoneAccess access;

	public KeystoneAccess getAccess() {
		return access;
	}

	public void setAccess(KeystoneAccess access) {
		this.access = access;
	}
	
}
