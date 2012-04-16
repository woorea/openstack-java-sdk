package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.ServerAction;
import org.openstack.model.compute.nova.NovaServer;

/**
 * The resize operation converts an existing server to a different flavor, in essence, scaling the server up or down. 
 * 
 * The original server is saved for a period of time to allow rollback if there is a problem. 
 * 
 * All resizes should be tested and explicitly confirmed, at which time the original server is removed. 
 * 
 * All resizes are automatically confirmed after 24 hours if they are not explicitly confirmed or reverted.
 * 
 * @author luis@woorea.es
 *
 */
@XmlRootElement(name="resize")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("resize")
public class ResizeAction implements Serializable, ServerAction {

	@XmlAttribute
	private String flavorRef;
	
	@XmlAttribute(name="auto_disk_config")
	@JsonProperty("auto_disk_config")
	private boolean autoDiskConfig;

	public String getFlavorRef() {
		return flavorRef;
	}

	public void setFlavorRef(String flavorRef) {
		this.flavorRef = flavorRef;
	}

	public boolean getAutoDiskConfig() {
		return autoDiskConfig;
	}

	public void setAutoDiskConfig(boolean autoDiskConfig) {
		this.autoDiskConfig = autoDiskConfig;
	}
	
	@Override
	public Class<? extends Serializable> getReturnType() {
		return NovaServer.class;
	}

}
