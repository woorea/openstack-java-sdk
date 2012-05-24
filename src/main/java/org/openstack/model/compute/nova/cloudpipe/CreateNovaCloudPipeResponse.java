package org.openstack.model.compute.nova.cloudpipe;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class CreateNovaCloudPipeResponse implements Serializable {
	
	
	@JsonProperty("instance_id")
	private String instanceId;

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	
}
