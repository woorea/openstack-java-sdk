package org.openstack.client.cli.commands;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.jersey2.OpenStackClient;
import org.openstack.client.jersey2.OpenStackStorageClient;

import com.fathomdb.cli.commands.CommandRunnerBase;
import com.fathomdb.cli.commands.CommandSpecifier;

public abstract class OpenstackCliCommandRunnerBase extends CommandRunnerBase {

	protected OpenstackCliCommandRunnerBase(String verb, String noun) {
		super(verb, noun);
	}

	protected OpenstackCliCommandRunnerBase(CommandSpecifier commandSpecifier) {
		super(commandSpecifier);
	}

	protected OpenStackStorageClient getStorageClient() {
		return getContext().getStorageClient();
	}

	protected OpenstackCliContext getContext() {
		return (OpenstackCliContext) super.getContext();
	}

	protected OpenStackClient getOpenstackService() {
		return getContext().getOpenstackService();
	}
}
