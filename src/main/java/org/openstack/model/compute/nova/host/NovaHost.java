package org.openstack.model.compute.nova.host;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class NovaHost {
	
	
	
	public static class Resource {
		
		private String project;
		
		@JsonProperty("memory_mb")
		private Integer memoryMb;
		
		private String host;
		
		private Integer cpu;
		
		@JsonProperty("disk_gb")
		private Integer diskGb;

		public String getProject() {
			return project;
		}

		public Integer getMemoryMb() {
			return memoryMb;
		}

		public String getHost() {
			return host;
		}

		public Integer getCpu() {
			return cpu;
		}

		public Integer getDiskGb() {
			return diskGb;
		}

		@Override
		public String toString() {
			return "Resource [project=" + project + ", memoryMb=" + memoryMb
					+ ", host=" + host + ", cpu=" + cpu + ", diskGb=" + diskGb
					+ "]";
		}
	
	}
	
	public static class ResourceWrapper {
		
		private Resource resource;

		public Resource getResource() {
			return resource;
		}
		
	}
	
	@JsonProperty("host")
	private List<ResourceWrapper> resources = new ArrayList<ResourceWrapper>();

	public List<Resource> getResources() {
		return Lists.transform(resources, new Function<ResourceWrapper, Resource>() {

			@Override
			public Resource apply(ResourceWrapper wrapper) {
				return wrapper.resource;
			}
			
		});
	}

	@Override
	public String toString() {
		return "NovaHost [resources=" + getResources() + "]";
	}
	
	
	
}
