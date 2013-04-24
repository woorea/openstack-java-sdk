package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Cloudpipe;
import org.openstack.nova.model.Cloudpipes;

public class CloudpipesExtension {
	
	public static class ListCloudpipes implements OpenStackCommand<Cloudpipes>{

		@Override
		public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.GET);
		    request.path("/os-cloudpipes/");
		    request.header("Accept", "application/json");
		    request.returnType(Cloudpipes.class);
		return request;
		}

	}

	public static class CreateCloudpipe implements OpenStackCommand<Cloudpipe> {

		private Cloudpipe cloudpipe;
		
		public CreateCloudpipe(Cloudpipe cloudpipe) {
			this.cloudpipe = cloudpipe;
		}

		@Override
		public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.POST);
		    request.path("/os-cloudpipes/");
		    request.header("Accept", "application/json");
		    request.json(cloudpipe);
		    request.returnType(Cloudpipe.class);
		return request;
		}
		
	}

	public static ListCloudpipes listCloudpipes() {
		return new ListCloudpipes();
	}
	
	public static CreateCloudpipe createCloudpipe(Cloudpipe cloudpipe) {
		return new CreateCloudpipe(cloudpipe);
	}
	
}
