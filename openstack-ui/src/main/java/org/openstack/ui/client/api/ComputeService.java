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
import org.openstack.model.compute.SecurityGroupList;
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

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("compute")
public interface ComputeService extends RemoteService {

	ServerList listServers();
	
	Server showServer(String id);
	
	Server saveServer(NovaServerForCreate serverForCreate);
	
	void deleteServer(String id);
	
	void restoreServer(Collection<Server> servers);

	void forceDeleteServer(Collection<Server> servers);

	void changePasswordServer(Collection<Server> servers);

	void rebuildServer(Collection<Server> servers);

	void resizeServer(Collection<Server> servers);

	void revertResizeServer(Collection<Server> servers);

	void createImageServer(Collection<Server> servers);

	void pauseServer(Collection<Server> servers);

	void unpauseServer(Collection<Server> servers);

	void suspendServer(Collection<Server> servers);

	void resumeServer(Collection<Server> servers);

	void migrateServer(Collection<Server> servers);

	void resetNetworkServer(Collection<Server> servers);

	void injectNetworkInfoServer(Collection<Server> servers);

	void lockServer(Collection<Server> servers);

	void unlockServer(Collection<Server> servers);

	Console getVncConsole(String serverId, GetVncConsoleAction action);

	String getConsoleOutput(String serverId, GetConsoleOutputAction action);
	
	ImageList listImages();
	
	Image showImage(String id);
	
	FlavorList listFlavors();
	
	Flavor showFlavor(String id);
	
	KeyPairList listKeyPairs();
	
	SecurityGroupList listSecurityGroups();
	
	void deleteSecurityGroup(Integer id);
	
	VolumeList listVolumes();
	
	SnapshotList listSnapshots();
	
	Snapshot createSnapshot(SnapshotForCreate snapshot);
	
	void deleteSnapshot(Integer id);

	SecurityGroup showSecurityGroup(Integer id);
	
	FloatingIpList listFloatingIps();
	
	FloatingIp createFloatingIp(String pool);
	
	void deleteFloatingIp(Integer id);
	
	Volume createVolume(VolumeForCreate volume);
	
	void deleteVolume(Integer id);
	
	void attachVolume(String serverId, NovaVolumeAttachment attachment);
	
	void detachVolume(String serverId, Integer volumeId);
	
	void associateFloatingIp(String serverId, String address);
	
	void disassociateFloatingIp(String serverId, String address);

	String getEndpointURL();

	void deleteKeyPair(String name);

}
