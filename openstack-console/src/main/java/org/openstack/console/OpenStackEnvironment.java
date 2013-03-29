package org.openstack.console;

import org.openstack.console.keystone.KeystoneEnvironment;
import org.openstack.console.nova.NovaEnvironment;
import org.openstack.console.utils.Environment;

public class OpenStackEnvironment extends Environment {
	
	public OpenStackEnvironment(Console console) {
		add(KeystoneEnvironment.command());
		add(NovaEnvironment.command());
	}
	
	public String getPrompt() {
		return "openstack> ";
	}
	
}
