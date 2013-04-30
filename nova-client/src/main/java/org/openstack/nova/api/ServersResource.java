package org.openstack.nova.api;

import org.openstack.base.client.Entity;
import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Metadata;
import org.openstack.nova.model.Server;
import org.openstack.nova.model.ServerForCreate;
import org.openstack.nova.model.Server.Addresses;
import org.openstack.nova.model.ServerAction.ChangePassword;
import org.openstack.nova.model.ServerAction.ConfirmResize;
import org.openstack.nova.model.ServerAction.CreateImage;
import org.openstack.nova.model.ServerAction.Reboot;
import org.openstack.nova.model.ServerAction.Rebuild;
import org.openstack.nova.model.ServerAction.Resize;
import org.openstack.nova.model.ServerAction.RevertResize;
import org.openstack.nova.model.Servers;

public class ServersResource {
	
	private final OpenStackClient CLIENT;
	
	public ServersResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list(boolean detail) {
		return new List(detail);
	}
	
	public Boot boot(ServerForCreate server) {
		return new Boot(server);
	}
	
	public Show show(String id) {
		return new Show(id);
	}
	
	public ShowMetadata showMetadata(String id) {
		return new ShowMetadata(id);
	}

	
	public Delete delete(String id) {
		return new Delete(id);
	}

	public class List extends OpenStackRequest<Servers> {
		
		public List(boolean detail) {
			super(CLIENT, HttpMethod.GET, detail ? "/servers/detail" : "/servers", null, Servers.class);
		}

	}
	
	public class Boot extends OpenStackRequest<Server> {

		private ServerForCreate server;
		
		public Boot(ServerForCreate server) {
			super(CLIENT, HttpMethod.POST, "/servers", Entity.json(server), Server.class);
			this.server = server;
		}
		
	}
	
	public class Show extends OpenStackRequest<Server> {
		
		public Show(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/").append(id).toString(), null, Server.class);
		}

	}
	
	public class ShowMetadata extends OpenStackRequest<Metadata> {
		
		public ShowMetadata(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/").append(id).append("/metadata").toString(), null, Metadata.class);
		}

	}
	
	public class Delete extends OpenStackRequest<Void> {
		
		public Delete(String id) {
			super(CLIENT, HttpMethod.DELETE, new StringBuilder("/servers/").append(id).toString(), null, Void.class);
		}
		
	}
	
	public class ShowServerAddresses extends OpenStackRequest<Addresses> {

		public ShowServerAddresses(String id) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/").append(id).append("/ips").toString(), null, Addresses.class);
		}

	}

	public class UpdateServer extends OpenStackRequest {

		private Server server;
		
		public UpdateServer(String id, Server server) {
			super(CLIENT, HttpMethod.PUT, new StringBuilder("/servers/").append(id).toString(), Entity.json(server), Server.class);
			this.server = server;
		}

	}
	
	public abstract class Action<T> extends OpenStackRequest<T> {

		public Action(String id, Entity<?> entity, Class<T> returnType) {
			super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/").append(id).append("/action").toString(), entity, returnType);
		}

	}

	public class ChangePasswordAction extends Action<Server> {

		private ChangePassword action;

		public ChangePasswordAction(String id, ChangePassword action) {
			super(id, Entity.json(action), Server.class);
		}

	}

	public class RebootAction extends Action<Server> {

		private Reboot action;

		public RebootAction(String id, ChangePassword action) {
			super(id, Entity.json(action), Server.class);
		}

	}
	
	public class RebuildAction extends Action<Server> {

		private Rebuild action;

		public RebuildAction(String id, Rebuild action) {
			super(id, Entity.json(action), Server.class);
		}

	}

	public class ResizeAction extends Action<Server> {

		private Resize action;

		public ResizeAction(String id, Resize action) {
			super(id, Entity.json(action), Server.class);
		}

	}
	
	public class ConfirmResizeAction extends Action<Server> {

		public ConfirmResizeAction(String id) {
			super(id, Entity.json(new ConfirmResize()), Server.class);
		}

	}
	
	public class ReverResizeAction extends Action<Server> {

		public ReverResizeAction(String id) {
			super(id, Entity.json(new RevertResize()), Server.class);
		}

	}
	
	public class CreateImageAction extends Action<Server> {

		private CreateImage action;
		
		public CreateImageAction(String id) {
			super(id, Entity.json(new CreateImage()), Server.class);
		}

	}

	
}

