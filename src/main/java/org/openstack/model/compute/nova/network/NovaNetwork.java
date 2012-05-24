package org.openstack.model.compute.nova.network;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class NovaNetwork implements Serializable {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("project_id")
	private String tenantId;
	
	@JsonProperty("multi_host")
	private String multiHost;
	
	@JsonProperty("host")
	private String host;
	
	@JsonProperty("vlan")
	private String vlan;
	
	@JsonProperty("broadcast")
	private String broadcast;
	
	@JsonProperty("netmask")
	private String netmask;
	
	@JsonProperty("bridge")
	private String bridge;
	
	@JsonProperty("bridge_interface")
	private String bridgeInterface;
	
	@JsonProperty("dhcp_start")
	private String dhcpStart;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("updated_at")
	private String updatedAt;
	
	@JsonProperty("deleted_at")
	private String deletedAt;
	
	@JsonProperty("gateway")
	private String gateway;
	
	@JsonProperty("gateway_v6")
	private String gatewayV6;
	
	@JsonProperty("netmask_v6")
	private String netmaskV6;
	
	@JsonProperty("label")
	private String label;
	
	
	
	@JsonProperty("vpn_public_address")
	private String vnpPublicAddress;
	
	@JsonProperty("vpn_public_port")
	private String vpnPublicPort;
	
	@JsonProperty("vpn_private_address")
	private String vpnPrivateAddress;
	
	@JsonProperty("deleted")
	private String deleted;
	
	@JsonProperty("injected")
	private String injected;
	
	@JsonProperty("cidr")
	private String cidr;
	
	@JsonProperty("cidr_v6")
	private String cidrv6;
	
	@JsonProperty("dns1")
	private String dns1;
		
}
