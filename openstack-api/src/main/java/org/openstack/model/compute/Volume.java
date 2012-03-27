package org.openstack.model.compute;

public interface Volume {

	Integer getId();

	Integer getStatus();

	Integer getSizeInGB();

	Integer getAvailabilityZone();

	String getType();

	String getCreated();

	String getName();

	String getDescription();

	String getSnapshotId();

	Metadata getMetadata();

}