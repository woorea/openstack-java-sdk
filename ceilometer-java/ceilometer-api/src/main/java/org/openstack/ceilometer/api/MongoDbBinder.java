package org.openstack.ceilometer.api;

import org.glassfish.jersey.internal.inject.AbstractBinder;

public class MongoDbBinder extends AbstractBinder {
	
	private String host;
	
	private Integer port;
	
	private String dbname;
	
	private String username;
	
	private String password;

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * @param dbname the dbname to set
	 */
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	protected void configure() {
		MongoDbService mongoDbService = new MongoDbService();
		mongoDbService.setHost(host);
		mongoDbService.setPort(port);
		mongoDbService.setDbname(dbname);
		mongoDbService.setUsername(username);
		mongoDbService.setPassword(password);
		mongoDbService.start();
		bind(mongoDbService).to(MongoDbService.class);
	}
	
}
