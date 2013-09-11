package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("os-migrateLive")
public class LiveMigrationSet implements Serializable {
	@JsonIgnore
	String serverId;
	@JsonProperty("host")
	String hostName;
	@JsonProperty("block_migration")
	boolean blockMigration;
	@JsonProperty("disk_over_commit")
	boolean diskOverCommit;

	public boolean isBlockMigration() {
		return blockMigration;
	}

	public void setBlockMigration(boolean blockMigration) {
		this.blockMigration = blockMigration;
	}

	public boolean isDiskOverCommit() {
		return diskOverCommit;
	}

	public void setDiskOverCommit(boolean diskOverCommit) {
		this.diskOverCommit = diskOverCommit;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

}
