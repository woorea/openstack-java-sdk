package org.openstack.model.compute.nova.volume;

import org.openstack.model.compute.Metadata;

public interface VolumeForCreate {

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getSizeInGB()
	 */
	Integer getSizeInGB();
	
	void setSizeInGB(Integer sizeInGb);

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getAvailabilityZone()
	 */
	String getAvailabilityZone();
	
	void setAvailabilityZone(String availabilityZone);

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getName()
	 */
	String getName();
	
	void setName(String name);

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getDescription()
	 */
	String getDescription();
	
	void setDescription(String description);

	Metadata getMetadata();
	
	void setMetadata(Metadata metadata);

	Integer getSnapshotId();
	
	void setSnapshotId(Integer snapshotId);

}