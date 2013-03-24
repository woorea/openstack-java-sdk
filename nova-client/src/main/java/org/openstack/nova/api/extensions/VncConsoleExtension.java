package org.openstack.nova.api.extensions;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.ServerAction.GetVncConsole;
import org.openstack.nova.model.ServerAction.VncConsole;

public class VncConsoleExtension {

	public static class GetVncConsoleServer implements NovaCommand<VncConsole> {
		
		private GetVncConsole action;

		private String id;
		
		public GetVncConsoleServer(String id, GetVncConsole action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public VncConsole execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/servers/").path(id).path("/action");
		    request.header("Accept", "application/json");
		    request.json(action);
		    return connector.execute(request, VncConsole.class);
		}

	}
	
	public static GetVncConsoleServer getVncConsole(String id, String type) {
		GetVncConsole action = new GetVncConsole(type);
		return new GetVncConsoleServer(id, action);
	}

	
}
