package com.woorea.openstack.quantum.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("subnet")
public class SubnetForCreate implements Serializable {

    private String name;
    @JsonProperty("network_id")
    private String networkId;
    @JsonProperty("ip_version")
    private int ipVersion;
    private String cidr;
    @JsonProperty("dns_nameservers")
    private List<String> dnsNameServers;
    @JsonProperty("allocation_pools")
    private List<Pool> list;
    @JsonProperty("tenant_id")
    private String tenantId;

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the id
     */
    public String getNetworkId() {
        return networkId;
    }

    /**
     * @param id the id to set
     */
    public void setNetworkId(String id) {
        this.networkId = id;
    }


    /**
     * @return the ipVersion
     */
    public int getIpVersion() {
        return ipVersion;
    }

    /**
     * @param ipVersion the ipVersion to set
     */
    public void setIpVersion(int ipVersion) {
        this.ipVersion = ipVersion;
    }

    /**
     * @return the cidr
     */
    public String getCidr() {
        return cidr;
    }

    /**
     * @param cidr the cidr to set
     */
    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    /**
     *
     * @return dns names
     */
    public List<String> getDnsNameServers() {
        return dnsNameServers;
    }

    /**
     * @param dnsNameServers list of dns name servers.
     */
    public void setDnsNameServers(List<String> dnsNameServers) {
        this.dnsNameServers = dnsNameServers;
    }

    /**
     * @return the list
     */
    public List<Pool> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Pool> list) {
        this.list = list;
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
}
