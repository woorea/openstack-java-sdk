package org.openstack.nova.api.extensions;

import java.util.UUID;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Flavor;
import org.openstack.nova.model.FlavorForCreate;

public class FlavorsExtension {
	
	public static class CreateFlavor implements NovaCommand<Flavor> {

		private FlavorForCreate flavorForCreate;
		
		public CreateFlavor(FlavorForCreate flavorForCreate) {
			this.flavorForCreate = flavorForCreate;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
			OpenStackRequest request = client.newOpenStackRequest();
			if(flavorForCreate.getId() == null) {
				flavorForCreate.setId(UUID.randomUUID().toString());
			}
			request.method(HttpMethod.POST);
		    request.path("/flavors/");
		    request.header("Accept", "application/json");
		    request.json(flavorForCreate);
		    request.returnType(Flavor.class);
		return request;
		}
		
	}

	public static class DeleteFlavor implements NovaCommand<Void> {

		private String id;
		
		public DeleteFlavor(String id) {
			this.id = id;
		}

		@Override
		public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.DELETE);
		    request.path("/flavors/").path(id);
		    request.header("Accept", "application/json");
		    
			return null;
		}
		
	}
	
	public static CreateFlavor createFlavor(FlavorForCreate flavorForCreate) {
		return new CreateFlavor(flavorForCreate);
	}
	
	public static DeleteFlavor deleteFlavor(String id) {
		return new DeleteFlavor(id);
	}
	
}
