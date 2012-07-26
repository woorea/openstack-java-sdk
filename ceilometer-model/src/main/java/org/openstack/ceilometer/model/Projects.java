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

@XmlRootElement(name="project")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("projects")
public class Projects {

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Project {
		
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
	
	@XmlElement(name="project")
	@JsonProperty("project")
	private List<Project> projects = new ArrayList<Projects.Project>();

	/**
	 * @return the projects
	 */
	public List<Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
