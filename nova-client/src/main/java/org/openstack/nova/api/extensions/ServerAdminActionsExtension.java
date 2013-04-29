package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.ServerAction.CreateBackup;
import org.openstack.nova.model.ServerAction.Lock;
import org.openstack.nova.model.ServerAction.Pause;
import org.openstack.nova.model.ServerAction.Resume;
import org.openstack.nova.model.ServerAction.Suspend;
import org.openstack.nova.model.ServerAction.Unlock;
import org.openstack.nova.model.ServerAction.Unpause;

public class ServerAdminActionsExtension {
	
	public class PauseServer extends OpenStackRequest {
		
		private Pause action;

		private String id;
		
		public PauseServer(String id) {
			this.id = id;
			this.action = new Pause();
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}
	
	public class UnpauseServer extends OpenStackRequest {
		
		private Unpause action;

		private String id;
		
		public UnpauseServer(String id) {
			this.id = id;
			this.action = new Unpause();
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}


	}

	public class LockServer extends OpenStackRequest {
		
		private Lock action;

		private String id;
		
		public LockServer(String id) {
			this.id = id;
			this.action = new Lock();
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}

	public class UnlockServer extends OpenStackRequest {
		
		private Unlock action;

		private String id;
		
		public UnlockServer(String id) {
			this.id = id;
			this.action = new Unlock();
			
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}

	public class SuspendServer extends OpenStackRequest {
		
		private Suspend action;

		private String id;
		
		public SuspendServer(String id) {
			this.id = id;
			this.action = new Suspend();
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}

	public class ResumeServer extends OpenStackRequest {
		
		private Resume action;

		private String id;
		
		public ResumeServer(String id) {
			this.id = id;
			this.action = new Resume();
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}

	public class CreateBackupServer extends OpenStackRequest {
		
		private	CreateBackup action;

		private String id;
		
		public CreateBackupServer(String id, CreateBackup action) {
			this.id = id;
			this.action = action;
			method(HttpMethod.POST);
		    path("/servers/").path(id).path("/action");
		    header("Accept", "application/json");
		    json(action);
		}

	}
	
	public PauseServer pause(String serverId) {
		return new PauseServer(serverId);
	}
	
	public UnpauseServer unpause(String serverId) {
		return new UnpauseServer(serverId);
	}
	
	public LockServer lock(String serverId) {
		return new LockServer(serverId);
	}
	
	public UnlockServer unlock(String serverId) {
		return new UnlockServer(serverId);
	}
	
	public SuspendServer suspend(String serverId) {
		return new SuspendServer(serverId);
	}
	
	public ResumeServer resume(String serverId) {
		return new ResumeServer(serverId);
	}
	
	public CreateBackupServer createBackup(String serverId, CreateBackup action) {
		return new CreateBackupServer(serverId, action);
	}

}
