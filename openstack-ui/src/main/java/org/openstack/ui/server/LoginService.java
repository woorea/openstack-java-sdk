package org.openstack.ui.server;

import org.openstack.model.identity.KeyStoneAccess;

public interface LoginService {

	KeyStoneAccess login(String identityURL, String username, String password);

}
