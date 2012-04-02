package org.openstack.model.compute;

public interface Volume {

	Integer getId();

	String getStatus();

	Integer getSizeInGB();

	String getAvailabilityZone();

	String getType();

	String getCreated();

	String getName();

	String getDescription();

	String getSnapshotId();

	Metadata getMetadata();

}