package org.openstack.client.compute;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.SnapshotList;
import org.openstack.model.compute.nova.snapshot.NovaSnapshotForCreate;
import org.testng.annotations.Test;

public class ITSnapshots extends ComputeIntegrationTest {
	
	private Snapshot volume;

	@Test
	public void listSnapshots() {
		SnapshotList volumes = compute.snapshots().get();
	}
	
	@Test
	public void createSnapshot() throws Exception {
		NovaSnapshotForCreate nv = new NovaSnapshotForCreate();
		nv.setName("v2");
		nv.setDescription("desc");
		volume = compute.snapshots().post(nv);
		System.out.println(volume);
		waitForState("available");
	}
	
	@Test(dependsOnMethods="createSnapshot", priority=1)
	public void showSnapshot() throws Exception {
		volume = compute.snapshots().snapshot(volume.getId()).get();
		System.out.println(volume);	
	}
	
	@Test(dependsOnMethods="createSnapshot", priority=1000)
	public void deleteSnapshot() {
		compute.volumes().volume(volume.getId()).delete();
	}
	
	private void waitForState(final String state) {
		try {
			final ScheduledThreadPoolExecutor timer = new ScheduledThreadPoolExecutor(1);
			timer.scheduleAtFixedRate(new Runnable() {
				
				@Override
				public void run() {
					volume = compute.snapshots().snapshot(volume.getId()).get();
					if(state.equals(volume.getStatus())) {
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
