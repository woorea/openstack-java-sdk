package org.openstack.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openstack.api.compute.TenantResource;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.FlavorList;
import org.openstack.model.compute.FloatingIp;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.ImageList;
import org.openstack.model.compute.KeyPair;
import org.openstack.model.compute.KeyPairListItem;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupForCreate;
import org.openstack.model.compute.SecurityGroupRule;
import org.openstack.model.compute.SecurityGroupRuleForCreate;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerAction;
import org.openstack.model.compute.ServerForCreate;
import org.openstack.model.compute.ServerList;
import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.SnapshotForCreate;
import org.openstack.model.compute.Volume;
import org.openstack.model.compute.nova.floatingip.NovaFloatingIpPool;
import org.openstack.model.compute.nova.keypair.NovaKeyPair;
import org.openstack.model.compute.nova.volume.VolumeForCreate;

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
	
	public Server createServer(ServerForCreate serverForCreate) {
		return resource.servers().post(serverForCreate);
	}
	
	public Server showServer(String id) {
		return resource.servers().server(id).get();
	}
	
	public void deleteServer(String id) {
		resource.servers().server(id).delete();
	}
	
	public Serializable executeServerAction(String id, ServerAction action) {
		return resource.servers().server(id).action().post(action, action.getReturnType());
		
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
	
	public Image showImage(String id) {
		return resource.images().image(id).get();
	}
	
	public List<NovaFloatingIpPool> listFloatingIpPools() {
		resource.floatingIpPools().get();
		return new ArrayList<NovaFloatingIpPool>();
	}
	
	public List<FloatingIp> listFloatingIps() {
		return resource.floatingIps().get().getList();
	}
	
	public FloatingIp allocateFloatingIp(String pool) {
		return resource.floatingIps().post(pool);
	}
	
	public void deallocateFloatingIp(Integer id) {
		resource.floatingIps().floatingIp(id).delete();
	}
	
	public List<KeyPair> listKeyPairs() {
		return new ArrayList<KeyPair>(Lists.transform(resource.keyPairs().get().getList(), new Function<KeyPairListItem, KeyPair>() {

			@Override
			public KeyPair apply(KeyPairListItem item) {
				return item.getKeypair();
			}
		}));
	}
	
	public KeyPair createKeyPair(String name) {
		return resource.keyPairs().post(new NovaKeyPair(name));
	}
	
	public void deleteKeyPair(String name) {
		resource.keyPairs().keypair(name).delete();
	}
	
	public List<SecurityGroup> listSecurityGroups() {
		return resource.securityGroups().get().getList();
	}
	
	public SecurityGroup createSecurityGroup(SecurityGroupForCreate securityGroupForCreate) {
		return resource.securityGroups().post(securityGroupForCreate);
	}
	
	public SecurityGroup showSecurityGroup(Integer id) {
		return resource.securityGroups().securityGroup(id).get();
	}
	
	public void deleteSecurityGroup(Integer id) {
		resource.securityGroups().securityGroup(id).delete();
	}
	
	public SecurityGroupRule addSecurityGroupRule(SecurityGroupRuleForCreate rule) {
		return resource.securityGroupRules().post(rule);
	}
	
	public void removeSecurityGroupRule(Integer id) {
		resource.securityGroupRules().rule(id).delete();
	}
	
	public List<Volume> listVolumes() {
		return resource.volumes().get().getList();
	}
	
	public Volume createVolume(VolumeForCreate volume) {
		return resource.volumes().post(volume);
	}
	
	public void showVolume(String id) {
		resource.volumes().volume(id).get();
	}
	
	public void deleteVolume(String id) {
		resource.volumes().volume(id).delete();
	}
	
	public List<Snapshot> listSnapshots() {
		return resource.snapshots().get().getList();
	}
	
	public Snapshot createSnapshot(SnapshotForCreate snapshot) {
		return resource.snapshots().post(snapshot);
	}
	
	public void showSnapshot(String id) {
		resource.snapshots().snapshot(id).get();
	}
	
	public void deleteSnapshot(String id) {
		resource.snapshots().snapshot(id).delete();
	}

}
