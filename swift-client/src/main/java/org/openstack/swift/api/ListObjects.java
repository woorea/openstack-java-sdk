package org.openstack.swift.api;

import java.util.Map;

import org.openstack.base.client.OpenStackRequest;

public class ListObjects extends OpenStackRequest {

	private String containerName;
	
	private Map<String, String> filters;
	
	public ListObjects(String containerName, Map<String, String> filters) {
		this.containerName = containerName;
		this.filters = filters;
		//returnType(new TypeToken<List<Object>>(){});
//		target = target.path(containerName);
//		for(String filter : new String[]{"prefix","delimiter","path","marker"}) {
//			if(filters.get(filter) != null) {
//				target = target.queryParam(filter, filters.get(filter));
//			}
//		}
//		return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Object>>(){});
	}
	
}
