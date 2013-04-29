package org.openstack.nova.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Metadata;
import org.openstack.nova.model.Server;
import org.openstack.nova.model.Server.Addresses;
import org.openstack.nova.model.ServerAction.ChangePassword;
import org.openstack.nova.model.ServerAction.ConfirmResize;
import org.openstack.nova.model.ServerAction.CreateImage;
import org.openstack.nova.model.ServerAction.Reboot;
import org.openstack.nova.model.ServerAction.Rebuild;
import org.openstack.nova.model.ServerAction.Resize;
import org.openstack.nova.model.ServerAction.RevertResize;
import org.openstack.nova.model.ServerForCreate;
import org.openstack.nova.model.Servers;

public class ServersCore {

	public static class ListServers extends OpenStackRequest {

		public ListServers(boolean detail) {
			method(HttpMethod.GET);
			path(detail ? "servers/detail" : "/servers");
			header("Accept", "application/json");
			returnType(Servers.class);
		}

		public ListServers() {
			this(false);
		}

	}

	public static class CreateServer extends OpenStackRequest {

		private ServerForCreate serverForCreate;

		public CreateServer(ServerForCreate serverForCreate) {
			this.serverForCreate = serverForCreate;
			
			method(HttpMethod.POST);
			path("/servers");
			header("Accept", "application/json");
			json(serverForCreate);
			returnType(Server.class);
		}

	}

	public static class ShowServer extends OpenStackRequest {

		public ShowServer(String id) {
			method(HttpMethod.GET);
			path("/servers/").path(id);
			header("Accept", "application/json");
			returnType(Server.class);
		}

	}

	public static class ShowServerMetadata extends OpenStackRequest {

		public ShowServerMetadata(String id) {
			method(HttpMethod.GET);
			path("/servers/").path(id).path("metadata");
			header("Accept", "application/json");
			returnType(Metadata.class);
		}

	}

	public static class ShowServerAddresses extends OpenStackRequest {

		public ShowServerAddresses(String id) {
			method(HttpMethod.GET);
			path("/servers/").path(id).path("ips");
			header("Accept", "application/json");
			returnType(Addresses.class);
		}

	}

	public static class UpdateServer extends OpenStackRequest {

		private Server server;

		public UpdateServer(Server server) {
			this.server = server;
			
			method(HttpMethod.PUT);
			path("/servers/").path(server.getId());
			header("Accept", "application/json");
			json(server);
			returnType(Server.class);
		}

	}

	public static class DeleteServer extends OpenStackRequest {

		private String id;

		public DeleteServer(String id) {
			method(HttpMethod.DELETE);
			path("/servers/").path(id);
			header("Accept", "application/json");
		}

	}

	public static class ChangePasswordServer extends OpenStackRequest {

		private ChangePassword action;

		public ChangePasswordServer(String id, ChangePassword action) {
			this.action = action;
			
			method(HttpMethod.POST);
			path("/servers/").path(id).path("/action");
			header("Accept", "application/json");
			json(action);
			returnType(Server.class);
		}

	}

	public static class RebootServer extends OpenStackRequest {

		private Reboot action;

		private String id;

		public RebootServer(String id, Reboot action) {
			this.action = action;
			
			method(HttpMethod.POST);
			path("/servers/").path(id).path("/action");
			header("Accept", "application/json");
			json(action);
			returnType(Server.class);
		}

	}

	public static class RebuildServer extends OpenStackRequest {

		private final Rebuild action;

		public RebuildServer(String id, Rebuild action) {
			this.action = action;
			
			method(HttpMethod.POST);
			path("/servers/").path(id).path("/action");
			header("Accept", "application/json");
			json(action);
			returnType(Server.class);
		}

	}

	public static class ResizeServer extends OpenStackRequest {

		private final Resize action;

		public ResizeServer(String id, Resize action) {
			this.action = action;
			
			method(HttpMethod.POST);
			path("/servers/").path(id).path("/action");
			header("Accept", "application/json");
			json(action);
			returnType(Server.class);
		}

	}

	public static class ConfirmResizeServer extends OpenStackRequest {

		private static final ConfirmResize ACTION = new ConfirmResize();

		public ConfirmResizeServer(String id) {
			method(HttpMethod.POST);
			path("/servers/").path(id).path("/action");
			header("Accept", "application/json");
			json(ACTION);
			returnType(Server.class);
		}

	}

	public static class RevertResizeServer extends OpenStackRequest {

		private static final RevertResize ACTION = new RevertResize();

		public RevertResizeServer(String id) {
			method(HttpMethod.POST);
			path("/servers/").path(id).path("/action");
			header("Accept", "application/json");
			json(ACTION);
			returnType(Server.class);
		}

	}

	public static class CreateImageServer extends OpenStackRequest {

		private CreateImage action;

		public CreateImageServer(String id, CreateImage action) {
			this.action = action;
			
			method(HttpMethod.POST);
			path("/servers/").path(id).path("/action");
			header("Accept", "application/json");
			json(action);
			returnType(Server.class);
		}

	}

	public static ListServers listServers(boolean detail) {
		return new ListServers(detail);
	}

	public static ListServers listServers() {
		return listServers(false);
	}

	public static CreateServer createServer(ServerForCreate serverForCreate) {
		return new CreateServer(serverForCreate);
	}

	public static ShowServer showServer(String id) {
		return new ShowServer(id);
	}

	public static ShowServerMetadata showServerMetadata(String id) {
		return new ShowServerMetadata(id);
	}

	public static ShowServerAddresses showServerAddresses(String id) {
		return new ShowServerAddresses(id);
	}

	public static DeleteServer deleteServer(String id) {
		return new DeleteServer(id);
	}

	public static ChangePasswordServer changePassword(String id,
			String adminPass) {
		ChangePassword changePassword = new ChangePassword(adminPass);
		return new ChangePasswordServer(id, changePassword);
	}

	public static RebootServer reboot(String id, String type) {
		Reboot action = new Reboot();
		action.setType(type);
		return new RebootServer(id, action);
	}

	public static RebuildServer rebuild(String id, Rebuild rebuild) {
		return new RebuildServer(id, rebuild);
	}

	public static ResizeServer resize(String id, Resize action) {
		return new ResizeServer(id, action);
	}

	public static RevertResizeServer revertResize(String id) {
		return new RevertResizeServer(id);
	}

	public static ConfirmResizeServer confirmResize(String id) {
		return new ConfirmResizeServer(id);
	}

	public static CreateImageServer createImageServer(String id,
			CreateImage action) {
		return new CreateImageServer(id, action);
	}

}
