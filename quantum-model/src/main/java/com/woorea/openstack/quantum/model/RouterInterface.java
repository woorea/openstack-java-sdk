package com.woorea.openstack.quantum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

public class RouterInterface implements Serializable {

	@JsonProperty("subnet_id")
	String subnetId;
	@JsonProperty("port_id")
	String portId;
	@JsonProperty("tenant_id")
	String tenantId;
	@JsonProperty("id")
	String id;

}
