package org.openstack.swift.api;

import java.util.List;
import java.util.Map;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.swift.model.Object;

public class ListObjects implements OpenStackCommand<List<Object>>{

	private String containerName;
	
	private Map<String, String> filters;
	
	public ListObjects(String containerName, Map<String, String> filters) {
		this.containerName = containerName;
		this.filters = filters;
	}
	
	@Override
	public OpenStackRequest execute(OpenStackClient client) {
//		target = target.path(containerName);
//		for(String filter : new String[]{"prefix","delimiter","path","marker"}) {
//			if(filters.get(filter) != null) {
//				target = target.queryParam(filter, filters.get(filter));
//			}
//		}
//		return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Object>>(){});
		return null;
	}

}
