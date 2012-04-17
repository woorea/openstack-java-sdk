package org.openstack.api.compute.notavailable;

import java.util.Properties;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

/**
 * Allow admins to acces user information
 * 
 * @author sp
 *
 */
public class UsersResource extends Resource {

	protected UsersResource(Target target, Properties properties) {
		super(target, properties);
	}


}
