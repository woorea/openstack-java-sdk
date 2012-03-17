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

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ComputeServiceAsync {

	void changePasswordServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void createImageServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void deleteServer(String computeURL, String token, String id,
			AsyncCallback<Void> callback);

	void forceDeleteServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void getConsoleOutput(String computeURL, String token, String serverId,
			GetConsoleOutputAction action, AsyncCallback<String> callback);

	void getVncConsole(String computeURL, String token, String serverId,
			GetVncConsoleAction action, AsyncCallback<Console> callback);

	void injectNetworkInfoServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void listFlavors(String computeURL, String token,
			AsyncCallback<NovaFlavorList> callback);

	void listImages(String computeURL, String token,
			AsyncCallback<NovaImageList> callback);

	void listKeyPairs(String computeURL, String token,
			AsyncCallback<List<NovaKeyPair>> callback);

	void listSecurityGroups(String computeURL, String token,
			AsyncCallback<List<NovaSecurityGroup>> callback);

	void listServers(String computeURL, String token,
			AsyncCallback<NovaServerList> callback);

	void listSnapshots(String computeURL, String token,
			AsyncCallback<NovaSnapshotList> callback);

	void listVolumes(String computeURL, String token,
			AsyncCallback<NovaVolumeList> callback);

	void lockServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void migrateServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void pauseServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void rebuildServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void resetNetworkServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void resizeServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void restoreServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void resumeServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void revertResizeServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void saveServer(String computeURL, String token,
			NovaServerForCreate serverForCreate,
			AsyncCallback<NovaServer> callback);

	void showFlavor(String computeURL, String token, String id,
			AsyncCallback<NovaFlavor> callback);

	void showImage(String computeURL, String token, String id,
			AsyncCallback<NovaImage> callback);

	void showSecurityGroup(String computeURL, String token, Integer id,
			AsyncCallback<NovaSecurityGroup> callback);

	void showServer(String computeURL, String token, String id,
			AsyncCallback<NovaServer> callback);

	void suspendServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void unlockServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

	void unpauseServer(String computeURL, String token,
			Collection<NovaServer> servers, AsyncCallback<Void> callback);

}
