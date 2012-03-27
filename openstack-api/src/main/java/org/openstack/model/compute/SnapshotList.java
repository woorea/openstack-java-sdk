package org.openstack.model.compute;

import java.util.List;

import org.openstack.model.compute.nova.snapshot.NovaSnapshot;

public interface SnapshotList {

	List<Snapshot> getList();

}