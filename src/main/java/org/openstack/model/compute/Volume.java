package org.openstack.model.compute;

import java.util.Map;

public interface Volume {

	Integer getId();

	String getStatus();

	Integer getSizeInGB();

	String getAvailabilityZone();

	String getType();

	String getCreated();

	String getName();

	String getDescription();

	Integer getSnapshotId();

	Map<String, String> getMetadata();

}