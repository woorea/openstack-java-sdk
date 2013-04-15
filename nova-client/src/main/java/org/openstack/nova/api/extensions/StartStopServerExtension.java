package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.ServerAction.Start;
import org.openstack.nova.model.ServerAction.Stop;

public class StartStopServerExtension {

	public class StartServer implements OpenStackCommand<Void> {
		
		private Start action;

		private String id;
		
		public StartServer(String id) {
			this.id = id;
			this.action = new Start();
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.POST);
		    request.path("/servers/").path(id).path("/action");
		    request.header("Accept", "application/json");
		    request.json(action);
		    
			return null;
		}

	}
	
	public class StopServer implements OpenStackCommand<Void> {
		
		private Stop action;

		private String id;
		
		public StopServer(String id) {
			this.id = id;
			this.action = new Stop();
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.POST);
		    request.path("/servers/").path(id).path("/action");
		    request.header("Accept", "application/json");
		    request.json(action);
		    
			return null;
		}

	}
	
	public StartServer start(String id) {
		return new StartServer(id);
	}
	
	public StopServer stop(String id) {
		return new StopServer(id);
	}

	
}
