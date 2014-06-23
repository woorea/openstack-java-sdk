package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("flavor")
public class Flavor implements Serializable {

    private String id;
    private String name;
    private String vcpus;
    private Integer ram;
    private String disk;
    @JsonProperty("OS-FLV-EXT-DATA:ephemeral")
    private Integer ephemeral;
    private String swap;
    @JsonProperty("rxtx_factor")
    private Float rxtxFactor;
    @JsonProperty("OS-FLV-DISABLED:disabled")
    private Boolean disabled;
    @JsonProperty("rxtx_quota")
    private Integer rxtxQuota;
    @JsonProperty("rxtx_cap")
    private Integer rxtxCap;
    private List<Link> links;
    @JsonProperty("os-flavor-access:is_public")
    private Boolean isPublic;

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
     * @return the vcpus
     */
    public String getVcpus() {
        return vcpus;
    }

    /**
     * @param vcpus the vcpus to set
     */
    public void setVcpus(String vcpus) {
        this.vcpus = vcpus;
    }

    /**
     * @return the ram
     */
    public Integer getRam() {
        return ram;
    }

    /**
     * @param ram the ram to set
     */
    public void setRam(Integer ram) {
        this.ram = ram;
    }

    /**
     * @return the disk
     */
    public String getDisk() {
        return disk;
    }

    /**
     * @param disk the disk to set
     */
    public void setDisk(String disk) {
        this.disk = disk;
    }

    /**
     * @return the ephemeral
     */
    public Integer getEphemeral() {
        return ephemeral;
    }

    /**
     * @param ephemeral the ephemeral to set
     */
    public void setEphemeral(Integer ephemeral) {
        this.ephemeral = ephemeral;
    }

    /**
     * @return the swap
     */
    public String getSwap() {
        return swap;
    }

    /**
     * @param swap the swap to set
     */
    public void setSwap(String swap) {
        this.swap = swap;
    }

    /**
     * @return the rxtxFactor
     */
    public Float getRxtxFactor() {
        return rxtxFactor;
    }

    /**
     * @param rxtxFactor the rxtxFactor to set
     */
    public void setRxtxFactor(Float rxtxFactor) {
        this.rxtxFactor = rxtxFactor;
    }

    /**
     * @return the rxtxQuota
     */
    public Integer getRxtxQuota() {
        return rxtxQuota;
    }

    /**
     * @param rxtxQuota the rxtxQuota to set
     */
    public void setRxtxQuota(Integer rxtxQuota) {
        this.rxtxQuota = rxtxQuota;
    }

    /**
     * @return the rxtxCap
     */
    public Integer getRxtxCap() {
        return rxtxCap;
    }

    /**
     * @param rxtxCap the rxtxCap to set
     */
    public void setRxtxCap(Integer rxtxCap) {
        this.rxtxCap = rxtxCap;
    }

    /**
     * @return the disabled
     */
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * @param disabled the disabled to set
     */
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * @return the isPublic
     */
    public Boolean isPublic() {
        return isPublic;
    }

    /**
     * @param isPublic the isPublic to set
     */
    public void setPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * @return the links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * @param links the links to set
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Flavor [id=" + id + ", name=" + name + ", vcpus=" + vcpus
                + ", ram=" + ram + ", disk=" + disk + ", ephemeral="
                + ephemeral + ", swap=" + swap + ", rxtxFactor=" + rxtxFactor
                + ", disabled=" + disabled + ", rxtxQuota=" + rxtxQuota
                + ", rxtxCap=" + rxtxCap + ", links=" + links + ", isPublic="
                + isPublic + "]";
    }
}