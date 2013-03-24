package org.openstack.nova.api.extensions;

import java.util.UUID;

import org.openstack.base.client.OpenStackClientConnector;
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
		public Flavor execute(OpenStackClientConnector connector, OpenStackRequest request) {
			if(flavorForCreate.getId() == null) {
				flavorForCreate.setId(UUID.randomUUID().toString());
			}
			request.method("POST");
		    request.path("/flavors/");
		    request.header("Accept", "application/json");
		    request.json(flavorForCreate);
		    return connector.execute(request, Flavor.class);
		}
		
	}

	public static class DeleteFlavor implements NovaCommand<Void> {

		private String id;
		
		public DeleteFlavor(String id) {
			this.id = id;
		}

		@Override
		public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
			request.method("DELETE");
		    request.path("/flavors/").path(id);
		    request.header("Accept", "application/json");
		    connector.execute(request);
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
