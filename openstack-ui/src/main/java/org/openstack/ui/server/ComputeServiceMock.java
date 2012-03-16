package org.openstack.ui.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaFlavorList;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaImageList;
import org.openstack.model.compute.NovaKeyPair;
import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.compute.NovaServer;
import org.openstack.model.compute.NovaServerForCreate;
import org.openstack.model.compute.NovaServerList;
import org.openstack.model.compute.NovaSnapshot;
import org.openstack.model.compute.NovaSnapshotList;
import org.openstack.model.compute.NovaVolume;
import org.openstack.model.compute.NovaVolumeList;
import org.openstack.model.compute.server.action.Console;
import org.openstack.model.compute.server.action.GetConsoleOutputAction;
import org.openstack.model.compute.server.action.GetVncConsoleAction;
import org.openstack.ui.client.api.ComputeService;

public class ComputeServiceMock implements ComputeService {

	private Random random = new Random();

	private Map<String, Object> cache = new HashMap<String, Object>();

	@Override
	public NovaServerList listServers(String token, String tenantId) {
		final NovaImageList images = listImages(token, tenantId);
		final NovaFlavorList flavors = listFlavors(token, tenantId);
		if (cache.get("servers." + tenantId) == null) {
			List<NovaServer> list = new ArrayList<NovaServer>();
			for (int i = 0; i < 5; i++) {
				if (i % (Integer.parseInt(tenantId) + 1) == 0) {
					NovaServer server = new NovaServer(String.valueOf(i), "server." + i);
					server.setImage(images.getList().get(random.nextInt(images.getList().size())));
					server.setFlavor(flavors.getList().get(random.nextInt(flavors.getList().size())));
					list.add(server);
				}
			}
			NovaServerList nsl = new NovaServerList();
			nsl.setList(list);
			cache.put("servers." + tenantId, nsl);
		}
		return (NovaServerList) cache.get("servers." + tenantId);
	}
	
	public NovaServer saveServer(String computeURL, String token, NovaServerForCreate serverForCreate) {
		return new NovaServer();
	}
	
	@Override
	public NovaImageList listImages(String token, String tenantId) {
		if (cache.get("images") == null) {
			List<NovaImage> list = new ArrayList<NovaImage>();
			for (int i = 0; i < 5; i++) {
				list.add(new NovaImage(String.valueOf("i"),"image." + i));
			}
			NovaImageList nil = new NovaImageList();
			nil.setList(list);
			cache.put("images", nil);
		}
		return (NovaImageList) cache.get("images");
	}
	
	@Override
	public NovaFlavorList listFlavors(String token, String tenantId) {
		if (cache.get("flavors") == null) {
			List<NovaFlavor> list = new ArrayList<NovaFlavor>();
			for (int i = 0; i < 5; i++) {
				list.add(new NovaFlavor(String.valueOf(i), "flavor." + i));
			}
			NovaFlavorList nfl = new NovaFlavorList();
			nfl.setList(list);
			cache.put("flavors", nfl);
		}
		return (NovaFlavorList) cache.get("flavors");
	}
	
	@Override
	public List<NovaKeyPair> listKeyPairs(String token, String tenantId) {
		if (cache.get("keyPairs." + tenantId) == null) {
			List<NovaKeyPair> list = new ArrayList<NovaKeyPair>();
			for (int i = 0; i < 5; i++) {
				if (i % (Integer.parseInt(tenantId) + 2) == 0) {
					NovaKeyPair keyPair = new NovaKeyPair("keypair." + i);
					keyPair.setFingerprint("AABBCCDDEEFFGG");
					list.add(keyPair);
				}
			}
			cache.put("keyPairs." + tenantId, list);
		}
		return (List<NovaKeyPair>) cache.get("keyPairs." + tenantId);
	}
	
	@Override
	public List<NovaSecurityGroup> listSecurityGroups(String token, String tenantId) {
		if (cache.get("securityGroups." + tenantId) == null) {
			List<NovaSecurityGroup> list = new ArrayList<NovaSecurityGroup>();
			for (int i = 0; i < 5; i++) {
				if (i % (Integer.parseInt(tenantId) + 4) == 0) {
					NovaSecurityGroup sg = new NovaSecurityGroup(i, "sg.name." + i);
					sg.setDescription("sg.description." + i);
					list.add(sg);
				}
			}
			cache.put("securityGroups." + tenantId, list);
		}
		return (List<NovaSecurityGroup>) cache.get("securityGroups." + tenantId);
	}

	@Override
	public void deleteServer(String computeURL, String token, String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NovaVolumeList listVolumes(String computeURL, String token) {
		if (cache.get("volumes") == null) {
			List<NovaVolume> list = new ArrayList<NovaVolume>();
			for (int i = 0; i < 5; i++) {
				list.add(new NovaVolume());
			}
			NovaVolumeList nfl = new NovaVolumeList();
			nfl.setList(list);
			cache.put("volumes", nfl);
		}
		return (NovaVolumeList) cache.get("volumes");
	}

	@Override
	public NovaSnapshotList listSnapshots(String computeURL, String token) {
		if (cache.get("snapshots") == null) {
			List<NovaSnapshot> list = new ArrayList<NovaSnapshot>();
			for (int i = 0; i < 5; i++) {
				list.add(new NovaSnapshot());
			}
			NovaSnapshotList nfl = new NovaSnapshotList();
			nfl.setList(list);
			cache.put("snapshots", nfl);
		}
		return (NovaSnapshotList) cache.get("snapshots");
	}

	@Override
	public void restoreServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void forceDeleteServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePasswordServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rebuildServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resizeServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void revertResizeServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createImageServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pauseServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unpauseServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suspendServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resumeServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void migrateServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetNetworkServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void injectNetworkInfoServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lockServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unlockServer(String computeURL, String token,
			Collection<NovaServer> servers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Console getVncConsole(String computeURL, String token,
			String serverId, GetVncConsoleAction action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConsoleOutput(String computeURL, String token,
			String serverId, GetConsoleOutputAction action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NovaServer showServer(String computeURL, String token, String id) {
		return new NovaServer();
	}

	@Override
	public NovaSecurityGroup showSecurityGroup(String computeURL, String token,
			Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NovaImage showImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NovaFlavor showFlavor() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
