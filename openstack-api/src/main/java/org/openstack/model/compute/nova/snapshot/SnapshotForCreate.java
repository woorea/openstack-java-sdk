package org.openstack.model.compute.nova.snapshot;

public interface SnapshotForCreate {

	Integer getVolumeId();

	Boolean getForce();

	String getName();

	String getDescription();

}