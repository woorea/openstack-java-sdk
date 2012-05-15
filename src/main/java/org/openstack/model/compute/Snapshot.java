package org.openstack.model.compute;

public interface Snapshot {

	String getId();

	String getStatus();

	Integer getSizeInGB();

	String getCreated();

	String getName();

	String getDescription();

	String getVolumeId();

}