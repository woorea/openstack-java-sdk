package org.openstack.model.compute;

import java.util.List;
import java.util.Map;

import org.openstack.model.compute.nova.volume.NovaVolumeAttachment;

public interface Volume {

	String getId();

	String getStatus();

	Integer getSizeInGB();

	String getAvailabilityZone();

	String getType();

	String getCreated();

	String getName();

	String getDescription();

	Integer getSnapshotId();

	Map<String, String> getMetadata();
	
	List<NovaVolumeAttachment> getAttachments();

}