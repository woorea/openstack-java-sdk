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

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ComputeServiceAsync {

	void changePasswordServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void createImageServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void deleteServer(String id, AsyncCallback<Void> callback);

	void forceDeleteServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void getConsoleOutput(String serverId, GetConsoleOutputAction action,
			AsyncCallback<String> callback);

	void getVncConsole(String serverId, GetVncConsoleAction action,
			AsyncCallback<Console> callback);

	void injectNetworkInfoServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void listFlavors(AsyncCallback<NovaFlavorList> callback);

	void listImages(AsyncCallback<NovaImageList> callback);

	void listKeyPairs(AsyncCallback<NovaKeyPairList> callback);

	void listSecurityGroups(AsyncCallback<NovaSecurityGroupList> callback);

	void listServers(AsyncCallback<NovaServerList> callback);

	void listSnapshots(AsyncCallback<NovaSnapshotList> callback);

	void listVolumes(AsyncCallback<NovaVolumeList> callback);

	void lockServer(Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void migrateServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void pauseServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void rebuildServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void resetNetworkServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void resizeServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void restoreServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void resumeServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void revertResizeServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void saveServer(NovaServerForCreate serverForCreate,
			AsyncCallback<NovaServer> callback);

	void showFlavor(String id, AsyncCallback<NovaFlavor> callback);

	void showImage(String id, AsyncCallback<NovaImage> callback);

	void showSecurityGroup(Integer id, AsyncCallback<NovaSecurityGroup> callback);

	void showServer(String id, AsyncCallback<NovaServer> callback);

	void suspendServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void unlockServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

	void unpauseServer(Collection<NovaServer> servers,
			AsyncCallback<Void> callback);

}
