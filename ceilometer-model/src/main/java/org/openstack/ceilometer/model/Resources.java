package org.openstack.ceilometer.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.codehaus.jackson.annotate.JsonProperty;
public class Resources {
	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Resource {
		
		public static class Meter {
			
			@JsonProperty("counter_name")
			private String name;
			
			@JsonProperty("counter_type")
			private String type;
			
			@JsonProperty("counter_unit")
			private String unit;

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
			 * @return the type
			 */
			public String getType() {
				return type;
			}

			/**
			 * @param type the type to set
			 */
			public void setType(String type) {
				this.type = type;
			}

			public String getUnit() {
				return unit;
			}

			public void setUnit(String unit) {
				this.unit = unit;
			}
			
		}
		
		private String source;
		
		@JsonProperty("project_id")
		private String projectId;
		
		@JsonProperty("user_id")
		private String userId;
		
		private Calendar timestamp;
		
		@JsonProperty("received_timestamp")
		private Calendar receivedTimestamp;
		
		@JsonProperty("resource_id")
		private String resourceId;
		
		private Map<String,Object> metadata;
		
		@JsonProperty("meter")
		private List<Meter> meters = new ArrayList<Meter>();
		

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public Calendar getReceivedTimestamp() {
			return receivedTimestamp;
		}

		public void setReceivedTimestamp(Calendar receivedTimestamp) {
			this.receivedTimestamp = receivedTimestamp;
		}

		public String getResourceId() {
			return resourceId;
		}

		public void setResourceId(String resourceId) {
			this.resourceId = resourceId;
		}

		/**
		 * @return the projectId
		 */
		public String getProjectId() {
			return projectId;
		}

		/**
		 * @param projectId the projectId to set
		 */
		public void setProjectId(String projectId) {
			this.projectId = projectId;
		}

		/**
		 * @return the userId
		 */
		public String getUserId() {
			return userId;
		}

		/**
		 * @param userId the userId to set
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}

		/**
		 * @return the timestamp
		 */
		public Calendar getTimestamp() {
			return timestamp;
		}

		/**
		 * @param timestamp the timestamp to set
		 */
		public void setTimestamp(Calendar timestamp) {
			this.timestamp = timestamp;
		}

		public Map<String, Object> getMetadata() {
			return metadata;
		}

		public void setMetadata(Map<String, Object> metadata) {
			this.metadata = metadata;
		}

		/**
		 * @return the meter
		 */
		public List<Meter> getMeters() {
			return meters;
		}

		/**
		 * @param meter the meter to set
		 */
		public void setMeters(List<Meter> meters) {
			this.meters = meters;
		}

	}

	private List<Resource> resources = new ArrayList<Resources.Resource>();

	/**
	 * @return the resources
	 */
	public List<Resource> getResources() {
		return resources;
	}

	/**
	 * @param resources the resources to set
	 */
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
}

