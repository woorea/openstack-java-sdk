package org.openstack.api.compute.ext;

public class SecurityGroupRuleResource extends ComputeResourceBase {

	public void delete() {
		resource().delete();
	}

	// This function is "missing" from the OpenStack API
	// public SecurityGroupRule fetch() {
	// return resource().get(SecurityGroupRule.class);
	// }

}
