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
		return getSession().getComputeClient().root().securityGroups().securityGroup(id).show();
	}

	@Override
	public NovaServerList listServers() {
		return getSession().getComputeClient().root().servers().list();
	}
	
	@Override
	public NovaServer showServer(String id) {
		return getSession().getComputeClient().root().servers().server(id).show();
	}
	
	@Override
	public NovaServer saveServer(NovaServerForCreate serverForCreate) {
		return getSession().getComputeClient().root().servers().create(serverForCreate);
	}
	
	@Override
	public void deleteServer(String id) {
		getSession().getComputeClient().root().servers().server(id).delete();
	}
	
	public void restoreServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void forceDeleteServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void changePasswordServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void rebuildServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void resizeServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void revertResizeServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void createImageServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void pauseServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void unpauseServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void suspendServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void resumeServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void migrateServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void resetNetworkServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void injectNetworkInfoServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void lockServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public void unlockServer(Collection<NovaServer> servers) {
		for(NovaServer s : servers) {
			getSession().getComputeClient().root().servers().server("").restore();
		}
	}

	public Console getVncConsole(String serverId, GetVncConsoleAction action) {
		
		return getSession().getComputeClient().root().servers().server(serverId).executeAction(Console.class, action);
		
	}

	public String getConsoleOutput(String serverId, GetConsoleOutputAction action) {
		
		return getSession().getComputeClient().root().servers().server(serverId).executeAction(String.class, action);
		
	}


	@Override
	public NovaImageList listImages() {
		return getSession().getComputeClient().root().images().list();
	}

	@Override
	public NovaFlavorList listFlavors() {
		return getSession().getComputeClient().root().flavors().list();
	}

	@Override
	public NovaKeyPairList listKeyPairs() {
		return getSession().getComputeClient().root().keyPairs().list();
	}

	@Override
	public NovaSecurityGroupList listSecurityGroups() {
		return getSession().getComputeClient().root().securityGroups().list();
	}

	@Override
	public NovaVolumeList listVolumes() {
		return getSession().getComputeClient().root().volumes().list(true);
	}

	@Override
	public NovaSnapshotList listSnapshots() {
		return new NovaSnapshotList();
	}

	public NovaImage showImage(String id) {
		return getSession().getComputeClient().root().images().image(id).show();
	}

	public NovaFlavor showFlavor(String id) {
		return getSession().getComputeClient().root().flavors().flavor(id).show();
	}

	

}
