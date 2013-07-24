package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("tenant_usage")
public class SimpleTenantUsage implements Serializable {
	
	@JsonProperty("total_memory_mb_usage")
	private BigDecimal totalMemoryMbUsage;
	
	@JsonProperty("total_vcpus_usage")
	private BigDecimal totalVcpusUsage;
	
	@JsonProperty("total_local_gb_usage")
	private BigDecimal totalLocalGbUsage;

	private String start;
	
	private String stop;
	
	@JsonProperty("tenant_id")
	private String tenantId;
	
	@JsonProperty("total_hours")
	private String totalHours;

	@JsonProperty("server_usages")
	private List<ServerUsage> serverUsages;

	/**
	 * @return the totalMemoryMbUsage
	 */
	public BigDecimal getTotalMemoryMbUsage() {
		return totalMemoryMbUsage;
	}

	/**
	 * @param totalMemoryMbUsage the totalMemoryMbUsage to set
	 */
	public void setTotalMemoryMbUsage(BigDecimal totalMemoryMbUsage) {
		this.totalMemoryMbUsage = totalMemoryMbUsage;
	}

	/**
	 * @return the totalVcpusUsage
	 */
	public BigDecimal getTotalVcpusUsage() {
		return totalVcpusUsage;
	}

	/**
	 * @param totalVcpusUsage the totalVcpusUsage to set
	 */
	public void setTotalVcpusUsage(BigDecimal totalVcpusUsage) {
		this.totalVcpusUsage = totalVcpusUsage;
	}

	/**
	 * @return the totalLocalGbUsage
	 */
	public BigDecimal getTotalLocalGbUsage() {
		return totalLocalGbUsage;
	}

	/**
	 * @param totalLocalGbUsage the totalLocalGbUsage to set
	 */
	public void setTotalLocalGbUsage(BigDecimal totalLocalGbUsage) {
		this.totalLocalGbUsage = totalLocalGbUsage;
	}

	/**
	 * @return the start
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * @return the stop
	 */
	public String getStop() {
		return stop;
	}

	/**
	 * @param stop the stop to set
	 */
	public void setStop(String stop) {
		this.stop = stop;
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
	 * @return the totalHours
	 */
	public String getTotalHours() {
		return totalHours;
	}

	/**
	 * @param totalHours the totalHours to set
	 */
	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}

	public List<ServerUsage> getServerUsages() {
		return serverUsages;
	}

	public void setServerUsages(List<ServerUsage> serverUsages) {
		this.serverUsages = serverUsages;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SimpleTenantUsage [totalMemoryMbUsage=" + totalMemoryMbUsage
				+ ", totalVcpusUsage=" + totalVcpusUsage
				+ ", totalLocalGbUsage=" + totalLocalGbUsage + ", start="
				+ start + ", stop=" + stop + ", tenantId=" + tenantId
				+ ", totalHours=" + totalHours + "]";
	}

	public static final class ServerUsage implements Serializable {
		@JsonProperty("instance_id")
		private String instanceId;

		private Integer uptime;

		@JsonProperty("started_at")
		private String startedAt;
	
		@JsonProperty("ended_at")
		private String endedAt;

		@JsonProperty("memory_mb")
		private Integer memoryMb;

		@JsonProperty("tenant_id")
		private String tenantId;

		private String state;

		private Double hours;

		private Integer vcpus;

		private String flavor;

		@JsonProperty("local_gb")
		private Integer localDiskSize;

		private String name;

		public String getInstanceId() {
			return instanceId;
		}

		public Integer getUptime() {
			return uptime;
		}

		public String getStartedAt() {
			return startedAt;
		}

		public String getEndedAt() {
			return endedAt;
		}

		public Integer getMemoryMb() {
			return memoryMb;
		}

		public String getTenantId() {
			return tenantId;
		}

		public String getState() {
			return state;
		}

		public Double getHours() {
			return hours;
		}

		public Integer getVcpus() {
			return vcpus;
		}

		public String getFlavor() {
			return flavor;
		}

		public Integer getLocalDiskSize() {
			return localDiskSize;
		}

		public String getName() {
			return name;
		}
	}
}
