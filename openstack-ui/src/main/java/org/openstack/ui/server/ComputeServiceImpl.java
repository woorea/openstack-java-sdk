package org.openstack.ui.server;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.JerseyClientFactory;
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
import org.openstack.model.compute.server.action.Output;
import org.openstack.ui.client.api.ComputeService;

public class ComputeServiceImpl implements ComputeService {

	@Override
	public NovaServerList listServers(String computeURL, String token) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/servers/detail");
		NovaServerList servers = JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", token)
				.get(NovaServerList.class);
		for(final NovaServer ns : servers.getList()) {
			ns.setImage(showImage(computeURL, token, ns.getImage().getId()));
			ns.setFlavor(showFlavor(computeURL, token, ns.getFlavor().getId()));
		}
		return servers;
	}
	
	@Override
	public NovaServer showServer(String computeURL, String token, String id) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/servers/"+id);
		return JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", token)
				.get(NovaServer.class);
	}
	
	public NovaServer saveServer(String computeURL, String token, NovaServerForCreate serverForCreate) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/servers");
		return JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", token)
				.post(Entity.xml(serverForCreate), NovaServer.class);
	}
	
	@Override
	public void deleteServer(String computeURL, String token, String id) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/servers/"+id);
		JerseyClientFactory.newClient().target(uriBuilder)
		.request(MediaType.APPLICATION_XML)
		.header("X-Auth-Token", token)
		.delete();
		
	}

	@Override
	public NovaImageList listImages(String computeURL, String token) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/images/detail");
		return JerseyClientFactory.newClient().target(uriBuilder)
			.request(MediaType.APPLICATION_XML)
			.header("X-Auth-Token", token)
			.get(NovaImageList.class);
	}
	
	public NovaImage showImage(String computeURL, String token, String id) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/images/"+id);
		return JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", token)
				.get(NovaImage.class);
	}

	@Override
	public NovaFlavorList listFlavors(String computeURL, String token) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/flavors/detail");
		NovaFlavorList nfl = JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", token)
				.get(NovaFlavorList.class);
		Collections.sort(nfl.getList(), new Comparator<NovaFlavor>() {

			@Override
			public int compare(NovaFlavor f1, NovaFlavor f2) {
				return f1.getVcpus() - f2.getVcpus();
			}
			
		});
		return nfl;
	}
	
	public NovaFlavor showFlavor(String computeURL, String token, String id) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/flavors/"+id);
		return JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", token)
				.get(NovaFlavor.class);
	}

	@Override
	public List<NovaKeyPair> listKeyPairs(String computeURL, String token) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/os-keypairs");
		return JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", token)
				.get(new GenericType<List<NovaKeyPair>>(){});
	}

	@Override
	public List<NovaSecurityGroup> listSecurityGroups(String computeURL, String token) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/os-security-groups");
		return JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", token)
				.get(new GenericType<List<NovaSecurityGroup>>(){});
	}
	
	@Override
	public NovaSecurityGroup showSecurityGroup(String computeURL, String token,
			Integer id) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/os-security-groups/"+id);
		return JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", token)
				.get(NovaSecurityGroup.class);
	}

	@Override
	public NovaVolumeList listVolumes(String computeURL, String token) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/os-volumes");
		return JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", token)
				.get(NovaVolumeList.class);
	}

	@Override
	public NovaSnapshotList listSnapshots(String computeURL, String token) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/os-snapshots");
		return JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", token)
				.get(NovaSnapshotList.class);
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
	public Console getVncConsole(String computeURL, String token, String serverId, GetVncConsoleAction action) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/servers/{id}/action");
		return JerseyClientFactory.newClient().target(uriBuilder.build(serverId))
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", token)
				.post(Entity.xml(action), Console.class);
	}

	@Override
	public String getConsoleOutput(String computeURL, String token,
			String serverId, GetConsoleOutputAction action) {
		UriBuilder uriBuilder = UriBuilder.fromPath(computeURL).path("/servers/{id}/action");
		return JerseyClientFactory.newClient().target(uriBuilder.build(serverId))
				.request(MediaType.APPLICATION_XML)
				.header("X-Auth-Token", token)
				.post(Entity.xml(action), Output.class).getContent();
	}

	

	

	

}
