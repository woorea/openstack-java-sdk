package org.openstack.console.commands;

import org.openstack.client.OpenStackClient;
import org.openstack.client.StorageService;
import org.openstack.console.OpenstackCliContext;
import org.openstack.console.common.commands.CommandRunnerBase;
import org.openstack.console.common.commands.CommandSpecifier;


public abstract class OpenstackCliCommandRunnerBase extends CommandRunnerBase {

	protected OpenstackCliCommandRunnerBase(String verb, String noun) {
		super(verb, noun);
	}

	protected OpenstackCliCommandRunnerBase(CommandSpecifier commandSpecifier) {
		super(commandSpecifier);
	}

	protected StorageService getStorageClient() {
		return getContext().getStorageClient();
	}

	protected OpenstackCliContext getContext() {
		return (OpenstackCliContext) super.getContext();
	}

	protected OpenStackClient getOpenstackService() {
		return getContext().getOpenstackService();
	}
}
