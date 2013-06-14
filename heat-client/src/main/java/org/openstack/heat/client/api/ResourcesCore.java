package org.openstack.heat.client.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.heat.client.HeatCommand;
import org.openstack.heat.model.Resource;
import org.openstack.heat.model.Resources;

public class ResourcesCore {
	private static final String stackPath = "stacks";
	private static final  String resourcePath = "resources";
	
	private static class ListResources implements HeatCommand<Resources>{
		private String stackID;
		
		public ListResources(String stackID){
			this.stackID = stackID;
		}
		@Override
		public Resources execute(WebTarget endpoint) {
			return endpoint.path(stackPath).path(stackID).path(resourcePath)
					.request(MediaType.APPLICATION_JSON).get(Resources.class);
		}
	}
	
	private static class ShowResource implements HeatCommand<Resource>{
		private String stackID;
		private String stackName;
		private String resourceName;
		
		public ShowResource(String stackID ,String stackName, String resourceName){
			this.stackID = stackID;
			this.stackName = stackName;
			this.resourceName = resourceName;
		}
		@Override
		public Resource execute(WebTarget endpoint) {
			return endpoint.path(stackPath).path(stackName).path(stackID).path(resourcePath).path(resourceName)
					.request(MediaType.APPLICATION_JSON).get(Resource.class);
		}
	}
	
	public static HeatCommand<Resources> listResources(String stackID){
		return new ListResources(stackID);
	}
	
	public static HeatCommand<Resource> showResource(String stackID , String stackName, String resourceName){
		return new ShowResource(stackID, stackName, resourceName);
	}
}
