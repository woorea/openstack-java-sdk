package org.openstack.nova.api.extensions;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.ServerAction.Start;
import org.openstack.nova.model.ServerAction.Stop;

public class StartStopServerExtension {

	public class StartServer implements NovaCommand<Void> {
		
		private Start action;

		private String id;
		
		public StartServer(String id) {
			this.id = id;
			this.action = new Start();
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/servers/").path(id).path("/action");
		    request.header("Accept", "application/json");
		    request.json(action);
		    connector.execute(request);
			return null;
		}

	}
	
	public class StopServer implements NovaCommand<Void> {
		
		private Stop action;

		private String id;
		
		public StopServer(String id) {
			this.id = id;
			this.action = new Stop();
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/servers/").path(id).path("/action");
		    request.header("Accept", "application/json");
		    request.json(action);
		    connector.execute(request);
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
