package org.openstack.model.compute.nova.cloudpipe;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class NovaCloudPipe implements Serializable {
	
	@JsonProperty("project_id")
	private String tenantId;
	
	private String state;
	
	@JsonProperty("instance_id")
	private String instanceId;
	
	@JsonProperty("createdAt")
	private String createdAt;
	
	@JsonProperty("internal_ip")
	private String internalIp;
	
	@JsonProperty("public_ip")
	private String publicIp;
	
	@JsonProperty("public_port")
	private String publicPort;
	
}
