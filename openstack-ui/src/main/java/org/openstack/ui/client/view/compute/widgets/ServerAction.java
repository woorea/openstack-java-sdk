package org.openstack.ui.client.view.compute.widgets;

import java.util.Collection;

import org.openstack.model.compute.Server;
import org.openstack.model.compute.nova.server.actions.Console;
import org.openstack.model.compute.nova.server.actions.GetConsoleOutputAction;
import org.openstack.model.compute.nova.server.actions.GetVncConsoleAction;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.user.client.rpc.AsyncCallback;


public enum ServerAction {
	RESTORE {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.restoreServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	FORCE_DELETE {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.forceDeleteServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	CHANGE_PASSWORD {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.changePasswordServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	REBUILD {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.rebuildServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	RESIZE {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.resizeServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	CONFIRM_RESIZE {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.forceDeleteServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	REVERT_RESIZE {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.revertResizeServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	CREATE_IMAGE {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.createImageServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	PAUSE {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.pauseServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	UNPAUSE {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.unpauseServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	SUSPEND {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.suspendServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	RESUME {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.resumeServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	MIGRATE {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.migrateServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	RESET_NETWORK {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.resetNetworkServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	INJECT_NETWORK_INFO {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.injectNetworkInfoServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	LOCK {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.lockServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	UNLOCK {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.unlockServer(servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	GET_VNC_CONSOLE {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			if (servers.size() > 0) {
				OpenStackClient.COMPUTE.getVncConsole(servers.iterator().next().getId(), new GetVncConsoleAction(), (AsyncCallback<Console>) callback);
			}
		}

	},
	GET_CONSOLE_OUTPUT {

		@Override
		public void execute(Collection<Server> servers, AsyncCallback<?> callback) {
			if (servers.size() > 0) {
				OpenStackClient.COMPUTE.getConsoleOutput(servers.iterator().next().getId(), new GetConsoleOutputAction(), (AsyncCallback<String>) callback);
			}
		}

	};

	public abstract void execute(Collection<Server> servers, AsyncCallback<?> callback);

}
