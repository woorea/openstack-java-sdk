package org.openstack.heat.client.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.heat.client.HeatCommand;
import org.openstack.heat.client.HeatResourcesPath;
import org.openstack.heat.model.Stack;
import org.openstack.heat.model.StackForCreate;
import org.openstack.heat.model.Stacks;

public class StacksCore {

	private static class ListStacks implements HeatCommand<Stacks>{

		@Override
		public Stacks execute(WebTarget endpoint) {
			return endpoint.path(HeatResourcesPath.stackPath).request(MediaType.APPLICATION_JSON).get(Stacks.class);
		}
		
	}
	
	private static class ShowStack implements HeatCommand<Stack>{
		private String id;
		
		public ShowStack(String id){
			this.id = id;
		}
		
		@Override
		public Stack execute(WebTarget endpoint) {
			return endpoint.path(HeatResourcesPath.stackPath).path(id).request(MediaType.APPLICATION_JSON).get(Stack.class);
		}
	}
	
	private static class CreateStack implements HeatCommand<Response>{
		private StackForCreate stackForCreate;
		
		public CreateStack(StackForCreate stackForCreate) {
			super();
			this.stackForCreate = stackForCreate;
		}

		@Override
		public Response execute(WebTarget endpoint) {
			return endpoint.path(HeatResourcesPath.stackPath).request(MediaType.TEXT_PLAIN)
					.post(Entity.json(stackForCreate));
		}
		
	}
	
	private static class UpdateStack implements HeatCommand<Response>{
		private String stackName;
		private String stackID;
		private StackForCreate stackForCreate;
		
		public UpdateStack(String stackName, String stackID,
				StackForCreate stackForCreate) {
			super();
			this.stackName = stackName;
			this.stackID = stackID;
			this.stackForCreate = stackForCreate;
		}



		@Override
		public Response execute(WebTarget endpoint) {
			return endpoint.path(HeatResourcesPath.stackPath).path(stackName).path(stackID)
					.request(MediaType.TEXT_PLAIN).put(Entity.json(stackForCreate));
		}
		
	}
	
	private static class DeleteStack implements HeatCommand<Response>{
		private String id;
		
		public DeleteStack(String id) {
			super();
			this.id = id;
		}

		@Override
		public Response execute(WebTarget endpoint) {
			return endpoint.path(HeatResourcesPath.stackPath).path(id).request(MediaType.TEXT_PLAIN).delete();
		}
		
	}

	public static HeatCommand<Stacks> listStacks(){
		return new ListStacks();
	}
	
	public static HeatCommand<Stack> showStack(String id){
		return new ShowStack(id);
	}
	
	public static HeatCommand<Response> createStack(StackForCreate stackForCreate){
		return new CreateStack(stackForCreate);
	}
	
	public static HeatCommand<Response> updateStack(String stackName, String stackID,
			StackForCreate stackForCreate){
		return new UpdateStack(stackName,stackID,stackForCreate);
	}
	
	public static HeatCommand<Response> deleteStack(String id){
		return new DeleteStack(id);
	}
}
