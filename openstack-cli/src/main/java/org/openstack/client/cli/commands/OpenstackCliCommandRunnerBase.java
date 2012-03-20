package org.openstack.client.cli.commands;

import org.openstack.client.OpenStackClient;
import org.openstack.client.OpenStackStorageClient;
import org.openstack.client.cli.OpenstackCache;
import org.openstack.client.cli.OpenstackCliContext;

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

	// protected OpenstackSession getOpenstackSession() {
	// return getContext().getOpenstackSession();
	// }

	protected OpenstackCliContext getContext() {
		return (OpenstackCliContext) super.getContext();
	}

	protected void invalidateCache(Class<?> modelClass) {
		getCache().invalidateCache(modelClass);
	}

	protected OpenstackCache getCache() {
		return getContext().getCache();
	}

	protected OpenStackClient getOpenstackService() {
		return getContext().getOpenstackService();
	}
}
