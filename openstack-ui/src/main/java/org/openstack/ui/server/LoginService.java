package org.openstack.ui.server;

import org.openstack.client.common.OpenStackSession;

public interface LoginService {

	OpenStackSession login(String identityURL, String username, String password);

}
