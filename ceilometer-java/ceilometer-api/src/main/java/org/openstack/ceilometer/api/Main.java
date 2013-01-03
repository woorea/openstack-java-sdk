package org.openstack.ceilometer.api;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.Properties;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.media.json.JsonJacksonBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {

	public static final String CONFIG_FILE_PATH = "/etc/ceilometer/ceilometer-api.properties";

	public static void main(String[] args) throws Exception {
		
		File propertiesFile = new File(CONFIG_FILE_PATH);
		
		Properties properties = new Properties();
		if(!propertiesFile.exists()) {
			System.out.println(String.format("%s not found, using default values", CONFIG_FILE_PATH));
		} else {
			properties.load(new FileInputStream(propertiesFile));
		}
		
		MongoDbBinder mongoDbBinder = new MongoDbBinder();
		
		mongoDbBinder.setHost(properties.getProperty("mongodb.host", "192.168.1.38"));
		mongoDbBinder.setPort(Integer.parseInt(properties.getProperty("mongodb.port", "27017")));
		mongoDbBinder.setDbname(properties.getProperty("mongodb.dbname", "ceilometer"));
		mongoDbBinder.setUsername(properties.getProperty("mongodb.username", null));
		mongoDbBinder.setUsername(properties.getProperty("mongodb.password", null));
		
		ResourceConfig config = new ResourceConfig()
			//.packages("org.openstack.ceilometer.api")
			.addClasses(CeilometerApiV1.class)
			.addSingletons(new JsonJacksonBinder())
			.addSingletons(mongoDbBinder);
			//.addModules(new JsonJacksonModule())
			//.addSingletons(api);
		
		URI baseUri = URI.create(properties.getProperty("base_uri","http://localhost:8989/")) ;
		
		final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
		
		System.out.println(String.format("Application started.%nTry out %s%nHit enter to stop it...", baseUri));
        System.in.read();
        server.stop();

	}

}
