package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.ServerAction.CreateBackup;
import org.openstack.nova.model.ServerAction.Lock;
import org.openstack.nova.model.ServerAction.Pause;
import org.openstack.nova.model.ServerAction.Resume;
import org.openstack.nova.model.ServerAction.Suspend;
import org.openstack.nova.model.ServerAction.Unlock;
import org.openstack.nova.model.ServerAction.Unpause;

public class ServerAdminActionsExtension {
	
	public class PauseServer implements NovaCommand<Void> {
		
		private Pause action;

		private String id;
		
		public PauseServer(String id) {
			this.id = id;
			this.action = new Pause();
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
	
	public class UnpauseServer implements NovaCommand<Void> {
		
		private Unpause action;

		private String id;
		
		public UnpauseServer(String id) {
			this.id = id;
			this.action = new Unpause();
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

	public class LockServer implements NovaCommand<Void> {
		
		private Lock action;

		private String id;
		
		public LockServer(String id) {
			this.id = id;
			this.action = new Lock();
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

	public class UnlockServer implements NovaCommand<Void> {
		
		private Unlock action;

		private String id;
		
		public UnlockServer(String id) {
			this.id = id;
			this.action = new Unlock();
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

	public class SuspendServer implements NovaCommand<Void> {
		
		private Suspend action;

		private String id;
		
		public SuspendServer(String id) {
			this.id = id;
			this.action = new Suspend();
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

	public class ResumeServer implements NovaCommand<Void> {
		
		private Resume action;

		private String id;
		
		public ResumeServer(String id) {
			this.id = id;
			this.action = new Resume();
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

	public class CreateBackupServer implements NovaCommand<Void> {
		
		private	CreateBackup action;

		private String id;
		
		public CreateBackupServer(String id, CreateBackup action) {
			this.id = id;
			this.action = action;
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
