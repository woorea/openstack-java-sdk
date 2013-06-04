package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Calendar;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("cloudpipe")
public class Cloudpipe implements Serializable {
	
	private String projectId;
	
	private String internalIp;
	
	private String publicIp;
	
	private String publicPort;
	
	private String state;
	
	private String instanceId;
	
	private Calendar createdAt;

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
	 * @return the internalIp
	 */
	public String getInternalIp() {
		return internalIp;
	}

	/**
	 * @param internalIp the internalIp to set
	 */
	public void setInternalIp(String internalIp) {
		this.internalIp = internalIp;
	}

	/**
	 * @return the publicIp
	 */
	public String getPublicIp() {
		return publicIp;
	}

	/**
	 * @param publicIp the publicIp to set
	 */
	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}

	/**
	 * @return the publicPort
	 */
	public String getPublicPort() {
		return publicPort;
	}

	/**
	 * @param publicPort the publicPort to set
	 */
	public void setPublicPort(String publicPort) {
		this.publicPort = publicPort;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the instanceId
	 */
	public String getInstanceId() {
		return instanceId;
	}

	/**
	 * @param instanceId the instanceId to set
	 */
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	/**
	 * @return the createdAt
	 */
	public Calendar getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CloudPipe [projectId=" + projectId + ", internalIp="
				+ internalIp + ", publicIp=" + publicIp + ", publicPort="
				+ publicPort + ", state=" + state + ", instanceId="
				+ instanceId + ", createdAt=" + createdAt + "]";
	}
	
}
