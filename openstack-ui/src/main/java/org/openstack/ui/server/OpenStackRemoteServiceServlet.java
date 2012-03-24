package org.openstack.ui.server;

import org.openstack.client.jersey2.OpenStackClient;
import org.openstack.client.jersey2.OpenStackClientFactory;
import org.openstack.model.identity.KeystoneAccess;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public abstract class OpenStackRemoteServiceServlet extends RemoteServiceServlet {

	protected OpenStackClient getClient() {
		KeystoneAccess access = (KeystoneAccess) perThreadRequest.get().getSession().getAttribute(Constants.OPENSTACK_ACCESS);
		return OpenStackClientFactory.create(access);
		
	}
	
}
