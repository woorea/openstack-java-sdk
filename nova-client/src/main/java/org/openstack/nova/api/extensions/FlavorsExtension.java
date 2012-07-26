package org.openstack.nova.api.extensions;

import java.util.UUID;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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
		public Flavor execute(WebTarget target) {
			if(flavorForCreate.getId() == null) {
				flavorForCreate.setId(UUID.randomUUID().toString());
			}
			return target.path("flavors").request(MediaType.APPLICATION_JSON).post(Entity.json(flavorForCreate), Flavor.class);
		}
		
	}

	public static class DeleteFlavor implements NovaCommand<Void> {

		private String id;
		
		public DeleteFlavor(String id) {
			this.id = id;
		}

		@Override
		public Void execute(WebTarget target) {
			target.path("flavors").path(id).request(MediaType.APPLICATION_JSON).delete();
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
