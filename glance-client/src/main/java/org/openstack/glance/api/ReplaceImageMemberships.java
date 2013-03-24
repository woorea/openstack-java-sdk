package org.openstack.glance.api;

import java.util.Collection;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.GlanceCommand;
import org.openstack.glance.model.ImageMember;

public class ReplaceImageMemberships implements GlanceCommand<Void>{

	private String id;
	
	private Collection<ImageMember> imageMembers;
	
	public ReplaceImageMemberships(String id, Collection<ImageMember> imageMembers) {
		this.id = id;
		this.imageMembers = imageMembers;
	}
	
	@Override
	public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("PUT");
	    request.path("/images/").path(id).path("/members");
	    request.header("Accept", "application/json");
	    request.json(new Memberships(imageMembers));
	    connector.execute(request);
	    return null;
	}
	
	private static class Memberships {
		
		@JsonProperty("memberships")
		private Collection<ImageMember> memberships;
		
		public Memberships(Collection<ImageMember> memberships) {
			this.memberships = memberships;
		}
		
	}

}
