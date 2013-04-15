package org.openstack.base.client;

public interface OpenStackCommand<R> {

	OpenStackRequest execute(OpenStackClient connector);

}
