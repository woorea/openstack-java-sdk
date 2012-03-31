package org.openstack.model.compute;

public interface SnapshotForCreate {

	Integer getVolumeId();

	Boolean getForce();

	String getName();

	String getDescription();

}