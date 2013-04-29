package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.ServerAction.GetConsoleOutput;

public class OutputExtension {

	public static class GetConsoleOutputServer extends OpenStackRequest {
		
		private GetConsoleOutput action;

		private String id;
		
		public GetConsoleOutputServer(String id, GetConsoleOutput action) {
			this.id = id;
			this.action = action;
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}
	
	public static GetConsoleOutputServer getConsoleOutput(String id, int length) {
		GetConsoleOutput action = new GetConsoleOutput(length);
		return new GetConsoleOutputServer(id, action);
	}

	
}
