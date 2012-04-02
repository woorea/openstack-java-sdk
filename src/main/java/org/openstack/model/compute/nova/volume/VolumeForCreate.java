package org.openstack.model.compute.nova.volume;

import org.openstack.model.compute.nova.NovaMetadata;

public interface VolumeForCreate {

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getSizeInGB()
	 */
	Integer getSizeInGB();

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getAvailabilityZone()
	 */
	String getAvailabilityZone();

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getName()
	 */
	String getName();

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Volume#getDescription()
	 */
	String getDescription();

	NovaMetadata getMetadata();

	Integer getSnapshotId();

}