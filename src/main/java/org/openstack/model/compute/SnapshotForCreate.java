package org.openstack.model.compute;

public interface SnapshotForCreate {

	String getVolumeId();
	
	void setVolumeId(String volumeId);

	Boolean getForce();
	
	void setForce(Boolean force);

	String getName();
	
	void setName(String name);

	String getDescription();
	
	void setDescription(String description);

}