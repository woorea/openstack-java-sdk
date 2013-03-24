package org.openstack.base.client;

import com.google.common.reflect.TypeToken;

public interface OpenStackClientConnector {

	public <T> T execute(OpenStackRequest request, Class<T> responseType);
	
	public <T> T execute(OpenStackRequest request, TypeToken<T> typeToken);

	public void execute(OpenStackRequest request);

}
