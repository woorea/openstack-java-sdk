package org.openstack.nova.api.extensions;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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
		public Void execute(WebTarget target) {
			target.path("servers").path(id).path("action").request(MediaType.APPLICATION_JSON).post(Entity.json(action));
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
		public Void execute(WebTarget target) {
			target.path("servers").path(id).path("action").request(MediaType.APPLICATION_JSON).post(Entity.json(action));
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
