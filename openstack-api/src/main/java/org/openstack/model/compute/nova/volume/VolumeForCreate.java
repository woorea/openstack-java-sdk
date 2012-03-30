package org.openstack.model.compute.nova.volume;

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

}