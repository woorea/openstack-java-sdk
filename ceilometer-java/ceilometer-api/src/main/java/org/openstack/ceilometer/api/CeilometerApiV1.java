package org.openstack.ceilometer.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.model.Extension;
import org.openstack.ceilometer.model.Extensions;
import org.openstack.ceilometer.model.MeterEvents;
import org.openstack.ceilometer.model.Projects;
import org.openstack.ceilometer.model.ResourceAggregations;
import org.openstack.ceilometer.model.Resources;
import org.openstack.ceilometer.model.Sources;
import org.openstack.ceilometer.model.Users;
import org.openstack.ceilometer.model.Version;
import org.openstack.ceilometer.model.Projects.Project;
import org.openstack.ceilometer.model.Users.User;

@Path("v1")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
public class CeilometerApiV1 {
	
	@Inject
	private MongoDbService service;
	
	@GET
	public Version version() {
		return new Version();
	}
	
	@GET
	@Path("/extensions")
	public Extensions getExtensions() {
		return new Extensions();
	}
	
	@GET
	@Path("/extensions/{alias}")
	public Extension getExtension(@PathParam("alias") String alias) {
		Extension extension = new Extension();
		extension.setAlias(alias);
		return extension;
	}
	
	@GET
	@Path("/sources")
	public Sources getSources(@QueryParam("start") String start, @QueryParam("end") String end) {
		return new Sources();
	}
	
	@GET
	@Path("/sources/{source}/list/resources")
	public Resources getResources(@PathParam("source") String source, @QueryParam("start") String start, @QueryParam("end") String end) {
		Resources root = new Resources();
		root.getResources().addAll(service.getResources(source, null, null));
		return root;
	}
	
	@GET
	@Path("/sources/{source}/users")
	public Users getUsers(@PathParam("source") String source, @QueryParam("start") String start, @QueryParam("end") String end) {
		Users root = new Users();
		for(String userId : service.getUsers(source)) {
			User user = new User();
			user.setId(userId);
			root.getUsers().add(user);
		}
		return root;
	}
	
	@GET
	@Path("/sources/{source}/users/{user}")
	public MeterEvents getRawEventsByUser(@PathParam("source") String source, @PathParam("user") String user, @QueryParam("start") String start, @QueryParam("end") String end) {
		EventFilter filter = new EventFilter();
		//filter.setSource(source);
		filter.setUser(user);
		MeterEvents root = new MeterEvents();
		root.getMeterEvents().addAll(service.getRawEvents(filter));
		return root;
	}
	
	@GET
	@Path("/sources/{source}/users/{user}/{meter}")
	public MeterEvents getRawEventsByUserAndMeter(@PathParam("source") String source, @PathParam("user") String user, @PathParam("meter") String meter, @QueryParam("start") String start, @QueryParam("end") String end) {
		EventFilter filter = new EventFilter();
		//filter.setSource(source);
		filter.setUser(user);
		filter.setMeter(meter);
		MeterEvents root = new MeterEvents();
		root.getMeterEvents().addAll(service.getRawEvents(filter));
		return root;
	}
	
	@GET
	@Path("/sources/{source}/users/{user}/{meter}/volume")
	public ResourceAggregations getVolumeSumByUserAndMeter(@PathParam("source") String source, @PathParam("user") String user, @PathParam("meter") String meter, @QueryParam("start") String start, @QueryParam("end") String end) {
		EventFilter filter = new EventFilter();
		//filter.setSource(source);
		filter.setUser(user);
		filter.setMeter(meter);
		ResourceAggregations root = new ResourceAggregations();
		root.getAggregations().addAll(service.getVolumeSum(filter));
		return root;
	}
	
	@GET
	@Path("/sources/{source}/users/{user}/{meter}/duration")
	public ResourceAggregations getDurationSumByUserAndMeter(@PathParam("source") String source, @PathParam("user") String user, @PathParam("meter") String meter, @QueryParam("start") String start, @QueryParam("end") String end) {
		EventFilter filter = new EventFilter();
		//filter.setSource(source);
		filter.setUser(user);
		filter.setMeter(meter);
		ResourceAggregations root = new ResourceAggregations();
		root.getAggregations().addAll(service.getDurationSum(filter));
		return root;
	}
	
	@GET
	@Path("/sources/{source}/users/{user}/resources")
	public Resources getResourcesByUser(@PathParam("source") String source, @PathParam("user") String user, @QueryParam("start") String start, @QueryParam("end") String end) {
		EventFilter filter = new EventFilter();
		//filter.setSource(source);
		filter.setUser(user);
		Resources root = new Resources();
		root.getResources().addAll(service.getResources(source, null, user));
		return root;
	}
	
	
	@GET
	@Path("/sources/{source}/projects")
	public Projects getProjects(@PathParam("source") String source, @QueryParam("start") String start, @QueryParam("end") String end) {
		Projects root = new Projects();
		for(String projectId : service.getProjects(source)) {
			Project project = new Project();
			project.setId(projectId);
			root.getProjects().add(project);
		}
		return root;
	}
	
	@GET
	@Path("/sources/{source}/projects/{project}")
	public MeterEvents getRawEventsByProject(@PathParam("source") String source, @PathParam("project") String project, @QueryParam("start") String start, @QueryParam("end") String end) {
		EventFilter filter = new EventFilter();
		//filter.setSource(source);
		filter.setProject(project);
		MeterEvents root = new MeterEvents();
		root.getMeterEvents().addAll(service.getRawEvents(filter));
		return root;
	}
	
	@GET
	@Path("/sources/{source}/projects/{project}/{meter}")
	public MeterEvents getRawEventsByProjectAndMeter(@PathParam("source") String source, @PathParam("project") String project, @PathParam("meter") String meter, @QueryParam("start") String start, @QueryParam("end") String end) {
		EventFilter filter = new EventFilter();
		//filter.setSource(source);
		filter.setProject(project);
		MeterEvents root = new MeterEvents();
		root.getMeterEvents().addAll(service.getRawEvents(filter));
		return root;
	}
	
	@GET
	@Path("/sources/{source}/projects/{project}/{meter}/volume")
	public ResourceAggregations getVolumeSumByProjectAndMeter(@PathParam("source") String source, @PathParam("project") String project, @PathParam("meter") String meter, @QueryParam("start") String start, @QueryParam("end") String end) {
		EventFilter filter = new EventFilter();
		//filter.setSource(source);
		filter.setProject(project);
		filter.setMeter(meter);
		ResourceAggregations root = new ResourceAggregations();
		root.getAggregations().addAll(service.getVolumeSum(filter));
		return root;
	}
	
	@GET
	@Path("/sources/{source}/projects/{project}/{meter}/duration")
	public ResourceAggregations getDurationSumByProjectAndMeter(@PathParam("source") String source, @PathParam("project") String project, @PathParam("meter") String meter, @QueryParam("start") String start, @QueryParam("end") String end) {
		EventFilter filter = new EventFilter();
		//filter.setSource(source);
		filter.setProject(project);
		filter.setMeter(meter);
		ResourceAggregations root = new ResourceAggregations();
		root.getAggregations().addAll(service.getDurationSum(filter));
		return root;
	}

}
