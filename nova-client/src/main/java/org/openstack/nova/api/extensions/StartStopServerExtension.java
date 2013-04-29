package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.ServerAction.Start;
import org.openstack.nova.model.ServerAction.Stop;

public class StartStopServerExtension {

	public class StartServer extends OpenStackRequest {
		
		private Start action;

		private String id;
		
		public StartServer(String id) {
			this.id = id;
			this.action = new Start();
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}
	
	public class StopServer extends OpenStackRequest {
		
		private Stop action;

		private String id;
		
		public StopServer(String id) {
			this.id = id;
			this.action = new Stop();
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}
	
	public StartServer start(String id) {
		return new StartServer(id);
	}
	
	public StopServer stop(String id) {
		return new StopServer(id);
	}

	
}
