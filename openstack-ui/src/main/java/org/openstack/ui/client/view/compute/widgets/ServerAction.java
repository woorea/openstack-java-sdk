package org.openstack.ui.client.view.compute.widgets;

import java.util.Collection;

import org.openstack.model.compute.NovaServer;
import org.openstack.model.compute.server.action.Console;
import org.openstack.model.compute.server.action.GetConsoleOutputAction;
import org.openstack.model.compute.server.action.GetVncConsoleAction;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.user.client.rpc.AsyncCallback;


public enum ServerAction {
	RESTORE {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.restoreServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	FORCE_DELETE {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.forceDeleteServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	CHANGE_PASSWORD {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.changePasswordServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	REBUILD {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.rebuildServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	RESIZE {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.resizeServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	CONFIRM_RESIZE {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.forceDeleteServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	REVERT_RESIZE {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.revertResizeServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	CREATE_IMAGE {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.createImageServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	PAUSE {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.pauseServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	UNPAUSE {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.unpauseServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	SUSPEND {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.suspendServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	RESUME {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.resumeServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	MIGRATE {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.migrateServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	RESET_NETWORK {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.resetNetworkServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	INJECT_NETWORK_INFO {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.injectNetworkInfoServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	LOCK {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.lockServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	UNLOCK {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			OpenStackClient.COMPUTE.unlockServer(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers, (DefaultAsyncCallback<Void>) callback);

		}

	},
	GET_VNC_CONSOLE {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			if (servers.size() > 0) {
				OpenStackClient.COMPUTE.getVncConsole(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers.iterator().next().getId(), new GetVncConsoleAction(), (AsyncCallback<Console>) callback);
			}
		}

	},
	GET_CONSOLE_OUTPUT {

		@Override
		public void execute(Collection<NovaServer> servers, AsyncCallback<?> callback) {
			if (servers.size() > 0) {
				OpenStackClient.COMPUTE.getConsoleOutput(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), servers.iterator().next().getId(), new GetConsoleOutputAction(), (AsyncCallback<String>) callback);
			}
		}

	};

	public abstract void execute(Collection<NovaServer> servers, AsyncCallback<?> callback);

}
