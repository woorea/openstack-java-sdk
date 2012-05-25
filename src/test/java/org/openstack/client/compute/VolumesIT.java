package org.openstack.client.compute;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.SnapshotList;
import org.openstack.model.compute.Volume;
import org.openstack.model.compute.VolumeList;
import org.openstack.model.compute.nova.snapshot.NovaSnapshotForCreate;
import org.openstack.model.compute.nova.volume.NovaVolumeAttachment;
import org.openstack.model.compute.nova.volume.NovaVolumeForCreate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VolumesIT extends ComputeIntegrationTest {
	
	private Volume volume;
	private Snapshot snapshot;
	
	@Test(priority=1)
	public void cleanAll() {
		VolumeList volumes = compute.volumes().get();
		for(Volume v : volumes.getList()) {
			compute.volumes().volume(v.getId()).delete();
		}
		SnapshotList snapshots = compute.snapshots().get();
		for(Snapshot s : snapshots.getList()) {
			compute.snapshots().snapshot(s.getId()).delete();
		}
	}
	
	@Test(priority=2)
	public void createVolume() throws Exception {
		NovaVolumeForCreate nv = new NovaVolumeForCreate();
		nv.setName("v2");
		nv.setSizeInGB(1);
		volume = compute.volumes().post(nv);
		System.out.println(volume);
		waitForState("available");
	}

	@Test(dependsOnMethods="createVolume", priority=1)
	public void listVolumes() {
		VolumeList volumes = compute.volumes().get();
		Assert.assertNotNull(volumes);
	}
	
	@Test(dependsOnMethods="createVolume", priority=2)
	public void showVolume() throws Exception {
		volume = compute.volumes().volume(volume.getId()).get();
		System.out.println(volume);	
	}
	
	@Test(dependsOnMethods={"createVolume","deleteSnapshot"}, priority=1000, alwaysRun=true)
	public void deleteVolume() {
		compute.volumes().volume(volume.getId()).delete();
	}
	
	public void createVolumeAttachment() {
		NovaVolumeAttachment attachment = new NovaVolumeAttachment();
		attachment.setVolumeId(volume.getId());
		attachment.setDevice("/mnt");
		compute.servers().server("").attachments().post(attachment);
	}
	
	public void deleteVolumeAttachment() {
		compute.servers().server("").attachments().attachment(volume.getId()).delete();
	}
	
	private void waitForState(final String state) {
		try {
			final ScheduledThreadPoolExecutor timer = new ScheduledThreadPoolExecutor(1);
			timer.scheduleAtFixedRate(new Runnable() {
				
				@Override
				public void run() {
					volume = compute.volumes().volume(volume.getId()).get();
					if(state.equals(volume.getStatus()) || "error".equals(volume.getStatus())) {
						timer.shutdown();
					} else {
						System.out.print(".");
					}
				}
			}, 3, 1, TimeUnit.SECONDS);
			timer.awaitTermination(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			
		}
		
	}
	
	@Test(dependsOnMethods={"createVolume"})
	public void createSnapshot() throws Exception {
		NovaSnapshotForCreate ns = new NovaSnapshotForCreate();
		ns.setVolumeId(volume.getId());
		ns.setName("v2");
		ns.setDescription("desc");
		snapshot = compute.snapshots().post(ns);
		waitForState(snapshot, "available");
	}

	@Test(dependsOnMethods={"createSnapshot"})
	public void listSnapshots() {
		SnapshotList snapshots = compute.snapshots().get();
		Assert.assertNotNull(snapshots);
	}
	
	
	
	@Test(dependsOnMethods="createSnapshot", priority=1)
	public void showSnapshot() throws Exception {
		snapshot = compute.snapshots().snapshot(snapshot.getId()).get();
		System.out.println(snapshot);	
	}
	
	@Test(dependsOnMethods="createSnapshot", priority=1000)
	public void deleteSnapshot() {
		compute.snapshots().snapshot(snapshot.getId()).delete();
	}
	
	private void waitForState(final Snapshot snapshot, final String state) {
		try {
			final ScheduledThreadPoolExecutor timer = new ScheduledThreadPoolExecutor(1);
			timer.scheduleAtFixedRate(new Runnable() {
				
				@Override
				public void run() {
					Snapshot check = compute.snapshots().snapshot(snapshot.getId()).get();
					if(state.equals(check.getStatus()) || "error".equals(check.getStatus())) {
						timer.shutdown();
					} else {
						System.out.print(".");
					}
				}
			}, 3, 1, TimeUnit.SECONDS);
			timer.awaitTermination(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			
		}
		
	}
	
}
