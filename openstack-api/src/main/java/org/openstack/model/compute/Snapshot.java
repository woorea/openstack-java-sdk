package org.openstack.model.compute;

public interface Snapshot {

	Integer getId();

	String getStatus();

	Integer getSizeInGB();

	String getAvailabilityZone();

	String getCreated();

	String getName();

	String getDescription();

	Integer getVolumeId();

}