package org.openstack.ui.server;

import org.openstack.model.identity.KeystoneAccess;

public interface LoginService {

	KeystoneAccess login(String identityURL, String username, String password);

}
