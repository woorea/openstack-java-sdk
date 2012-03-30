package org.openstack.client.compute;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.openstack.model.compute.Volume;
import org.openstack.model.compute.VolumeList;
import org.openstack.model.compute.nova.volume.NovaVolumeAttachment;
import org.openstack.model.compute.nova.volume.NovaVolumeForCreate;
import org.testng.annotations.Test;

public class ITSnapshots extends ComputeIntegrationTest {
	
	private Volume volume;

	@Test
	public void listVolumes() {
		VolumeList volumes = compute.volumes().get();
	}
	
	@Test
	public void createVolume() throws Exception {
		NovaVolumeForCreate nv = new NovaVolumeForCreate();
		nv.setName("v2");
		nv.setSizeInGB(1);
		volume = compute.volumes().post(nv);
		System.out.println(volume);
		waitForState("available");
	}
	
	@Test(dependsOnMethods="createVolume", priority=1)
	public void showVolume() throws Exception {
		volume = compute.volumes().volume(volume.getId()).get();
		System.out.println(volume);	
	}
	
	@Test(dependsOnMethods="createVolume", priority=1000)
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
