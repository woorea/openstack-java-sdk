package org.openstack.model.compute.nova.cloudpipe;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;


@JsonRootName("cloudpipe")
public class NovaCloudPipeForCreate implements Serializable {

	@JsonProperty("project_id")
	private String projectId;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
}
