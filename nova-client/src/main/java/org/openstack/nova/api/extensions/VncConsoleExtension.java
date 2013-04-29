package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.ServerAction.GetVncConsole;
import org.openstack.nova.model.ServerAction.VncConsole;

public class VncConsoleExtension {

	public static class GetVncConsoleServer extends OpenStackRequest {
		
		private GetVncConsole action;

		private String id;
		
		public GetVncConsoleServer(String id, GetVncConsole action) {
			this.id = id;
			this.action = action;
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		    returnType(VncConsole.class);
		}

	}
	
	public static GetVncConsoleServer getVncConsole(String id, String type) {
		GetVncConsole action = new GetVncConsole(type);
		return new GetVncConsoleServer(id, action);
	}

	
}
