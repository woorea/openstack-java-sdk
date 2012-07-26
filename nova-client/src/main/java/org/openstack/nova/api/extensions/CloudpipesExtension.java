package org.openstack.nova.api.extensions;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Cloudpipe;
import org.openstack.nova.model.Cloudpipes;

public class CloudpipesExtension {
	
	public static class ListCloudpipes implements NovaCommand<Cloudpipes>{

		@Override
		public Cloudpipes execute(WebTarget target) {
			return target.path("os-cloudpipes").request(MediaType.APPLICATION_JSON).get(Cloudpipes.class);
		}

	}

	public static class CreateCloudpipe implements NovaCommand<Cloudpipe> {

		private Cloudpipe cloudpipe;
		
		public CreateCloudpipe(Cloudpipe cloudpipe) {
			this.cloudpipe = cloudpipe;
		}

		@Override
		public Cloudpipe execute(WebTarget target) {
			return target.path("os-cloudpipes").request(MediaType.APPLICATION_JSON).post(Entity.json(cloudpipe), Cloudpipe.class);
		}
		
	}

	public static ListCloudpipes listCloudpipes() {
		return new ListCloudpipes();
	}
	
	public static CreateCloudpipe createCloudpipe(Cloudpipe cloudpipe) {
		return new CreateCloudpipe(cloudpipe);
	}
	
}
