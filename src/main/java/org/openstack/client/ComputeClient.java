package org.openstack.client;

import java.util.List;
import java.util.Map;

import org.openstack.api.compute.TenantResource;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.FlavorList;
import org.openstack.model.compute.FloatingIp;
import org.openstack.model.compute.ImageList;
import org.openstack.model.compute.KeyPair;
import org.openstack.model.compute.KeyPairListItem;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerList;
import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.Volume;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class ComputeClient {
	
	private TenantResource resource;
	
	public ComputeClient(TenantResource resource) {
		this.resource = resource;
	}
	
	public ServerList listServers() {
		return resource.servers().get();
	}
	
	public ServerList listServers(int offset, int max) {
		return resource.servers().get();
	}

	public ServerList listServers(Map<String, Object> params) {
		return resource.servers().get();
	}
	
	public Server showServer(String id) {
		return resource.servers().server(id).get();
	}
	
	public void deleteServer(String id) {
		resource.servers().server(id).delete();
	}
	
	public FlavorList listFlavors() {
		return resource.flavors().get();
	}
	
	public FlavorList listFlavors(int offset, int max) {
		return resource.flavors().get();
	}

	public FlavorList listFlavors(Map<String, Object> params) {
		return resource.flavors().get();
	}
	
	public Flavor showFlavor(String id) {
		return resource.flavors().flavor(id).get();
	}
	
	public void deleteFlavor(String id) {
		resource.flavors().flavor(id).delete();
	}
	
	public ImageList listImages() {
		return resource.images().get();
	}
	
	public ImageList listImages(int offset, int max) {
		return resource.images().get();
	}

	public ImageList listImages(Map<String, Object> params) {
		return resource.images().get();
	}
	
	public List<FloatingIp> listFloatingIps() {
		return resource.floatingIps().get().getList();
	}
	
	public FloatingIp createFloatingIp(String pool) {
		return resource.floatingIps().post(pool);
	}
	
	public void deleteFloatingIp(Integer id) {
		resource.floatingIps().floatingIp(id).delete();
	}
	
	public List<KeyPair> listKeyPairs() {
		return Lists.transform(resource.keyPairs().get().getList(), new Function<KeyPairListItem, KeyPair>() {

			@Override
			public KeyPair apply(KeyPairListItem item) {
				return item.getKeypair();
			}
		});
	}
	
	public KeyPair createKeyPair(String name) {
		return resource.keyPairs().post(null);
	}
	
	public void deleteKeyPair(String name) {
		resource.keyPairs().keypair(name).delete();
	}
	
	public List<SecurityGroup> listSecurityGroups() {
		return resource.securityGroups().get().getList();
	}
	
	public SecurityGroup createSecurityGroup(String name, String description) {
		return resource.securityGroups().post(null);
	}
	
	public SecurityGroup showSecurityGroup(Integer id) {
		return resource.securityGroups().securityGroup(id).get();
	}
	
	public void deleteSecurityGroup(Integer id) {
		resource.securityGroups().securityGroup(id).delete();
	}
	
	public List<Volume> listVolumes() {
		return resource.volumes().get().getList();
	}
	
	public Volume createVolume(String name, String description) {
		return resource.volumes().post(null);
	}
	
	public void showVolume(Integer id) {
		resource.volumes().volume(id).get();
	}
	
	public void deleteVolume(Integer id) {
		resource.volumes().volume(id).delete();
	}
	
	public List<Snapshot> listSnapshots() {
		return resource.snapshots().get().getList();
	}
	
	public Snapshot createSnapshot(String name, String description) {
		return resource.snapshots().post(null);
	}
	
	public void showSnapshot(Integer id) {
		resource.snapshots().snapshot(id).get();
	}
	
	public void deleteSnapshot(Integer id) {
		resource.snapshots().snapshot(id).delete();
	}
	
}
