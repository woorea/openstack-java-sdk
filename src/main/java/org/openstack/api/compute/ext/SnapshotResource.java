package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.nova.snapshot.NovaSnapshot;

public class SnapshotResource extends Resource {

	public SnapshotResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	/**
	 * Return a single volume type item.
	 * 
	 * @return
	 */
	public Snapshot get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaSnapshot.class);
	}

	public void delete() {
		target.request(MediaType.WILDCARD).delete();
	}
	
}
