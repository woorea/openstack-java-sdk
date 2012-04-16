package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.ServerAction;
import org.openstack.model.compute.nova.NovaServer;

/**
 * 
 * During a resize operation, the original server is saved for a period of time to allow for roll back if there is a problem.
 * 
 * If you determine there is a problem with a newly resized server, use the revert resize operation to revert the resize and roll back to the original server. 
 * 
 * All resizes are automatically confirmed after 24 hours if they have not already been confirmed explicitly or reverted.
 * 
 * @author sp
 *
 */
@XmlRootElement(name="revertResize")
@JsonRootName("revertResize")
public class RevertResize implements Serializable, ServerAction {

	@Override
	public Class<? extends Serializable> getReturnType() {
		return NovaServer.class;
	}
	
}
