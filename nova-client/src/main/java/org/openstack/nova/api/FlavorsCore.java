package org.openstack.nova.api;

import java.util.Map;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Flavor;
import org.openstack.nova.model.Flavors;
import org.openstack.nova.model.Metadata;

public class FlavorsCore {
	
	public static class ListFlavors implements NovaCommand<Flavors>{

		boolean detail;
		
		public ListFlavors(boolean detail) {
			this.detail = detail;
		}
		
		public ListFlavors() {
			this(false);
		}

		@Override
		public Flavors execute(WebTarget target) {
			String path = detail ? "flavors/detail" : "flavors";
			return target.path(path).request(MediaType.APPLICATION_JSON).get(Flavors.class);
		}

	}
	
	public static class ShowFlavor implements NovaCommand<Flavor> {

		private String id;
		
		public ShowFlavor(String id) {
			this.id = id;
		}

		@Override
		public Flavor execute(WebTarget target) {
			return target.path("flavors").path(id).request(MediaType.APPLICATION_JSON).get(Flavor.class);
		}
		
	}

	
	public static class ShowFlavorMetadata implements NovaCommand<Map<String, String>> {

		private String id;
		
		public ShowFlavorMetadata(String id) {
			this.id = id;
		}

		@Override
		public Map<String, String> execute(WebTarget target) {
			Metadata metadata = target.path("flavors").path(id).path("metadata").request(MediaType.APPLICATION_JSON).get(Metadata.class);
			return metadata.getMetadata();
		}
		
	}
	
	public static ListFlavors listFlavors(boolean detail) {
		return new ListFlavors(detail);
	}
	
	public static ListFlavors listFlavors() {
		return listFlavors(false);
	}
	
	public static ShowFlavor showFlavor(String id) {
		return new ShowFlavor(id);
	}
	
	public static ShowFlavorMetadata showFlavorMetadata() {
		return new ShowFlavorMetadata("");
	}

}
