package org.openstack.nova.api.extensions;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.ServerAction.ConsoleOutput;
import org.openstack.nova.model.ServerAction.GetConsoleOutput;

public class OutputExtension {

	public static class GetConsoleOutputServer implements NovaCommand<ConsoleOutput> {
		
		private GetConsoleOutput action;

		private String id;
		
		public GetConsoleOutputServer(String id, GetConsoleOutput action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public ConsoleOutput execute(WebTarget target) {
			return target.path("servers").path(id).path("action").request(MediaType.APPLICATION_JSON).post(Entity.json(action), ConsoleOutput.class);
		}

	}
	
	public static GetConsoleOutputServer getConsoleOutput(String id, int length) {
		GetConsoleOutput action = new GetConsoleOutput(length);
		return new GetConsoleOutputServer(id, action);
	}

	
}
