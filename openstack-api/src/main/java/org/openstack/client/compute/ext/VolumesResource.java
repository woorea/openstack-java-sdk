package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.Volume;
import org.openstack.model.compute.VolumeList;

import com.sun.jersey.api.client.Client;

/**
 * The volume types API controller for the Openstack API
 * 
 * @author sp
 * 
 */
public class VolumesResource extends Resource {

	public VolumesResource(Client client, String resource) {
		super(client, resource);
	}
	
	/**
	 * Returns the list of volume types
	 * 
	 * @return
	 */
	public VolumeList list(boolean detail) {
		if(detail) {
			return client.resource(new StringBuilder(resource).append("/detail").toString()).accept(MediaType.APPLICATION_XML).get(VolumeList.class);
		} else {
			return client.resource(resource).accept(MediaType.APPLICATION_XML).get(VolumeList.class);
		}
	}

	/**
	 * Creates a new volume type.
	 * 
	 * @param flavor
	 * @return
	 */
	public Volume create(Volume volume) {
		return null;
	}

	public VolumeResource volume(String id) {
		return new VolumeResource(client, new StringBuilder(resource).append("/").append(id).toString());
	}

}
