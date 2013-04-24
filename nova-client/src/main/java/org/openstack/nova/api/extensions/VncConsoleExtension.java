package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.ServerAction.GetVncConsole;
import org.openstack.nova.model.ServerAction.VncConsole;

public class VncConsoleExtension {

	public static class GetVncConsoleServer implements OpenStackCommand<VncConsole> {
		
		private GetVncConsole action;

		private String id;
		
		public GetVncConsoleServer(String id, GetVncConsole action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.POST);
		    request.path("/servers/").path(id).path("/action");
		    request.header("Accept", "application/json");
		    request.json(action);
		    request.returnType(VncConsole.class);
		return request;
		}

	}
	
	public static GetVncConsoleServer getVncConsole(String id, String type) {
		GetVncConsole action = new GetVncConsole(type);
		return new GetVncConsoleServer(id, action);
	}

	
}
