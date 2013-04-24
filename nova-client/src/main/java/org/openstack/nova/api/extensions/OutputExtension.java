package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.ServerAction.ConsoleOutput;
import org.openstack.nova.model.ServerAction.GetConsoleOutput;

public class OutputExtension {

	public static class GetConsoleOutputServer implements OpenStackCommand<ConsoleOutput> {
		
		private GetConsoleOutput action;

		private String id;
		
		public GetConsoleOutputServer(String id, GetConsoleOutput action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.POST);
		    request.path("/servers/").path(id).path("/action");
		    request.header("Accept", "application/json");
		    request.json(action);
		    
			return null;
		}

	}
	
	public static GetConsoleOutputServer getConsoleOutput(String id, int length) {
		GetConsoleOutput action = new GetConsoleOutput(length);
		return new GetConsoleOutputServer(id, action);
	}

	
}
