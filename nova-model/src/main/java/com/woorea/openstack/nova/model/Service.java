package com.woorea.openstack.nova.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("service")
public class Service implements Serializable {

	private String binary;
	
	private String host;
	
	private String state;
	
	private String status;
	
	@JsonProperty("updated_at")
	private String updatedAt;
	
	private String zone;
	
	@JsonProperty("disabled_reason")
	private String disabledReason;

	public Service() {	
	}

	public Service(String binary, String host, String state,
		String status, String updated_at, String zone,
		String disabled_reason) {
		this.binary = binary;
		this.host = host;
		this.state = state;
		this.status = status;
		this.updatedAt = updated_at;
		this.zone = zone;
		this.disabledReason = disabled_reason;
	}

	/**
	 * @return the binary name of the service.
	 */
	public String getBinary() {
		return binary;
	}
	
	/**
	 * @return the host machine name
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @return the stage
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the status (enabled/disabled)
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the last service meta-data update time
	 */
	public String getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @return the image
	 */
	public String getZone() {
		return zone;
	}
	
	/**
	 * @return reason for the disabling (if disabled).
	 */
	public String getDisabledReason() {
		return disabledReason;
	}

	public void setBinary(String binary) {
		this.binary = binary;
	}
	

	public void setHost(String host) {
		this.host = host;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	
	public void setDisabledReason(String disabledReason) {
		this.disabledReason = disabledReason;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Service [binary=" + binary + ", host=" + host
			+ ", state=" + state + ", status=" + status
			+ ", updated_at=" + updatedAt + ", zone=" + zone
			+ ", disabled_reason=" + disabledReason + "]";
	}

}
