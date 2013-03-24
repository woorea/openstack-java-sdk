package org.openstack.nova.api.extensions;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
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
		public ConsoleOutput execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/servers/").path(id).path("/action");
		    request.header("Accept", "application/json");
		    request.json(action);
		    connector.execute(request);
			return null;
		}

	}
	
	public static GetConsoleOutputServer getConsoleOutput(String id, int length) {
		GetConsoleOutput action = new GetConsoleOutput(length);
		return new GetConsoleOutputServer(id, action);
	}

	
}
