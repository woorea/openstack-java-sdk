package org.openstack.model.compute.nova.cloudpipe;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NovaCloudPipes {

	@JsonProperty("cloudpipes")
	private List<NovaCloudPipes> list = new ArrayList<NovaCloudPipes>();

	public List<NovaCloudPipes> getList() {
		return list;
	}
	
}
