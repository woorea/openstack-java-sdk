//package org.openstack.ceilometer.client;
//
//import java.util.logging.Logger;
//
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientFactory;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;
//
//import org.glassfish.jersey.filter.LoggingFilter;
//import org.glassfish.jersey.media.json.JsonJacksonFeature;
//import org.openstack.ceilometer.model.Extension;
//import org.openstack.ceilometer.model.Extensions;
//import org.openstack.ceilometer.model.MeterEvents;
//import org.openstack.ceilometer.model.Projects;
//import org.openstack.ceilometer.model.ResourceAggregations;
//import org.openstack.ceilometer.model.Resources;
//import org.openstack.ceilometer.model.Sources;
//import org.openstack.ceilometer.model.Users;
//import org.openstack.ceilometer.model.Version;
//
//public class CeilometerClient {
//
//	public static void main(String[] args) {
//		Client client = ClientFactory.newClient();
//		client.configuration().register(new JsonJacksonFeature());
//		WebTarget endpoint = client.target("http://localhost:8989/v1");
//		endpoint.configuration().register(new LoggingFilter(Logger.getLogger("ceilometer"), true));
//		
//		//version
//		endpoint.request(MediaType.APPLICATION_XML).get(Version.class);
//		endpoint.path("extensions").request(MediaType.APPLICATION_XML).get(Extensions.class);
//		endpoint.path("extensions/alias").request(MediaType.APPLICATION_XML).get(Extension.class);
//		endpoint.path("sources").request(MediaType.APPLICATION_JSON).get(Sources.class);
//		endpoint.path("sources/source/list/resources").request(MediaType.APPLICATION_JSON).get(Resources.class);
//		endpoint.path("sources/source/users").request(MediaType.APPLICATION_JSON).get(Users.class);
//		endpoint.path("sources/source/users/2").request(MediaType.APPLICATION_JSON).get(MeterEvents.class);
//		endpoint.path("sources/source/users/2/meter").request(MediaType.APPLICATION_JSON).get(MeterEvents.class);
//		endpoint.path("sources/source/users/2/meter/volume").request(MediaType.APPLICATION_JSON).get(ResourceAggregations.class);
//		endpoint.path("sources/source/users/2/meter/duration").request(MediaType.APPLICATION_JSON).get(ResourceAggregations.class);
//		endpoint.path("sources/source/users/2/resources").request(MediaType.APPLICATION_JSON).get(Resources.class);
//		endpoint.path("sources/source/projects").request(MediaType.APPLICATION_JSON).get(Projects.class);
//		endpoint.path("sources/source/projects/1").request(MediaType.APPLICATION_JSON).get(MeterEvents.class);
//		endpoint.path("sources/source/projects/1/meter").request(MediaType.APPLICATION_JSON).get(MeterEvents.class);
//		endpoint.path("sources/source/projects/1/meter/volume").request(MediaType.APPLICATION_JSON).get(ResourceAggregations.class);
//		endpoint.path("sources/source/projects/1/meter/duration").request(MediaType.APPLICATION_JSON).get(ResourceAggregations.class);
//		
//		System.exit(0);
//	
//	}
//	
//}
