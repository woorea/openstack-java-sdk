package org.openstack.model.compute;

public interface SnapshotForCreate {

	Integer getVolumeId();
	
	void setVolumeId(Integer volumeId);

	Boolean getForce();
	
	void setForce(Boolean force);

	String getName();
	
	void setName(String name);

	String getDescription();
	
	void setDescription(String description);

}