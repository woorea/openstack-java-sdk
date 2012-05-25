package org.openstack.model.compute.nova.host;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateNovaHostRequest {

	@JsonProperty
	private String status;
	
	@JsonProperty("maintenance_mode")
	private String maintenanceMode;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMaintenanceMode() {
		return maintenanceMode;
	}

	public void setMaintenanceMode(String maintenanceMode) {
		this.maintenanceMode = maintenanceMode;
	}
	
}
