package com.woorea.openstack.quantum.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
@JsonRootName("router")
public class RouterForCreate {
	@JsonProperty("name")
	String name;
	private List<String> routers;
	@JsonProperty("admin_state_up")
	String admin_state_up;
	@JsonProperty("status")
	String status;
	@JsonProperty("external_gateway_info")
	String externalGatewayInfo;
	@JsonProperty("tenant_id")
	String tenantId;
	@JsonProperty("id")
	String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getRouters() {
		return routers;
	}
	public void setRouters(List<String> routers) {
		this.routers = routers;
	}
	public String getAdmin_state_up() {
		return admin_state_up;
	}
	public void setAdmin_state_up(String admin_state_up) {
		this.admin_state_up = admin_state_up;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExternalGatewayInfo() {
		return externalGatewayInfo;
	}
	public void setExternalGatewayInfo(String externalGatewayInfo) {
		this.externalGatewayInfo = externalGatewayInfo;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
