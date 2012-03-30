package org.openstack.api.compute.ext;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.SnapshotList;
import org.openstack.model.compute.Volume;
import org.openstack.model.compute.VolumeList;
import org.openstack.model.compute.nova.snapshot.NovaSnapshot;
import org.openstack.model.compute.nova.snapshot.NovaSnapshotList;
import org.openstack.model.compute.nova.volume.NovaVolume;
import org.openstack.model.compute.nova.volume.NovaVolumeList;
import org.openstack.model.compute.nova.volume.VolumeForCreate;

public class SnapshotsResource extends Resource {

	public SnapshotsResource(Target target) {
		super(target);
	}
	
	/**
	 * Returns the list of volume types
	 * 
	 * @return
	 */
	public SnapshotList get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaSnapshotList.class);
	}
	
	/**
	 * Creates a new volume.
	 * 
	 * @param flavor
	 * @return
	 */
	public Snapshot post(VolumeForCreate volume) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(volume, MediaType.APPLICATION_JSON), NovaSnapshot.class);
	}

	public SnapshotResource snapshot(Integer id) {
		return new SnapshotResource(target.path("/{snapshotId}").pathParam("snapshotId", id));
	}
	
}
