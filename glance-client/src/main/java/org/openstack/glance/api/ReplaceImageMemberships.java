package org.openstack.glance.api;

import java.util.Collection;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.annotate.JsonProperty;
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
	public Void execute(WebTarget endpoint) {
		endpoint.path("images").path(id).path("members").request(MediaType.APPLICATION_JSON).put(Entity.json(new Memberships(imageMembers)));
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
