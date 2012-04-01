package org.openstack.ui.client.api;

import java.util.Collection;

import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.FlavorList;
import org.openstack.model.compute.FloatingIp;
import org.openstack.model.compute.FloatingIpList;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.ImageList;
import org.openstack.model.compute.KeyPairList;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupForCreate;
import org.openstack.model.compute.SecurityGroupList;
import org.openstack.model.compute.SecurityGroupRule;
import org.openstack.model.compute.SecurityGroupRuleForCreate;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerList;
import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.SnapshotForCreate;
import org.openstack.model.compute.SnapshotList;
import org.openstack.model.compute.Volume;
import org.openstack.model.compute.VolumeList;
import org.openstack.model.compute.nova.NovaServerForCreate;
import org.openstack.model.compute.nova.server.actions.Console;
import org.openstack.model.compute.nova.server.actions.GetConsoleOutputAction;
import org.openstack.model.compute.nova.server.actions.GetVncConsoleAction;
import org.openstack.model.compute.nova.volume.NovaVolumeAttachment;
import org.openstack.model.compute.nova.volume.VolumeForCreate;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ComputeServiceAsync {

	void attachVolume(String serverId, NovaVolumeAttachment attachment,
			AsyncCallback<Void> callback);

	void changePasswordServer(Collection<Server> servers,
			AsyncCallback<Void> callback);

	void createFloatingIp(String pool, AsyncCallback<FloatingIp> callback);

	void createImageServer(Collection<Server> servers,
			AsyncCallback<Void> callback);

	void createVolume(VolumeForCreate volume, AsyncCallback<Volume> callback);

	void deleteFloatingIp(Integer id, AsyncCallback<Void> callback);

	void deleteServer(String id, AsyncCallback<Void> callback);

	void deleteVolume(Integer id, AsyncCallback<Void> callback);

	void detachVolume(String serverId, Integer volumeId,
			AsyncCallback<Void> callback);

	void forceDeleteServer(Collection<Server> servers,
			AsyncCallback<Void> callback);

	void getConsoleOutput(String serverId, GetConsoleOutputAction action,
			AsyncCallback<String> callback);

	void getVncConsole(String serverId, GetVncConsoleAction action,
			AsyncCallback<Console> callback);

	void injectNetworkInfoServer(Collection<Server> servers,
			AsyncCallback<Void> callback);

	void listFlavors(AsyncCallback<FlavorList> callback);

	void listFloatingIps(AsyncCallback<FloatingIpList> callback);

	void listImages(AsyncCallback<ImageList> callback);

	void listKeyPairs(AsyncCallback<KeyPairList> callback);

	void listSecurityGroups(AsyncCallback<SecurityGroupList> callback);

	void listServers(AsyncCallback<ServerList> callback);

	void listSnapshots(AsyncCallback<SnapshotList> callback);

	void listVolumes(AsyncCallback<VolumeList> callback);

	void lockServer(Collection<Server> servers, AsyncCallback<Void> callback);

	void migrateServer(Collection<Server> servers, AsyncCallback<Void> callback);

	void pauseServer(Collection<Server> servers, AsyncCallback<Void> callback);

	void rebuildServer(Collection<Server> servers, AsyncCallback<Void> callback);

	void resetNetworkServer(Collection<Server> servers,
			AsyncCallback<Void> callback);

	void resizeServer(Collection<Server> servers, AsyncCallback<Void> callback);

	void restoreServer(Collection<Server> servers, AsyncCallback<Void> callback);

	void resumeServer(Collection<Server> servers, AsyncCallback<Void> callback);

	void revertResizeServer(Collection<Server> servers,
			AsyncCallback<Void> callback);

	void saveServer(NovaServerForCreate serverForCreate,
			AsyncCallback<Server> callback);

	void showFlavor(String id, AsyncCallback<Flavor> callback);

	void showImage(String id, AsyncCallback<Image> callback);

	void showSecurityGroup(Integer id, AsyncCallback<SecurityGroup> callback);

	void showServer(String id, AsyncCallback<Server> callback);

	void suspendServer(Collection<Server> servers, AsyncCallback<Void> callback);

	void unlockServer(Collection<Server> servers, AsyncCallback<Void> callback);

	void unpauseServer(Collection<Server> servers, AsyncCallback<Void> callback);

	void associateFloatingIp(String serverId, String address, AsyncCallback<Void> defaultAsyncCallback);
	
	void disassociateFloatingIp(String serverId, String address, AsyncCallback<Void> defaultAsyncCallback);

	void createSnapshot(SnapshotForCreate snapshot,
			AsyncCallback<Snapshot> callback);

	void deleteSnapshot(Integer id, AsyncCallback<Void> callback);

	void deleteSecurityGroup(Integer id, AsyncCallback<Void> callback);

	void getEndpointURL(AsyncCallback<String> callback);

	void deleteKeyPair(String name,
			AsyncCallback<Void> defaultAsyncCallback);

	void createSecurityGroup(SecurityGroupForCreate securityGroup,
			AsyncCallback<SecurityGroup> callback);

	void createSecurityGroupRule(SecurityGroupRuleForCreate securityGroupRule,
			AsyncCallback<SecurityGroupRule> callback);

}
