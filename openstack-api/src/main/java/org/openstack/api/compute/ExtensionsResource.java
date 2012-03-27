package org.openstack.api.compute;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.common.ExtensionList;

public class ExtensionsResource extends Resource {
	
	public ExtensionsResource(Target target) {
		super(target);
	}

	public ExtensionList get() {
		return target.request(MediaType.APPLICATION_JSON).get(ExtensionList.class);
	}

    public ExtensionResource extension(String alias) {
    	return new ExtensionResource(target.path("/{alias}").pathParam("alias", alias));
    }

	
}
