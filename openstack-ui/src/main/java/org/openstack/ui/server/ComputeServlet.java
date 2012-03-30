package org.openstack.ui.server;

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
import org.openstack.model.compute.SnapshotList;
import org.openstack.model.compute.Volume;
import org.openstack.model.compute.VolumeList;
import org.openstack.model.compute.nova.NovaServerForCreate;
import org.openstack.model.compute.nova.floatingip.AssociateFloatingIpAction;
import org.openstack.model.compute.nova.floatingip.DisassociateFloatingIpAction;
import org.openstack.model.compute.nova.server.actions.Console;
import org.openstack.model.compute.nova.server.actions.GetConsoleOutputAction;
import org.openstack.model.compute.nova.server.actions.GetVncConsoleAction;
import org.openstack.model.compute.nova.server.actions.Output;
import org.openstack.model.compute.nova.snapshot.NovaSnapshotList;
import org.openstack.model.compute.nova.volume.NovaVolumeAttachment;
import org.openstack.model.compute.nova.volume.VolumeForCreate;
import org.openstack.ui.client.api.ComputeService;

@SuppressWarnings("serial")
public class ComputeServlet extends OpenStackRemoteServiceServlet implements ComputeService {

	public SecurityGroup showSecurityGroup(Integer id) {
		return getClient().getComputeEndpoint().securityGroups().securityGroup(id).get();
	}

	@Override
	public ServerList listServers() {
		return getClient().getComputeEndpoint().servers().get();
	}
	
	@Override
	public Server showServer(String id) {
		return getClient().getComputeEndpoint().servers().server(id).get();
	}
	
	@Override
	public Server saveServer(NovaServerForCreate serverForCreate) {
		return getClient().getComputeEndpoint().servers().post(serverForCreate);
	}
	
	@Override
	public void deleteServer(String id) {
		getClient().getComputeEndpoint().servers().server(id).delete();
	}
	
	public void restoreServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void forceDeleteServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void changePasswordServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void rebuildServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void resizeServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void revertResizeServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void createImageServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void pauseServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void unpauseServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void suspendServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void resumeServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void migrateServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void resetNetworkServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void injectNetworkInfoServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void lockServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public void unlockServer(Collection<Server> servers) {
		for(Server s : servers) {
			getClient().getComputeEndpoint().servers().server("").restore();
		}
	}

	public Console getVncConsole(String serverId, GetVncConsoleAction action) {
		
		return getClient().getComputeEndpoint().servers().server(serverId).action().post(action, Console.class);
		
	}

	public String getConsoleOutput(String serverId, GetConsoleOutputAction action) {
		
		return getClient().getComputeEndpoint().servers().server(serverId).action().post(action,  Output.class).getOutput();
		
	}


	@Override
	public ImageList listImages() {
		return getClient().getComputeEndpoint().images().get();
	}

	@Override
	public FlavorList listFlavors() {
		return getClient().getComputeEndpoint().flavors().get();
	}

	@Override
	public KeyPairList listKeyPairs() {
		return getClient().getComputeEndpoint().keyPairs().get();
	}

	@Override
	public SecurityGroupList listSecurityGroups() {
		return getClient().getComputeEndpoint().securityGroups().get();
	}

	@Override
	public VolumeList listVolumes() {
		return getClient().getComputeEndpoint().volumes().get();
	}

	@Override
	public SnapshotList listSnapshots() {
		return new NovaSnapshotList();
	}

	public Image showImage(String id) {
		return getClient().getComputeEndpoint().images().image(id).get();
	}

	public Flavor showFlavor(String id) {
		return getClient().getComputeEndpoint().flavors().flavor(id).get();
	}

	@Override
	public FloatingIpList listFloatingIps() {
		return getClient().getComputeEndpoint().floatingIps().get();
	}

	@Override
	public FloatingIp createFloatingIp(String pool) {
		return getClient().getComputeEndpoint().floatingIps().post(pool);
	}

	@Override
	public void deleteFloatingIp(Integer id) {
		getClient().getComputeEndpoint().floatingIps().floatingIp(id).delete();
		
	}

	@Override
	public Volume createVolume(VolumeForCreate volume) {
		return getClient().getComputeEndpoint().volumes().post(volume);
	}

	@Override
	public void deleteVolume(Integer id) {
		getClient().getComputeEndpoint().volumes().volume(id).delete();
		
	}

	@Override
	public void attachVolume(String serverId, NovaVolumeAttachment attachment) {
		getClient().getComputeEndpoint().servers().server(serverId).attachments().post(attachment);
		
	}

	@Override
	public void detachVolume(String serverId, Integer volumeId) {
		getClient().getComputeEndpoint().servers().server(serverId).attachments().attachment(volumeId).delete();
		
	}

	@Override
	public void associateFloatingIp(String serverId, String address) {
		AssociateFloatingIpAction action = new AssociateFloatingIpAction();
		action.setAddress(address);
		getClient().getComputeEndpoint().servers().server(serverId).action().post(action, String.class);
		
	}

	@Override
	public void disassociateFloatingIp(String serverId, String address) {
		DisassociateFloatingIpAction action = new DisassociateFloatingIpAction();
		action.setAddress(address);
		getClient().getComputeEndpoint().servers().server(serverId).action().post(action, String.class);
		
	}

	

}
