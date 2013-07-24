package com.woorea.openstack.nova.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("quota_set")
public class QuotaSet {

	private String id;
	
	@JsonProperty("metadata_items")
	private Integer metadataItems;
	
	@JsonProperty("injected_file_content_bytes")
	private Integer injectedFileContentBytes;
	
	@JsonProperty("injected_files")
	private Integer injectedFiles;
	
	private Integer gigabytes;
	
	private Integer ram;
	
	@JsonProperty("floating_ips")
	private Integer floatingIps;
	
	private Integer instances;
	
	private Integer volumes;
	
	private Integer cores;
	
	@JsonProperty("security_groups")
	private Integer securityGroups;
	
	@JsonProperty("security_group_rules")
	private Integer securityGroupRules;

	@JsonProperty("injected_file_path_bytes")
	private Integer injectedFilePathBytes;

	@JsonProperty("key_pairs")
	private Integer keyPairs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getMetadataItems() {
		return metadataItems;
	}

	public void setMetadataItems(Integer metadataItems) {
		this.metadataItems = metadataItems;
	}

	public Integer getInjectedFileContentBytes() {
		return injectedFileContentBytes;
	}

	public void setInjectedFileContentBytes(Integer injectedFileContentBytes) {
		this.injectedFileContentBytes = injectedFileContentBytes;
	}

	public Integer getInjectedFiles() {
		return injectedFiles;
	}

	public void setInjectedFiles(Integer injectedFiles) {
		this.injectedFiles = injectedFiles;
	}

	public Integer getGigabytes() {
		return gigabytes;
	}

	public void setGigabytes(Integer gigabytes) {
		this.gigabytes = gigabytes;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

	public Integer getFloatingIps() {
		return floatingIps;
	}

	public void setFloatingIps(Integer floatingIps) {
		this.floatingIps = floatingIps;
	}

	public Integer getInstances() {
		return instances;
	}

	public void setInstances(Integer instances) {
		this.instances = instances;
	}

	public Integer getVolumes() {
		return volumes;
	}

	public void setVolumes(Integer volumes) {
		this.volumes = volumes;
	}

	public Integer getCores() {
		return cores;
	}

	public void setCores(Integer cores) {
		this.cores = cores;
	}

	public Integer getSecurityGroups() {
		return securityGroups;
	}

	public void setSecurityGroups(Integer securityGroups) {
		this.securityGroups = securityGroups;
	}

	public Integer getSecurityGroupRules() {
		return securityGroupRules;
	}

	public void setSecurityGroupRules(Integer securityGroupRules) {
		this.securityGroupRules = securityGroupRules;
	}

	public Integer getKeyPairs() {
		return keyPairs;
	}

	public void setKeyPairs(Integer keyPairs) {
		this.keyPairs = keyPairs;
	}

	public Integer getInjectedFilePathBytes() {
		return injectedFilePathBytes;
	}

	public void setInjectedFilePathBytes(Integer injectedFilePathBytes) {
		this.injectedFilePathBytes = injectedFilePathBytes;
	}
}