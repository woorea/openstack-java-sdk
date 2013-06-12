package org.openstack.heat.client.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.heat.client.HeatCommand;
import org.openstack.heat.client.HeatResourcesPath;
import org.openstack.heat.model.Event;
import org.openstack.heat.model.Events;

public class EventsCore {
	
	private static class ListStackEvents implements HeatCommand<Events>{
		private String stackID;
		private String stackName;
		
		public ListStackEvents(String stackID, String stackName) {
			super();
			this.stackID = stackID;
			this.stackName = stackName;
		}

		@Override
		public Events execute(WebTarget endpoint) {
			return endpoint.path(HeatResourcesPath.stackPath).path(stackName).path(stackID).path(HeatResourcesPath.eventPath)
					.request(MediaType.APPLICATION_JSON).get(Events.class);
		}
		
	}
	
	private static class ListResourceEvents implements HeatCommand<Events>{
		private String stackID;
		private String stackName;
		private String resourceName;
		
		public ListResourceEvents(String stackID, String stackName,
				String resourceName) {
			super();
			this.stackID = stackID;
			this.stackName = stackName;
			this.resourceName = resourceName;
		}

		@Override
		public Events execute(WebTarget endpoint) {
			return endpoint.path(HeatResourcesPath.stackPath).path(stackName).path(stackID).
					path(HeatResourcesPath.resourcePath).path(resourceName).path(HeatResourcesPath.eventPath)
					.request(MediaType.APPLICATION_JSON).get(Events.class);
		}
		
	}
	
	private static class ShowEvent implements HeatCommand<Event>{
		private String stackID;
		private String stackName;
		private String resourceName;
		private String eventID;
		
		public ShowEvent(String stackID, String stackName,
				String resourceName, String eventID) {
			super();
			this.stackID = stackID;
			this.stackName = stackName;
			this.resourceName = resourceName;
			this.eventID = eventID;
		}

		@Override
		public Event execute(WebTarget endpoint) {
			return endpoint.path(HeatResourcesPath.stackPath).path(stackName).path(stackID).
					path(HeatResourcesPath.resourcePath).path(resourceName).
					path(HeatResourcesPath.eventPath).path(eventID)
					.request(MediaType.APPLICATION_JSON).get(Event.class);
		}
	}
	
	public static HeatCommand<Events> listStackEvents(String stackID, String stackName){
		return new ListStackEvents(stackID, stackName);
	}
	
	public static HeatCommand<Events> listResourceEvents(String stackID, String stackName, String resourceName){
		return new ListResourceEvents(stackID, stackName ,resourceName);
	}
	
	public static HeatCommand<Event> showEvent(String stackID, String stackName, String resourceName, String eventID){
		return new ShowEvent(stackID, stackName ,resourceName, eventID);
	}
}
