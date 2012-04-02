package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.ServerAction;

@XmlRootElement(name="resize")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("resize")
public class ResizeAction implements Serializable, ServerAction {

	@XmlAttribute
	private String flavorRef;
	
	@XmlAttribute(name="auto_disk_config")
	private String autoDiskConfig;

	public String getFlavorRef() {
		return flavorRef;
	}

	public void setFlavorRef(String flavorRef) {
		this.flavorRef = flavorRef;
	}

	public String getAutoDiskConfig() {
		return autoDiskConfig;
	}

	public void setAutoDiskConfig(String autoDiskConfig) {
		this.autoDiskConfig = autoDiskConfig;
	}
	
	

}
