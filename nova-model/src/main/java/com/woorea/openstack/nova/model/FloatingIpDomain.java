package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("floating-ip-pool")
public class FloatingIpDomain implements Serializable {

	private String domain;
	
	private String scope;
	
	private String project;
	
	@JsonProperty("availabilityZone")
	private String availabilityZone;

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @return the availabilityZone
	 */
	public String getAvailabilityZone() {
		return availabilityZone;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FloatingIpDomain [domain=" + domain + ", scope=" + scope
				+ ", project=" + project + ", availabilityZone="
				+ availabilityZone + "]";
	}
	
}
