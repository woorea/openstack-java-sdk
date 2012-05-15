package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.SnapshotForCreate;
import org.openstack.model.compute.SnapshotList;
import org.openstack.model.compute.nova.snapshot.NovaSnapshot;
import org.openstack.model.compute.nova.snapshot.NovaSnapshotList;

public class SnapshotsResource extends Resource {

	public SnapshotsResource(Target target, Properties properties) {
		super(target, properties);
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
	public Snapshot post(SnapshotForCreate volume) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(volume, MediaType.APPLICATION_JSON), NovaSnapshot.class);
	}

	public SnapshotResource snapshot(String id) {
		return new SnapshotResource(target.path("/{snapshotId}").pathParam("snapshotId", id), properties);
	}
	
}
