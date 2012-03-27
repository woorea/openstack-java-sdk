package org.openstack.model.compute;

import java.util.List;

import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroup;

public interface SecurityGroupList {

	List<SecurityGroup> getList();

}