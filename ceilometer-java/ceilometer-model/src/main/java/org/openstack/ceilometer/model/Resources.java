package org.openstack.ceilometer.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@XmlRootElement(name="resources")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("resources")
public class Resources {
	
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Resource {
		
		public static class Meter {
			
			private String name;
			
			private String type;

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
			
		}
		
		@XmlAttribute
		private String id;
		
		@XmlAttribute(name="project_id")
		@JsonProperty("project_id")
		private String projectId;
		
		@XmlAttribute(name="user_id")
		@JsonProperty("user_id")
		private String userId;
		
		@XmlAttribute
		private Long timestamp;
		
		@XmlElement
		private Metadata metadata;
		
		@XmlAttribute
		private List<Meter> meters = new ArrayList<Meter>();

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
		public Long getTimestamp() {
			return timestamp;
		}

		/**
		 * @param timestamp the timestamp to set
		 */
		public void setTimestamp(Long timestamp) {
			this.timestamp = timestamp;
		}

		/**
		 * @return the metadata
		 */
		public Metadata getMetadata() {
			return metadata;
		}

		/**
		 * @param metadata the metadata to set
		 */
		public void setMetadata(Metadata metadata) {
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
	
	@XmlElement(name="resource")
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

