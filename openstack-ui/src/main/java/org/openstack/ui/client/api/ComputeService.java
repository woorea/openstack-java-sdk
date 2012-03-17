package org.openstack.ui.client.api;

import java.util.Collection;
import java.util.List;

import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaFlavorList;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaImageList;
import org.openstack.model.compute.NovaKeyPair;
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

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("compute")
public interface ComputeService extends RemoteService {

	NovaServerList listServers();
	
	NovaServer showServer(String id);
	
	NovaServer saveServer(NovaServerForCreate serverForCreate);
	
	void deleteServer(String id);
	
	void restoreServer(Collection<NovaServer> servers);

	void forceDeleteServer(Collection<NovaServer> servers);

	void changePasswordServer(Collection<NovaServer> servers);

	void rebuildServer(Collection<NovaServer> servers);

	void resizeServer(Collection<NovaServer> servers);

	void revertResizeServer(Collection<NovaServer> servers);

	void createImageServer(Collection<NovaServer> servers);

	void pauseServer(Collection<NovaServer> servers);

	void unpauseServer(Collection<NovaServer> servers);

	void suspendServer(Collection<NovaServer> servers);

	void resumeServer(Collection<NovaServer> servers);

	void migrateServer(Collection<NovaServer> servers);

	void resetNetworkServer(Collection<NovaServer> servers);

	void injectNetworkInfoServer(Collection<NovaServer> servers);

	void lockServer(Collection<NovaServer> servers);

	void unlockServer(Collection<NovaServer> servers);

	Console getVncConsole(String serverId, GetVncConsoleAction action);

	String getConsoleOutput(String serverId, GetConsoleOutputAction action);
	
	NovaImageList listImages();
	
	NovaImage showImage(String id);
	
	NovaFlavorList listFlavors();
	
	NovaFlavor showFlavor(String id);
	
	NovaKeyPairList listKeyPairs();
	
	NovaSecurityGroupList listSecurityGroups();
	
	NovaVolumeList listVolumes();
	
	NovaSnapshotList listSnapshots();

	NovaSecurityGroup showSecurityGroup(Integer id);

	
	
}
