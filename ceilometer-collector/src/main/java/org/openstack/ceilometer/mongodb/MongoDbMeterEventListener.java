package org.openstack.ceilometer.mongodb;

import java.util.HashMap;

import org.openstack.ceilometer.collector.handlers.MeterEventListener;
import org.openstack.ceilometer.model.MeterEvent;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.Mongo;

public class MongoDbMeterEventListener implements MeterEventListener {

	private static final Integer ASC = 1;
	private static final Integer DESC = -1;

	private String host = "localhost";

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
			
			// # We need variations for user_id vs. project_id because of the
			// # way the indexes are stored in b-trees. The user_id and
			// # project_id values are usually mutually exclusive in the
			// # queries, so the database won't take advantage of an index
			// # including both.
			for (final String k : new String[] { "user_id", "project_id" }) {
				db.getCollection("resource").ensureIndex(
						new BasicDBObject(new HashMap<String, Integer>() {
							{
								put(k, ASC);
								put("source", ASC);
							}
						}), "resource-" + k + "-index", true);
				db.getCollection("resource").ensureIndex(
						new BasicDBObject(new HashMap<String, Integer>() {
							{
								put("resource_id", ASC);
								put(k, ASC);
								put("counter_name", ASC);
								put("timestamp", ASC);
								put("source", ASC);
							}
						}), "meter-" + k + "-index", true);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}

	}

	@Override
	public void onMeterEvent(MeterEvent data) {
		// # Make sure we know about the user and project
		db.getCollection("user").update(
				new BasicDBObject("_id", data.getUserId()),
				BasicDBObjectBuilder.start().push("$addToSet")
						.add("source", data.getSource()).pop().get(), true,
				false);
		db.getCollection("project").update(
				new BasicDBObject("_id", data.getProjectId()),
				BasicDBObjectBuilder.start().push("$addToSet")
						.add("source", data.getSource()).pop().get(), true,
				false);
		// # Record the updated resource metadata
		long timestamp = System.currentTimeMillis();
		db.getCollection("resource").update(
				new BasicDBObject("_id", data.getResourceId()),
				BasicDBObjectBuilder.start().push("$set")
						.add("project_id", data.getProjectId())
						.add("user_id", data.getUserId())
						.add("timestamp", timestamp)
						.add("metadata", data.getMetadata()).pop()
						.push("$addToSet").push("meter")
						.add("counter_name", data.getName())
						.add("counter_type", data.getType()).pop().pop().get(),
				true, false);

		db.getCollection("meter").insert(
				new BasicDBObjectBuilder().add("source", data.getSource())
						.add("name", data.getName())
						.add("type", data.getType())
						.add("volume", data.getVolume())
						.add("project_id", data.getProjectId())
						.add("user_id", data.getUserId())
						.add("resource_id", data.getResourceId())
						.add("timestamp", data.getTimestamp())
						.add("metadata", data.getMetadata()).get());
	}

}
