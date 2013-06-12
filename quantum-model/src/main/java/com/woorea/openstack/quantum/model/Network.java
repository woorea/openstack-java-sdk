package com.woorea.openstack.quantum.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("network")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Network implements Serializable{
	
	private String status;
	private List<String> subnets;
	private String name;
	@JsonProperty("provider:physical_network")
	private String providerPhyNet;
	@JsonProperty("admin_state_up")
	private boolean adminStateUp;
	@JsonProperty("tenant_id")
	private String tenantId;
	@JsonProperty("provider:network_type")
	private String netType;
	@JsonProperty("router:external")
	private String routerExternal;
	private String id;
	private String shared;
	@JsonProperty("provider:segmentation_id")
	private String providerSegID;
	

	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}



	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}



	/**
	 * @return the subnets
	 */
	public List<String> getSubnets() {
		return subnets;
	}



	/**
	 * @param subnets the subnets to set
	 */
	public void setSubnets(List<String> subnets) {
		this.subnets = subnets;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the providerPhyNet
	 */
	public String getProviderPhyNet() {
		return providerPhyNet;
	}



	/**
	 * @param providerPhyNet the providerPhyNet to set
	 */
	public void setProviderPhyNet(String providerPhyNet) {
		this.providerPhyNet = providerPhyNet;
	}



	/**
	 * @return the adminStateUp
	 */
	public boolean isAdminStateUp() {
		return adminStateUp;
	}



	/**
	 * @param adminStateUp the adminStateUp to set
	 */
	public void setAdminStateUp(boolean adminStateUp) {
		this.adminStateUp = adminStateUp;
	}



	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}



	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}



	/**
	 * @return the netType
	 */
	public String getNetType() {
		return netType;
	}



	/**
	 * @param netType the netType to set
	 */
	public void setNetType(String netType) {
		this.netType = netType;
	}



	/**
	 * @return the routerExternal
	 */
	public String getRouterExternal() {
		return routerExternal;
	}



	/**
	 * @param routerExternal the routerExternal to set
	 */
	public void setRouterExternal(String routerExternal) {
		this.routerExternal = routerExternal;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	/**
	 * @return the shared
	 */
	public String getShared() {
		return shared;
	}



	/**
	 * @param shared the shared to set
	 */
	public void setShared(String shared) {
		this.shared = shared;
	}



	/**
	 * @return the providerSegID
	 */
	public String getProviderSegID() {
		return providerSegID;
	}



	/**
	 * @param providerSegID the providerSegID to set
	 */
	public void setProviderSegID(String providerSegID) {
		this.providerSegID = providerSegID;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Network [id=" + id + ", name=" + name + ", subnets="
				+ subnets + ", status=" + status + ", admin_state_up=" + adminStateUp + ", tenant_id=" + 
				tenantId + ", shared=" + shared + ", provider:physical_network=" + providerPhyNet +
				", provider:network_type=" + netType + ", router:external=" + routerExternal + 
				", provider:segmentation_id=" + providerSegID + "]";
	}
}
