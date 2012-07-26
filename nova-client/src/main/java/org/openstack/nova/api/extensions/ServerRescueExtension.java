package org.openstack.nova.api.extensions;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.ServerAction.Rescue;
import org.openstack.nova.model.ServerAction.Unrescue;

public class ServerRescueExtension {

	public class RescueServer implements NovaCommand<Void> {
		
		private Rescue action;

		private String id;
		
		public RescueServer(String id, Rescue action) {
			this.id = id;
			this.action = action;
		}

		@Override
		public Void execute(WebTarget target) {
			target.path("servers").path(id).path("action").request(MediaType.APPLICATION_JSON).post(Entity.json(action));
			return null;
		}

	}

	public class UnrescueServer implements NovaCommand<Void> {
		
		private Unrescue action;

		private String id;
		
		public UnrescueServer(String id) {
			this.id = id;
			this.action = new Unrescue();
		}

		@Override
		public Void execute(WebTarget target) {
			target.path("servers").path(id).path("action").request(MediaType.APPLICATION_JSON).post(Entity.json(action));
			return null;
		}

	}
	
	public RescueServer rescue(String serverId, String adminPass) {
		Rescue action = new Rescue(adminPass);
		return new RescueServer(serverId, action);
	}
	
	public UnrescueServer unrescue(String serverId) {
		return new UnrescueServer(serverId);
	}
}
