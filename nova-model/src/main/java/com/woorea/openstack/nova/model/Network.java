package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("network")
public class Network implements Serializable {

	private String id;
	
	@JsonProperty("vpn_public_address")
	private String vpnPublicAddress;
	
	@JsonProperty("vpn_private_address")
	private String vpnPrivateAddress;
	
	@JsonProperty("vpn_public_port")
	private String vpnPublicPort;
	
	@JsonProperty("dhcp_start")
	private String dhcpStart;
	
	private String bridge;
	
	@JsonProperty("bridge_interface")
	private String bridgeInterface;
	
	@JsonProperty("updated_at")
	private String updatedAt;

	private Boolean deleted;
	
	private String vlan;
	
	private String broadcast;
	
	private String netmask;
	
	private Boolean injected;
	
	private String host;
	
	@JsonProperty("multi_host")
	private Boolean multiHost;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("deleted_at")
	private String deletedAt;
	
	private String cidr;
	
	@JsonProperty("cidr_v6")
	private String cidrV6;
	
	private String gateway;
	
	@JsonProperty("gateway_v6")
	private String gatewayV6;
	
	@JsonProperty("netmask_v6")
	private String netmaskV6;
	
	@JsonProperty("project_id")
	private String projectId;
	
	@JsonProperty("rxtx_base")
	private String rxtxBase;
	
	private String dns1;
	
	private String dns2;
	
	private String label;
	
	private String priority;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the vpnPublicAddress
	 */
	public String getVpnPublicAddress() {
		return vpnPublicAddress;
	}

	/**
	 * @return the vpnPublicPort
	 */
	public String getVpnPublicPort() {
		return vpnPublicPort;
	}

	/**
	 * @return the dhcpStart
	 */
	public String getDhcpStart() {
		return dhcpStart;
	}

	/**
	 * @return the bridge
	 */
	public String getBridge() {
		return bridge;
	}

	/**
	 * @return the bridgeInterface
	 */
	public String getBridgeInterface() {
		return bridgeInterface;
	}

	/**
	 * @return the updatedAt
	 */
	public String getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * @return the vlan
	 */
	public String getVlan() {
		return vlan;
	}

	/**
	 * @return the broadcast
	 */
	public String getBroadcast() {
		return broadcast;
	}

	/**
	 * @return the netmask
	 */
	public String getNetmask() {
		return netmask;
	}

	/**
	 * @return the injected
	 */
	public Boolean getInjected() {
		return injected;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @return the multiHost
	 */
	public Boolean getMultiHost() {
		return multiHost;
	}

	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * @return the deletedAt
	 */
	public String getDeletedAt() {
		return deletedAt;
	}

	/**
	 * @return the cidr
	 */
	public String getCidr() {
		return cidr;
	}

	/**
	 * @return the cidrV6
	 */
	public String getCidrV6() {
		return cidrV6;
	}

	/**
	 * @return the gateway
	 */
	public String getGateway() {
		return gateway;
	}

	/**
	 * @return the gatewayV6
	 */
	public String getGatewayV6() {
		return gatewayV6;
	}

	/**
	 * @return the netmaskV6
	 */
	public String getNetmaskV6() {
		return netmaskV6;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @return the rxtxBase
	 */
	public String getRxtxBase() {
		return rxtxBase;
	}

	/**
	 * @return the dns1
	 */
	public String getDns1() {
		return dns1;
	}

	/**
	 * @return the dns2
	 */
	public String getDns2() {
		return dns2;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Network [id=" + id + ", vpnPublicAddress=" + vpnPublicAddress
				+ ", vpnPublicPort=" + vpnPublicPort + ", dhcpStart="
				+ dhcpStart + ", bridge=" + bridge + ", bridgeInterface="
				+ bridgeInterface + ", updatedAt=" + updatedAt + ", deleted="
				+ deleted + ", vlan=" + vlan + ", broadcast=" + broadcast
				+ ", netmask=" + netmask + ", injected=" + injected + ", host="
				+ host + ", multiHost=" + multiHost + ", createdAt="
				+ createdAt + ", deletedAt=" + deletedAt + ", cidr=" + cidr
				+ ", cidrV6=" + cidrV6 + ", gateway=" + gateway
				+ ", gatewayV6=" + gatewayV6 + ", netmaskV6=" + netmaskV6
				+ ", projectId=" + projectId + ", rxtxBase=" + rxtxBase
				+ ", dns1=" + dns1 + ", dns2=" + dns2 + ", label=" + label
				+ ", priority=" + priority + "]";
	}
	
}
