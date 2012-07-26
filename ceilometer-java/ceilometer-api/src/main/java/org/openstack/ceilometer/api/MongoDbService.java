package org.openstack.ceilometer.api;

import java.util.ArrayList;
import java.util.List;

import org.openstack.ceilometer.model.Metadata;
import org.openstack.ceilometer.model.MeterEvent;
import org.openstack.ceilometer.model.ResourceAggregations;
import org.openstack.ceilometer.model.ResourceAggregations.ResourceAggregation;
import org.openstack.ceilometer.model.Resources;
import org.openstack.ceilometer.model.Resources.Resource.Meter;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.Mongo;

public class MongoDbService {

	//# JavaScript function for doing map-reduce to get a counter volume total.
	private String mapCounterVolume = "function() { emit(this.resource_id, this.volume); }";
	
	//# JavaScript function for doing map-reduce to get a counter duration total.
	private String mapCounterDuration = "function() { emit(this.resource_id, this.duration); }";
	
	//# JavaScript function for doing map-reduce to get a maximum value from a range.  (from http://cookbook.mongodb.org/patterns/finding_max_and_min/)
	private String reduceMax = "function (key, values) { return Math.max.apply(Math, values); }";
	
	//# JavaScript function for doing map-reduce to get a sum.
	private String reduceSum = "function (key, values) { var total = 0; for (var i = 0; i < values.length; i++) { total += values[i]; } return total; }";
	
	private String host = "192.168.1.38";
	
	private int port = 27017;

	private String dbname = "ceilometer";
	
	private String username;
	
	private String password;
	
	private Mongo mongo;
	
