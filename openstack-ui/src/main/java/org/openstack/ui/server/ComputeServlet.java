package org.openstack.ui.server;

import java.util.Collection;
import java.util.List;

import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaFlavorList;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaImageList;
import org.openstack.model.compute.NovaKeyPairList;
import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.compute.NovaSecurityGroupList;
import org.openstack.model.compute.NovaServer;
import org.openstack.model.compute.NovaServerForCreate;
import org.openstack.model.compute.NovaServerList;
import org.openstack.model.compute.NovaSnapshotList;
import org.openstack.model.compute.NovaVolumeList;
import org.openstack.model.compute.server.action.Console;
import org.openstack.model.compute.server.action.GetConsoleOutputAction;
import org.openstack.model.compute.server.action.GetVncConsoleAction;
import org.openstack.ui.client.api.ComputeService;

@SuppressWarnings("serial")
public class ComputeServlet extends OpenStackRemoteServiceServlet implements ComputeService {

	public NovaSecurityGroup showSecurityGroup(Integer id) {
		return getClient().compute().getPublicEndpoint().securityGroups().securityGroup(id).get();
	}

	@Override
	public NovaServerList listServers() {
		return getClient().compute().getPublicEndpoint().servers().get();
	}
	
	@Override
	public NovaServer showServer(String id) {
		return getClient().compute().getPublicEndpoint().servers().server(id).get();
	}
	
	@Override
	public NovaServer saveServer(NovaServerForCreate serverForCreate) {
		return getClient().compute().getPublicEndpoint().servers().post(serverForCreate);
	}
	
	@Override
	public void deleteServer(String id) {
		getClient().compute().getPublicEndpoint().servers().server(id).delete();
	}
	
	public void restoreServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void forceDeleteServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void changePasswordServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void rebuildServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void resizeServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void revertResizeServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void createImageServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void pauseServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void unpauseServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void suspendServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void resumeServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void migrateServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void resetNetworkServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void injectNetworkInfoServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void lockServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public void unlockServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getClient().compute().getPublicEndpoint().servers().server("").restore();
		}
	}

	public Console getVncConsole(String serverId, GetVncConsoleAction action) {
		
		return getClient().compute().getPublicEndpoint().servers().server(serverId).executeAction(Console.class, action);
		
	}

	public String getConsoleOutput(String serverId, GetConsoleOutputAction action) {
		
		return getClient().compute().getPublicEndpoint().servers().server(serverId).executeAction(String.class, action);
		
	}


	@Override
	public NovaImageList listImages() {
		return getClient().compute().getPublicEndpoint().images().get();
	}

	@Override
	public NovaFlavorList listFlavors() {
		return getClient().compute().getPublicEndpoint().flavors().get();
	}

	@Override
	public NovaKeyPairList listKeyPairs() {
		return getClient().compute().getPublicEndpoint().keyPairs().get();
	}

	@Override
	public NovaSecurityGroupList listSecurityGroups() {
		return getClient().compute().getPublicEndpoint().securityGroups().get();
	}

	@Override
	public NovaVolumeList listVolumes() {
		return getClient().compute().getPublicEndpoint().volumes().get();
	}

	@Override
	public NovaSnapshotList listSnapshots() {
		return new NovaSnapshotList();
	}

	public NovaImage showImage(String id) {
		return getClient().compute().getPublicEndpoint().images().image(id).get();
	}

	public NovaFlavor showFlavor(String id) {
		return getClient().compute().getPublicEndpoint().flavors().flavor(id).get();
	}

	

}
