package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.ServerAction;

@XmlRootElement(name="os-getVNCConsole")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("os-getVNCConsole")
public class GetVncConsoleAction implements Serializable, ServerAction {

	/**
	 * 'xvpvnc' for XVP-like vnc clients
	 * 
	 * 'novnc' for HTML5 websockets
	 *
	 */
	@XmlElement(required=true)
	private String type = "novnc";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public Class<? extends Serializable> getReturnType() {
		return Console.class;
	}
	
}
