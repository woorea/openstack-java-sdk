package org.openstack.ui.server;

import org.openstack.client.common.OpenStackSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public abstract class OpenStackRemoteServiceServlet extends RemoteServiceServlet {

	protected OpenStackSession getSession() {
		return (OpenStackSession) perThreadRequest.get().getSession().getAttribute(Constants.OPENSTACK_SESSION);
	}
	
}
