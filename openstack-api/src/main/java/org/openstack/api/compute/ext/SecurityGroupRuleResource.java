package org.openstack.api.compute.ext;

import java.util.Map;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

public class SecurityGroupRuleResource extends Resource {

	public SecurityGroupRuleResource(Target target) {
		super(target);
	}

	public void delete(Map<String, Object> properties) {
		 target.request().header("X-Auth-Token", properties.get("X-Auth-Token")).delete();
	}

	// This function is "missing" from the OpenStack API
	// public SecurityGroupRule fetch() {
	// return resource().get(SecurityGroupRule.class);
	// }

}
