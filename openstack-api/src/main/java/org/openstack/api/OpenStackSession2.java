package org.openstack.api;

import org.openstack.model.identity.KeyStoneAccess;

public class OpenStackSession2 {
	
	private KeyStoneAccess access;

	public KeyStoneAccess getAccess() {
		return access;
	}

	public void setAccess(KeyStoneAccess access) {
		this.access = access;
	}
	
}
