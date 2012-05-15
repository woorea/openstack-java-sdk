package org.openstack.model.compute.nova.usage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("tenant_usage")
public class NovaSimpleTenantUsage implements Serializable {
	
	public static class NovaServerUsage implements Serializable {
		
		private BigDecimal hours;
		
		private BigDecimal uptime;
		
		@JsonProperty("local_gb")
		private BigDecimal localGb;
		
		@JsonProperty("started_at")
		private String startedAt;
		
		@JsonProperty("ended_at")
		private String endedAt;
		
		@JsonProperty("name")
		private String name;
		
		@JsonProperty("tenant_id")
		private String tenantId;
		
		@JsonProperty("vcpus")
		private String vcpus;
		
		@JsonProperty("memory_mb")
		private String memoryMb;
		
		@JsonProperty("state")
		private String state;
		
		@JsonProperty("flavor")
		private String flavor;

		public BigDecimal getHours() {
			return hours;
		}

		public BigDecimal getUptime() {
			return uptime;
		}

		public BigDecimal getLocalGb() {
			return localGb;
		}

		public String getStartedAt() {
			return startedAt;
		}

		public String getEndedAt() {
			return endedAt;
		}

		public String getName() {
			return name;
		}

		public String getTenantId() {
			return tenantId;
		}

		public String getVcpus() {
			return vcpus;
		}

		public String getMemoryMb() {
			return memoryMb;
		}

		public String getState() {
			return state;
		}

		public String getFlavor() {
			return flavor;
		}
		
	}
	
	@JsonProperty("tenant_id")
	private String tenantId;
	
	@JsonProperty("total_vcpus_usage")
	private BigDecimal totalVcpus;

	@JsonProperty("total_memory_mb_usage")
	private BigDecimal totalMemoryMb;
	
	@JsonProperty("total_local_gb_usage")
	private BigDecimal totalLocalGbUsage;
	
	@JsonProperty("total_hours")
	private BigDecimal totalHours;
	
	@JsonProperty("start")
	private String start;
	
	@JsonProperty("stop")
	private String stop;
	
	@JsonProperty("server_usages")
	private List<NovaServerUsage> serversUsages = new ArrayList<NovaSimpleTenantUsage.NovaServerUsage>();

	public String getTenantId() {
		return tenantId;
	}

	public BigDecimal getTotalVcpus() {
		return totalVcpus;
	}

	public BigDecimal getTotalMemoryMb() {
		return totalMemoryMb;
	}

	public BigDecimal getTotalLocalGbUsage() {
		return totalLocalGbUsage;
	}

	public BigDecimal getTotalHours() {
		return totalHours;
	}

	public String getStart() {
		return start;
	}

	public String getStop() {
		return stop;
	}

	public List<NovaServerUsage> getServersUsages() {
		return serversUsages;
	}
	
}
