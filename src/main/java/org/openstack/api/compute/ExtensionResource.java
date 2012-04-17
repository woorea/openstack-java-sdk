package org.openstack.api.compute;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.common.Extension;

public class ExtensionResource extends Resource {
	
    public ExtensionResource(Target target, Properties properties) {
		super(target, properties);
	}

    public Extension get() {
		return target.request(MediaType.APPLICATION_JSON).get(Extension.class);
	}
}
