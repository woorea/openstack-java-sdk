package org.openstack.ui.server;

import org.openstack.client.jersey2.OpenStackClient;
import org.openstack.client.jersey2.OpenStackClientFactory;
import org.openstack.model.identity.KeyStoneAccess;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public abstract class OpenStackRemoteServiceServlet extends RemoteServiceServlet {

	protected OpenStackClient getClient() {
		//return (OpenStackSession) perThreadRequest.get().getSession().getAttribute(Constants.OPENSTACK_SESSION);
		KeyStoneAccess access = new KeyStoneAccess();
		return OpenStackClientFactory.create(access);
		
	}
	
}
