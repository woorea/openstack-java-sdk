package com.woorea.openstack.quantum.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("router")
public class RouterExternalGateway {
	@JsonProperty("external_gateway_info")
private Map<String, String> external_gateway_info = new HashMap<String, String>();


public Map<String, String> getExternal_gateway_info() {
	return external_gateway_info;
}

public void setExternal_gateway_info(Map<String, String> external_gateway_info) {
	this.external_gateway_info = external_gateway_info;
}
@JsonProperty("status")
	String status;
@JsonProperty("name")
	String name;
@JsonProperty("admin_state_up")
	String admin_state_up;
@JsonProperty("tenant_id")
	String tenant_id;
@JsonProperty("id")
	String id;
@JsonProperty("routes")
private List<Router> list;
		
	
}
