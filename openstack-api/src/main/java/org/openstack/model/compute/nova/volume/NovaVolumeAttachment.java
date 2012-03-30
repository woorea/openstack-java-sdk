package org.openstack.model.compute.nova.volume;

import java.io.Serializable;

import org.openstack.model.common.JsonRootElement;

@JsonRootElement("volumeAttachment")
public class NovaVolumeAttachment implements Serializable {

	private Integer volumeId;
	
	private String device;

	public Integer getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(Integer volumeId) {
		this.volumeId = volumeId;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}
	
}
