package com.woorea.openstack.base.client;

import java.io.InputStream;
import java.util.Map;

public interface OpenStackResponse {

	public <T> T getEntity(Class<T> returnType);

	public InputStream getInputStream();

	public String header(String name);
	
	public Map<String, String> headers();
	
}
