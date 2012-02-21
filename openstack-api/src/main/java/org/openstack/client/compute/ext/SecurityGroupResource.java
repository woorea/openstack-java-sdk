package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.model.compute.SecurityGroup;

import com.sun.jersey.api.client.WebResource.Builder;

public class SecurityGroupResource extends ComputeResourceBase {
	@Override
	protected Builder addAcceptHeaders(Builder webResource) {
		// Whitespace problems when using XML
		return webResource.accept(MediaType.APPLICATION_JSON);
	}
	
    public SecurityGroup show() {
        return resource().get(SecurityGroup.class);
    }

    public void delete() {
        resource().delete();
    }
}
