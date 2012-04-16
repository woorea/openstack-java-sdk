package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.ServerAction;
import org.openstack.model.compute.nova.NovaServer;


/**
 * This operation enables you to complete either a soft or hard reboot of a specified server. With a soft reboot (SOFT), 
 * the operating system is signaled to restart, which allows for a graceful shutdown of all processes. A hard reboot (HARD) 
 * is the equivalent of power cycling the server.
 * 
 * @author luis@woorea.es
 *
 */
@XmlRootElement(name="reboot")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("reboot")
public class RebootAction implements Serializable, ServerAction {

	@XmlAttribute(required=true)
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public RebootAction() {
		
	}
	
	public RebootAction(String type) {
		this.type = type;
	}
	
	@Override
	public Class<? extends Serializable> getReturnType() {
		return NovaServer.class;
	}
	
}
