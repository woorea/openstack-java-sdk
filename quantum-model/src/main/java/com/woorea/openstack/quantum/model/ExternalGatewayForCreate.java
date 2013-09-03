package com.woorea.openstack.quantum.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("router")
public class ExternalGatewayForCreate implements Serializable {
	@JsonProperty("external_gateway_info")
	private Map<String, String> external_gateway_info;
	
	@JsonIgnore
	String routerId;

	public Map<String, String> getExternal_gateway_info() {
		return external_gateway_info;
	}

	public void setExternal_gateway_info(
			Map<String, String> external_gateway_info) {
		this.external_gateway_info = external_gateway_info;
	}

	public String getRouterId() {
		return routerId;
	}

	public void setRouterId(String routerId) {
		this.routerId = routerId;
	}


}
