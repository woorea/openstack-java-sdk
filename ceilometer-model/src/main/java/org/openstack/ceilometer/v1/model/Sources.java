package org.openstack.ceilometer.v1.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@XmlRootElement(name="source")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sources {

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Source {
		
		@XmlAttribute
		@JsonProperty
		private String id;

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
		
	}
	
	@XmlElement(name="source")
	@JsonProperty("sources")
	private List<Source> sources = new ArrayList<Sources.Source>();

	/**
	 * @return the sources
	 */
	public List<Source> getSources() {
		return sources;
	}

	/**
	 * @param sources the sources to set
	 */
	public void setSources(List<Source> sources) {
		this.sources = sources;
	}

}
