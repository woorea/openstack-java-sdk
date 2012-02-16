package org.openstack.client.compute.ext;

public class SecurityGroupRuleResource extends ComputeResourceBase {

    public void delete() {
        resource().delete();
    }

}
