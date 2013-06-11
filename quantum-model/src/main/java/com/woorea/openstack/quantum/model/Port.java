package com.woorea.openstack.quantum.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("port")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Port implements Serializable {
	
	public static final class Ip implements Serializable {
		
		@JsonProperty("ip_address")
		private String address;
		@JsonProperty("subnet_id")
		private String subnetId;

		/**
		 * @return the address
		 */
		public String getAddress() {
			return address;
		}

		/**
		 * @param address the address to set
		 */
		public void setAddress(String address) {
			this.address = address;
		}

		/**
		 * @return the subnetId
		 */
		public String getSubnetId() {
			return subnetId;
		}

		/**
		 * @param subnetId the subnetId to set
		 */
		public void setSubnetId(String subnetId) {
			this.subnetId = subnetId;
		}


		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "ip_addresses [ip_address=" + address + ", subnet_id=" + subnetId + "]";
		}
		
	}
	
	@JsonProperty("admin_state_up")
	private String adminStateUp;
	@JsonProperty("device_id")
	private String deviceId;
	@JsonProperty("device_owner")
	private String deviceOwner;
	@JsonProperty("fixed_ips")
	private List<Ip> list;
	private String id;
	@JsonProperty("mac_address")
	private String macAddress;
	private String name;
	@JsonProperty("network_id")
	private String networkId;
	private String status;
	@JsonProperty("tenant_id")
	private String tenantId;
	
	
	
	/**
	 * @return the adminStateUp
	 */
	public String getAdminStateUp() {
		return adminStateUp;
	}



	/**
	 * @param adminStateUp the adminStateUp to set
	 */
	public void setAdminStateUp(String adminStateUp) {
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
	 * @return the deviceOwner
	 */
	public String getDeviceOwner() {
		return deviceOwner;
	}



	/**
	 * @param deviceOwner the deviceOwner to set
	 */
	public void setDeviceOwner(String deviceOwner) {
		this.deviceOwner = deviceOwner;
	}



	/**
	 * @return the list
	 */
	public List<Ip> getList() {
		return list;
	}



	/**
	 * @param list the list to set
	 */
	public void setList(List<Ip> list) {
		this.list = list;
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
	 * @return the macAddress
	 */
	public String getMacAddress() {
		return macAddress;
	}



	/**
	 * @param macAddress the macAddress to set
	 */
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
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



	@Override
	public String toString() {
		return "Port [id=" + id + ", name=" + name + ", mac_address="
				+ macAddress + ", admin_state_up=" + adminStateUp + ", device_id=" + deviceId
				+ ", device_owner=" + deviceOwner + ", fixed_ips=" + list
				+ ", network_id=" + networkId + ", status=" + status
				+ ", tenant_id=" + tenantId  + "]";
	}
}
