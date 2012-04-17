package org.openstack.api.compute;

import java.util.Properties;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

public class MetadataResource extends Resource {

	protected MetadataResource(Target target, Properties properties) {
		super(target, properties);
	}


}
