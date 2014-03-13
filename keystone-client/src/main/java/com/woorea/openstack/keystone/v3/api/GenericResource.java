package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;

public class GenericResource<One, Many> {

	protected final OpenStackClient CLIENT;
	
	protected CharSequence path;
	
	protected Class<One> oneClass;
	protected Class<Many> manyClass;
	
	public GenericResource(OpenStackClient client, CharSequence path, Class<One> oneClass, Class<Many> manyClass) {
		CLIENT = client;
		this.path = path;
		this.oneClass = oneClass;
		this.manyClass = manyClass;
	}
	
	public OpenStackRequest<Many> list() {
		return new OpenStackRequest<Many>(CLIENT, HttpMethod.GET, path, null, manyClass);
	}
	
	public OpenStackRequest<One> create(One one) {
		return new OpenStackRequest<One>(CLIENT, HttpMethod.POST, path, Entity.json(one), oneClass);
	}
	
	public OpenStackRequest<One> show(String id) {
		return new OpenStackRequest<One>(CLIENT, HttpMethod.GET, new StringBuilder(path).append("/").append(id).toString(), null, oneClass);
	}
	
	public OpenStackRequest<One> update(String id, One one) {
		return new OpenStackRequest<One>(CLIENT, HttpMethod.PATCH, new StringBuilder(path).append("/").append(id).toString(), Entity.json(one), oneClass);
	}
	
	public OpenStackRequest<One> delete(String id) {
		return new OpenStackRequest<One>(CLIENT, HttpMethod.DELETE, new StringBuilder(path).append("/").append(id).toString(), null, oneClass);
	}
	
}
