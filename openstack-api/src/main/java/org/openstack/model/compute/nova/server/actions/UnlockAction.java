package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.compute.ServerAction;

@XmlRootElement(name="unlock")
@XmlAccessorType(XmlAccessType.NONE)
public class UnlockAction implements Serializable, ServerAction {
	
}
