package com.woorea.openstack.quantum.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
@JsonRootName("router")
public class Router {

	/**
	 * @param args
	 */
	@JsonProperty("status")
	String status;
	@JsonProperty("external_gateway_info")
	String externalGatewayInfo;
	@JsonProperty("name")
	String name;
	@JsonProperty("admin_state_up")
	String admin_state_up;
	@JsonProperty("tenant_id")
	String tenantId;
	@JsonProperty("id")
	String id;
	@JsonProperty("routes")
	private List<String> routers;
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
