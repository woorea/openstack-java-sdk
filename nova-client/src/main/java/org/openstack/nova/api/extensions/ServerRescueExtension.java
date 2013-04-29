package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.ServerAction.Rescue;
import org.openstack.nova.model.ServerAction.Unrescue;

public class ServerRescueExtension {

	public class RescueServer extends OpenStackRequest {
		
		private Rescue action;

		private String id;
		
		public RescueServer(String id, Rescue action) {
			this.id = id;
			this.action = action;
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}

	public class UnrescueServer extends OpenStackRequest {
		
		private Unrescue action;
		
		public UnrescueServer(String id) {
			
			this.action = new Unrescue();
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
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
