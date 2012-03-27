package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.ServerAction;

@XmlRootElement(name="confirmResize")
@JsonRootElement("confirmResize")
public class ConfirmResizeAction implements Serializable, ServerAction {

}
