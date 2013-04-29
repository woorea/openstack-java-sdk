package org.openstack.nova.api.extensions;

import java.util.UUID;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Flavor;
import org.openstack.nova.model.FlavorForCreate;

public class FlavorsExtension {
	
	public static class CreateFlavor extends OpenStackRequest {

		private FlavorForCreate flavorForCreate;
		
		public CreateFlavor(FlavorForCreate flavorForCreate) {
			this.flavorForCreate = flavorForCreate;
			
			if(flavorForCreate.getId() == null) {
				flavorForCreate.setId(UUID.randomUUID().toString());
			}
			method(HttpMethod.POST);
		    path("/flavors/");
		    header("Accept", "application/json");
		    json(flavorForCreate);
		    returnType(Flavor.class);
		}
		
	}

	public static class DeleteFlavor extends OpenStackRequest {
		
		public DeleteFlavor(String id) {
			method(HttpMethod.DELETE);
		    path("/flavors/").path(id);
		    header("Accept", "application/json");
		}
		
	}
	
	public static CreateFlavor createFlavor(FlavorForCreate flavorForCreate) {
		return new CreateFlavor(flavorForCreate);
	}
	
	public static DeleteFlavor deleteFlavor(String id) {
		return new DeleteFlavor(id);
	}
	
}
