package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.ServerAction;

@XmlRootElement(name="changePassword")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("changePassword")
public class ChangePasswordAction implements Serializable, ServerAction {

	@XmlAttribute(required=true)
	private String adminPass;

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	
}