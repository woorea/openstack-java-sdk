package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupList;

import com.sun.jersey.api.client.WebResource.Builder;

public class SecurityGroupsResource extends ComputeResourceBase {

	@Override
	protected Builder addAcceptHeaders(Builder webResource) {
		// Whitespace problems when using XML
		return webResource.accept(MediaType.APPLICATION_JSON);
	}
	
    public SecurityGroupList list() {
        return resource().get(SecurityGroupList.class);
    }

    public SecurityGroup create(SecurityGroup securityGroup) {
    	return resource().post(SecurityGroup.class, securityGroup);
        // return client.resource(resource).accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_XML).post(SecurityGroup.class, securityGroup);
    }

    public SecurityGroupResource securityGroup(int id) {
        return buildChildResource(String.valueOf(id), SecurityGroupResource.class);
    }
}
