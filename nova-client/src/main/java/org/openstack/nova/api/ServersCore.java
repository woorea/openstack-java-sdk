package org.openstack.nova.api;

import java.util.Map;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
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

	public static class ListServers implements NovaCommand<Servers> {

		boolean detail;

		public ListServers(boolean detail) {
			this.detail = detail;
		}

		public ListServers() {
			this(false);
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path(detail ? "servers/detail" : "/servers");
			request.header("Accept", "application/json");
			request.returnType(Servers.class);
			return request;
		}

	}

	public static class CreateServer implements NovaCommand<Server> {

		private ServerForCreate serverForCreate;

		public CreateServer(ServerForCreate serverForCreate) {
			this.serverForCreate = serverForCreate;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.POST);
			request.path("/servers");
			request.header("Accept", "application/json");
			request.json(serverForCreate);
			request.returnType(Server.class);
			return request;
		}

	}

	public static class ShowServer implements NovaCommand<Server> {

		private String id;

		public ShowServer(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/servers/").path(id);
			request.header("Accept", "application/json");
			request.returnType(Server.class);
			return request;
		}

	}

	public static class ShowServerMetadata implements
			NovaCommand<Map<String, String>> {

		private String id;

		public ShowServerMetadata(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/servers/").path(id).path("metadata");
			request.header("Accept", "application/json");
			request.returnType(Metadata.class);
			return request;
		}

	}

	public static class ShowServerAddresses implements
			NovaCommand<Server.Addresses> {

		private String id;

		public ShowServerAddresses(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.GET);
			request.path("/servers/").path(id).path("ips");
			request.header("Accept", "application/json");
			request.returnType(Addresses.class);
			return request;
		}

	}

	public static class UpdateServer implements NovaCommand<Server> {

		private Server server;

		public UpdateServer(Server server) {
			this.server = server;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.PUT);
			request.path("/servers/").path(server.getId());
			request.header("Accept", "application/json");
			request.json(server);
			request.returnType(Server.class);
			return request;
		}

	}

	public static class DeleteServer implements NovaCommand<Void> {

		private String id;

		public DeleteServer(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.DELETE);
			request.path("/servers/").path(id);
			request.header("Accept", "application/json");

			return null;
		}

	}

	public static class ChangePasswordServer implements NovaCommand<Void> {

		private ChangePassword action;

		private String id;

		public ChangePasswordServer(String id, ChangePassword action) {
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
			request.returnType(Server.class);
			return request;
		}

	}

	public static class RebootServer implements NovaCommand<Void> {

		private Reboot action;

		private String id;

		public RebootServer(String id, Reboot action) {
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
			request.returnType(Server.class);
			return request;
		}

	}

	public static class RebuildServer implements NovaCommand<Void> {

		private final Rebuild action;

		private final String id;

		public RebuildServer(String id, Rebuild action) {
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
			request.returnType(Server.class);
			return request;
		}

	}

	public static class ResizeServer implements NovaCommand<Void> {

		private final Resize action;

		private final String id;

		public ResizeServer(String id, Resize action) {
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
			request.returnType(Server.class);
			return request;
		}

	}

	public static class ConfirmResizeServer implements NovaCommand<Void> {

		private static final ConfirmResize ACTION = new ConfirmResize();

		private final String id;

		public ConfirmResizeServer(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.POST);
			request.path("/servers/").path(id).path("/action");
			request.header("Accept", "application/json");
			request.json(ACTION);
			request.returnType(Server.class);
			return request;
		}

	}

	public static class RevertResizeServer implements NovaCommand<Void> {

		private static final RevertResize ACTION = new RevertResize();

		private final String id;

		public RevertResizeServer(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			request.method(HttpMethod.POST);
			request.path("/servers/").path(id).path("/action");
			request.header("Accept", "application/json");
			request.json(ACTION);
			request.returnType(Server.class);
			return request;
		}

	}

	public static class CreateImageServer implements NovaCommand<Void> {

		private CreateImage action;

		private String id;

		public CreateImageServer(String id, CreateImage action) {
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
			request.returnType(Server.class);
			return request;
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