	private DB db;
	
	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void start() {
		try {
			mongo = new Mongo(host, port);
			db = mongo.getDB(dbname);
			if(username != null && password != null && !db.authenticate(username, password.toCharArray())) {
				new RuntimeException("auth"); 
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}
	
	public static final DBObject createFilter(EventFilter filter) {
		
		BasicDBObjectBuilder builder = new BasicDBObjectBuilder();
		
		if(filter != null) {
			if(filter.getUser() != null) {
				builder.add("user_id", filter.getUser());
			} else if(filter.getProject() != null) {
				builder.add("project_id", filter.getProject());
			}
			if(filter.getMeter() != null) {
				builder.add("name", filter.getMeter());
			}
			if(filter.getStart() != null) {
				builder.add("start", new BasicDBObject("$gte", filter.getStart()));
			}
			if(filter.getEnd() != null) {
				builder.add("end", new BasicDBObject("$lt", filter.getEnd()));
			}
			if(filter.getResource() != null) {
				builder.add("resource_id", filter.getResource());
			}
			if(filter.getSource() != null) {
				builder.add("source", filter.getSource());
			}
		}
		
		return builder.get();
	
	}
	
	/**
	 * Return an iterable of user id strings.
	 * 
	 * @param source
	 */
	public List<String> getUsers(String source) {
		List<String> users = new ArrayList<String>();
		DBObject query = null;
		if(source != null) {
			query = new BasicDBObject("source", source);
		}
		List l = db.getCollection("user").distinct("_id");
		for(Object o : l) {
			if(o != null) {
				users.add(o.toString());
			}
		}
		return users;
		
	}
	
	public List<String> getProjects(String source) {
		List<String> projects = new ArrayList<String>();
		DBObject query = null;
		if(source != null) {
			query = new BasicDBObject("source", source);
		}
		List l = db.getCollection("project").distinct("_id");
		for(Object o : l) {
			if(o != null) {
				projects.add(o.toString());
			}
		}
		return projects;

	}
	/**
	 * Return an iterable of dictionaries containing resource information.
	 * 
	 * @param user
	 * @param project
	 * @param source
	 */
	public List<Resources.Resource> getResources(String source, String project, String user) {
		
		BasicDBObjectBuilder dboBuilder = new BasicDBObjectBuilder();
		
		if(source != null) {
			//dboBuilder.add("source", user);
		} 
		
		if(project != null) {
			dboBuilder.add("project_id", user);
		}

		if(user != null) {
			dboBuilder.add("user_id", user);
		}
		
		
		DBCursor dbCursor = db.getCollection("resource").find(dboBuilder.get());
		List<Resources.Resource> resources = new ArrayList<Resources.Resource>();
		for(DBObject dbo : dbCursor) {
			Resources.Resource resource = new Resources.Resource();
			resource.setId((String) dbo.get("_id"));
			resource.setProjectId((String) dbo.get("project_id"));
			resource.setUserId((String) dbo.get("user_id"));
			resource.setTimestamp((Long) dbo.get("timestamp"));
			Object metadataDbo = dbo.get("metadata");
			//null System.out.println(metadataDbo.getClass().getCanonicalName());
			Metadata metadata = new Metadata();
			resource.setMetadata(metadata);
			List<Meter> meters = new ArrayList<Meter>();
			BasicDBList dbList = (BasicDBList) dbo.get("meter");
			for(Object o : dbList) {
				if(o != null && o instanceof DBObject) {
					DBObject meterDbo = (DBObject) o;
					Meter meter = new Meter();
					meter.setName((String) meterDbo.get("counter_name"));
					meter.setType((String) meterDbo.get("counter_type"));
				}
			}
			resource.setMeters(meters);
			resources.add(resource);
		}
		return resources;
	}
	
	public List<MeterEvent> getRawEvents(EventFilter eventFilter) {
		
		List<MeterEvent> events = new ArrayList<MeterEvent>();
		
		DBObject query = createFilter(eventFilter);
		
		System.out.println(query);
		
		DBCursor dbCursor = db.getCollection("meter").find(query);
		
		for(DBObject dbo : dbCursor) {
			MeterEvent m = new MeterEvent();
			m.setName((String) dbo.get("name")); 
			m.setType((String) dbo.get("type"));
			m.setResourceId((String) dbo.get("resource_id"));
			m.setVolume((Number) dbo.get("volume"));
			events.add(m);
		}
		
		return events;

	}
	
	public List<ResourceAggregations.ResourceAggregation> getVolumeSum(EventFilter eventFilter) {
		
		DBObject query = createFilter(eventFilter);
		
		MapReduceOutput output = db.getCollection("meter").mapReduce(mapCounterVolume, reduceSum, null, MapReduceCommand.OutputType.INLINE, query);
		
		List<ResourceAggregation> results = new ArrayList<ResourceAggregation>();
		
		for(DBObject dbo : output.results()) {
			ResourceAggregation result = new ResourceAggregation();
			result.setResourceId((String) dbo.get("_id"));
			result.setValue((Number) dbo.get("value"));
			results.add(result);
		}
		
		return results;

	}
	
	public List<ResourceAggregations.ResourceAggregation> getVolumeMax(EventFilter eventFilter) {
		
		DBObject query = createFilter(eventFilter);
		
		MapReduceOutput output = db.getCollection("meter").mapReduce(mapCounterVolume, reduceMax, null, MapReduceCommand.OutputType.INLINE, query);
			
		List<ResourceAggregation> results = new ArrayList<ResourceAggregation>();
		
		for(DBObject dbo : output.results()) {
			ResourceAggregation result = new ResourceAggregation();
			result.setResourceId((String) dbo.get("_id"));
			result.setValue((Number) dbo.get("value"));
			results.add(result);
		}
		
		return results;

	}
	
	public List<ResourceAggregation> getDurationSum(EventFilter eventFilter) {
		
		DBObject query = createFilter(eventFilter);
		
		MapReduceOutput output = db.getCollection("meter").mapReduce(mapCounterDuration, reduceMax, null, MapReduceCommand.OutputType.INLINE, query);
		
		List<ResourceAggregation> results = new ArrayList<ResourceAggregation>();
		
		for(DBObject dbo : output.results()) {
			ResourceAggregation result = new ResourceAggregation();
			result.setResourceId((String) dbo.get("_id"));
			result.setValue((Number) dbo.get("value"));
			results.add(result);
		}
		
		return results;
		
	}

}
