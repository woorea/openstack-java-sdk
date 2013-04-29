package org.openstack.glance.api;

import java.util.Collection;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.model.ImageMember;

public class ReplaceImageMemberships extends OpenStackRequest {

	private String id;
	
	private Collection<ImageMember> imageMembers;
	
	public ReplaceImageMemberships(String id, Collection<ImageMember> imageMembers) {
		method(HttpMethod.PUT);
	    path("/images/").path(id).path("/members");
	    header("Accept", "application/json");
	    json(new Memberships(imageMembers));
	}
	
	private static class Memberships {
		
		@JsonProperty("memberships")
		private Collection<ImageMember> memberships;
		
		public Memberships(Collection<ImageMember> memberships) {
			this.memberships = memberships;
		}
		
	}

}
