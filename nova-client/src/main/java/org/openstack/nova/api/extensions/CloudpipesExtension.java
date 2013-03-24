package org.openstack.nova.api.extensions;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Cloudpipe;
import org.openstack.nova.model.Cloudpipes;

public class CloudpipesExtension {
	
	public static class ListCloudpipes implements NovaCommand<Cloudpipes>{

		@Override
		public Cloudpipes execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("GET");
		    request.path("/os-cloudpipes/");
		    request.header("Accept", "application/json");
		    return connector.execute(request, Cloudpipes.class);
		}

	}

	public static class CreateCloudpipe implements NovaCommand<Cloudpipe> {

		private Cloudpipe cloudpipe;
		
		public CreateCloudpipe(Cloudpipe cloudpipe) {
			this.cloudpipe = cloudpipe;
		}

		@Override
		public Cloudpipe execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("POST");
		    request.path("/os-cloudpipes/");
		    request.header("Accept", "application/json");
		    request.json(cloudpipe);
		    return connector.execute(request, Cloudpipe.class);
		}
		
	}

	public static ListCloudpipes listCloudpipes() {
		return new ListCloudpipes();
	}
	
	public static CreateCloudpipe createCloudpipe(Cloudpipe cloudpipe) {
		return new CreateCloudpipe(cloudpipe);
	}
	
}
