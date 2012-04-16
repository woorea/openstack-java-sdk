package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.ServerAction;
import org.openstack.model.compute.nova.NovaServer;

/**
 * During a resize operation, the original server is saved for a period of time to allow roll back if a problem exists.
 * 
 * Once the newly resized server is tested and has been confirmed to be functioning properly, use this operation to confirm the resize.
 * 
 * After confirmation, the original server is removed and cannot be rolled back to.
 * 
 * All resizes are automatically confirmed after 24 hours if they are not explicitly confirmed or reverted.
 * 
 * @author luis@woorea.es
 *
 */
@XmlRootElement(name="confirmResize")
@JsonRootName("confirmResize")
public class ConfirmResizeAction implements Serializable, ServerAction {

	@Override
	public Class<? extends Serializable> getReturnType() {
		return NovaServer.class;
	}
	
}
