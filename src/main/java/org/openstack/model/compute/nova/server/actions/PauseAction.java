package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.ServerAction;

@XmlRootElement(name="pause")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("pause")
public class PauseAction implements Serializable, ServerAction {
	
}
