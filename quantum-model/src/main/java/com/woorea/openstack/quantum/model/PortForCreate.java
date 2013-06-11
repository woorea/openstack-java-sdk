package com.woorea.openstack.quantum.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("port")
public class PortForCreate {

	@JsonProperty("admin_state_up")
	private boolean adminStateUp;
	@JsonProperty("device_id")
	private String deviceId;
	private String name;
	@JsonProperty("network_id")
	private String networkId;

    @JsonProperty("mac_address")
    private String macAddress;

    @JsonProperty("device_owner")
    private String deviceOwner;

    @JsonProperty("tenant_id")
    private String tenantId;
	
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
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}
	
	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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
	 * @return the networkId
	 */
	public String getNetworkId() {
		return networkId;
	}
	
	/**
	 * @param networkId the networkId to set
	 */
	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getDeviceOwner() {
        return deviceOwner;
    }

    public void setDeviceOwner(String deviceOwner) {
        this.deviceOwner = deviceOwner;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
