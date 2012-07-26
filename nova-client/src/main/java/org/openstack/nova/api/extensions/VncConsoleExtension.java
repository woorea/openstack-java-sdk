package org.openstack.nova.api.extensions;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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
		public VncConsole execute(WebTarget target) {
			return target.path("servers").path(id).path("action").request(MediaType.APPLICATION_JSON).post(Entity.json(action), VncConsole.class);
		}

	}
	
	public static GetVncConsoleServer getVncConsole(String id, String type) {
		GetVncConsole action = new GetVncConsole(type);
		return new GetVncConsoleServer(id, action);
	}

	
}
