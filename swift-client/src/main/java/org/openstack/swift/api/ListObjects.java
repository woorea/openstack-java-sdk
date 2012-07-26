package org.openstack.swift.api;

import java.util.List;
import java.util.Map;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.openstack.swift.SwiftCommand;
import org.openstack.swift.model.Object;

public class ListObjects implements SwiftCommand<List<Object>>{

	private String containerName;
	
	private Map<String, String> filters;
	
	public ListObjects(String containerName, Map<String, String> filters) {
		this.containerName = containerName;
		this.filters = filters;
	}
	
	@Override
	public List<Object> execute(WebTarget target) {
		target = target.path(containerName);
		for(String filter : new String[]{"prefix","delimiter","path"}) {
			if(filters.get(filter) != null) {
				target = target.queryParam(filter, filters.get(filter));
			}
		}
		return target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Object>>(){});
	}

}
