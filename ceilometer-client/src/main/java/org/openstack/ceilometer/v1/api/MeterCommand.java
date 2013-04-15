package org.openstack.ceilometer.v1.api;

import org.openstack.base.client.OpenStackCommand;

public abstract class MeterCommand<R> implements OpenStackCommand<R> {

	protected String source;
	
	protected String project;
	
	protected String user;
	
	protected String resource;
	
	public MeterCommand<R> source(String source) {
		this.source = source;
		return this;
	}
	
	public MeterCommand<R> project(String project) {
		this.project = project;
		return this;
	}
	
	public MeterCommand<R> user(String user) {
		this.user = user;
		return this;
	}
	
	

}
