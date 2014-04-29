package com.woorea.openstack.quantum.model;

import java.util.List;
import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("router")
public class RouterForCreate implements Serializable {

	@JsonProperty("name")
	private String name;

	private List<HostRoute> routes;

	@JsonProperty("admin_state_up")
	private String admin_state_up;

	@JsonProperty("status")
	private String status;

	@JsonProperty("external_gateway_info")
	private GatewayInfo externalGatewayInfo;

	@JsonProperty("tenant_id")
	private String tenantId;

	@JsonProperty("id")
	private String id;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<HostRoute> getRoutes() {
		return routes;
	}
	public void setRoutes(List<HostRoute> routes) {
		this.routes = routes;
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
	public GatewayInfo getExternalGatewayInfo() {
		return externalGatewayInfo;
	}
	public void setExternalGatewayInfo(GatewayInfo externalGatewayInfo) {
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
