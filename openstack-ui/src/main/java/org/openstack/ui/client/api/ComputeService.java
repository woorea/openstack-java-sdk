package org.openstack.ui.client.api;

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

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("compute")
public interface ComputeService extends RemoteService {

	NovaServerList listServers(String computeURL, String token);
	
	NovaServer showServer(String computeURL, String token, String id);
	
	NovaServer saveServer(String computeURL, String token, NovaServerForCreate serverForCreate);
	
	void deleteServer(String computeURL, String token, String id);
	
	void restoreServer(String computeURL, String token, Collection<NovaServer> servers);

	void forceDeleteServer(String computeURL, String token, Collection<NovaServer> servers);

	void changePasswordServer(String computeURL, String token, Collection<NovaServer> servers);

	void rebuildServer(String computeURL, String token, Collection<NovaServer> servers);

	void resizeServer(String computeURL, String token, Collection<NovaServer> servers);

	void revertResizeServer(String computeURL, String token, Collection<NovaServer> servers);

	void createImageServer(String computeURL, String token, Collection<NovaServer> servers);

	void pauseServer(String computeURL, String token, Collection<NovaServer> servers);

	void unpauseServer(String computeURL, String token, Collection<NovaServer> servers);

	void suspendServer(String computeURL, String token, Collection<NovaServer> servers);

	void resumeServer(String computeURL, String token, Collection<NovaServer> servers);

	void migrateServer(String computeURL, String token, Collection<NovaServer> servers);

	void resetNetworkServer(String computeURL, String token, Collection<NovaServer> servers);

	void injectNetworkInfoServer(String computeURL, String token, Collection<NovaServer> servers);

	void lockServer(String computeURL, String token, Collection<NovaServer> servers);

	void unlockServer(String computeURL, String token, Collection<NovaServer> servers);

	Console getVncConsole(String computeURL, String token, String serverId, GetVncConsoleAction action);

	String getConsoleOutput(String computeURL, String token, String serverId, GetConsoleOutputAction action);
	
	NovaImageList listImages(String computeURL, String token);
	
	NovaImage showImage(String computeURL, String token, String id);
	
	NovaFlavorList listFlavors(String computeURL, String token);
	
	NovaFlavor showFlavor(String computeURL, String token, String id);
	
	List<NovaKeyPair> listKeyPairs(String computeURL, String token);
	
	List<NovaSecurityGroup> listSecurityGroups(String computeURL, String token);
	
	NovaVolumeList listVolumes(String computeURL, String token);
	
	NovaSnapshotList listSnapshots(String computeURL, String token);

	NovaSecurityGroup showSecurityGroup(String computeURL, String token, Integer id);

	
	
}
