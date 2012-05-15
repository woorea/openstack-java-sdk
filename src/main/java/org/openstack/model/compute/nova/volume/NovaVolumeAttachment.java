package org.openstack.model.compute.nova.volume;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.ServerAction;

@JsonRootName("volumeAttachment")
public class NovaVolumeAttachment implements Serializable, ServerAction {

	private String id;
	
	private String volumeId;
	
	private String device;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(String volumeId) {
		this.volumeId = volumeId;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	@Override
	public Class<? extends Serializable> getReturnType() {
		return NovaVolumeAttachment.class;
	}
	
}
