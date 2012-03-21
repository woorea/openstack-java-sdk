package org.openstack.ui.server;

import org.openstack.client.jersey2.OpenStackClient;
import org.openstack.client.jersey2.OpenStackClientFactory;
import org.openstack.model.identity.KeyStoneAccess;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public abstract class OpenStackRemoteServiceServlet extends RemoteServiceServlet {

	protected OpenStackClient getClient() {
		KeyStoneAccess access = (KeyStoneAccess) perThreadRequest.get().getSession().getAttribute(Constants.OPENSTACK_ACCESS);
		return OpenStackClientFactory.create(access);
		
	}
	
}
