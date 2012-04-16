package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.ServerAction;
import org.openstack.model.compute.nova.NovaServer;

@XmlRootElement(name="changePassword")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("changePassword")
public class ChangePasswordAction implements Serializable, ServerAction {

	@XmlAttribute(required=true)
	private String adminPass;
	
	public ChangePasswordAction() {
		
	}

	public ChangePasswordAction(String adminPass) {
		this.adminPass = adminPass;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	
	@Override
	public Class<? extends Serializable> getReturnType() {
		return NovaServer.class;
	}
	
}