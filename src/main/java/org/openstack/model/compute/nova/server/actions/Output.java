package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import org.openstack.model.common.JsonRootElement;

@XmlRootElement(name="output", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement()
public class Output implements Serializable {

	@XmlValue
	private String output;

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
	
}
