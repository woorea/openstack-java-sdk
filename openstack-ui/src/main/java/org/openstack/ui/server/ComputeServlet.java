package org.openstack.ui.server;

import java.util.Collection;
import java.util.List;

import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaFlavorList;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaImageList;
import org.openstack.model.compute.NovaKeyPair;
import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.compute.NovaServer;
import org.openstack.model.compute.NovaServerForCreate;
import org.openstack.model.compute.NovaServerList;
import org.openstack.model.compute.NovaSnapshotList;
import org.openstack.model.compute.NovaVolumeList;
import org.openstack.model.compute.server.action.Console;
import org.openstack.model.compute.server.action.GetConsoleOutputAction;
import org.openstack.model.compute.server.action.GetVncConsoleAction;
import org.openstack.ui.client.api.ComputeService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ComputeServlet extends RemoteServiceServlet implements ComputeService {
	
	private ComputeService service = new ComputeServiceImpl();

	public NovaSecurityGroup showSecurityGroup(String computeURL, String token,
			Integer id) {
		return service.showSecurityGroup(computeURL, token, id);
	}

	@Override
	public NovaServerList listServers(String token, String tenantId) {
		return service.listServers(token, tenantId);
	}
	
	@Override
	public NovaServer showServer(String computeURL, String token, String id) {
		return service.showServer(computeURL, token, id);
	}
	
	@Override
	public NovaServer saveServer(String computeURL, String token, NovaServerForCreate serverForCreate) {
		return service.saveServer(computeURL, token, serverForCreate);
	}
	
	@Override
	public void deleteServer(String computeURL, String token, String id) {
		service.deleteServer(computeURL, token, id);
	}
	
	public void restoreServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.restoreServer(computeURL, token, servers);
	}

	public void forceDeleteServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.forceDeleteServer(computeURL, token, servers);
	}

	public void changePasswordServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.changePasswordServer(computeURL, token, servers);
	}

	public void rebuildServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.rebuildServer(computeURL, token, servers);
	}

	public void resizeServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.resizeServer(computeURL, token, servers);
	}

	public void revertResizeServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.revertResizeServer(computeURL, token, servers);
	}

	public void createImageServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.createImageServer(computeURL, token, servers);
	}

	public void pauseServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.pauseServer(computeURL, token, servers);
	}

	public void unpauseServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.unpauseServer(computeURL, token, servers);
	}

	public void suspendServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.suspendServer(computeURL, token, servers);
	}

	public void resumeServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.resumeServer(computeURL, token, servers);
	}

	public void migrateServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.migrateServer(computeURL, token, servers);
	}

	public void resetNetworkServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.resetNetworkServer(computeURL, token, servers);
	}

	public void injectNetworkInfoServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.injectNetworkInfoServer(computeURL, token, servers);
	}

	public void lockServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.lockServer(computeURL, token, servers);
	}

	public void unlockServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		service.unlockServer(computeURL, token, servers);
	}

	public Console getVncConsole(String computeURL, String token,
			String serverId, GetVncConsoleAction action) {
		return service.getVncConsole(computeURL, token, serverId, action);
	}

	public String getConsoleOutput(String computeURL, String token,
			String serverId, GetConsoleOutputAction action) {
		return service.getConsoleOutput(computeURL, token, serverId, action);
	}


	@Override
	public NovaImageList listImages(String token, String tenantId) {
		return service.listImages(token, tenantId);
	}

	@Override
	public NovaFlavorList listFlavors(String token, String tenantId) {
		return service.listFlavors(token, tenantId);
	}

	@Override
	public List<NovaKeyPair> listKeyPairs(String token, String tenantId) {
		return service.listKeyPairs(token, tenantId);
	}

	@Override
	public List<NovaSecurityGroup> listSecurityGroups(String token,
			String tenantId) {
		return service.listSecurityGroups(token, tenantId);
	}

	@Override
	public NovaVolumeList listVolumes(String computeURL, String token) {
		return service.listVolumes(computeURL, token);
	}

	@Override
	public NovaSnapshotList listSnapshots(String computeURL, String token) {
		return service.listSnapshots(computeURL, token);
	}

	@Override
	public NovaImage showImage() {
		return service.showImage();
	}

	@Override
	public NovaFlavor showFlavor() {
		return service.showFlavor();
	}

}
