package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("interfaceAttachment")
public class InterfaceAttachmentForCreate implements Serializable {

	@JsonProperty("port_id")
	private String portId;

	/**
	 * @return the portId
	 */
	public String getPortId() {
		return portId;
	}

	/**
	 * @param portId
	 *            the portId to set
	 */
	public void setPortId(String portId) {
		this.portId = portId;
	}

}
