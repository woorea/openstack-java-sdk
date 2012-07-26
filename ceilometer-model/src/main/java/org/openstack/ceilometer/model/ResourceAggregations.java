package org.openstack.ceilometer.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name="aggregations")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResourceAggregations {

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ResourceAggregation {
		
		@XmlAttribute(name="resource_id")
		@JsonProperty("resource_id")
		private String resourceId;
		
		@XmlAttribute
		@JsonProperty
		private Number value;

		/**
		 * @return the resourceId
		 */
		public String getResourceId() {
			return resourceId;
		}

		/**
		 * @param resourceId the resourceId to set
		 */
		public void setResourceId(String resourceId) {
			this.resourceId = resourceId;
		}

		/**
		 * @return the value
		 */
		public Number getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(Number value) {
			this.value = value;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "ResourceAggregation [resourceId=" + resourceId + ", value="
					+ value + "]";
		}
		
	}
	
	@JsonProperty("aggregations")
	private List<ResourceAggregations.ResourceAggregation> aggregations = new ArrayList<ResourceAggregations.ResourceAggregation>();

	/**
	 * @return the aggregations
	 */
	public List<ResourceAggregations.ResourceAggregation> getAggregations() {
		return aggregations;
	}

	/**
	 * @param aggregations the aggregations to set
	 */
	public void setAggregations(
			List<ResourceAggregations.ResourceAggregation> aggregations) {
		this.aggregations = aggregations;
	}

}
