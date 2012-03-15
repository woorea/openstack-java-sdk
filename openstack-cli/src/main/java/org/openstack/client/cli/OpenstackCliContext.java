package org.openstack.client.cli;

import java.io.IOException;

import org.openstack.client.cli.commands.OpenstackCliCommandRegistry;
import org.openstack.client.cli.output.OpenstackCliFormatterRegistry;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.common.OpenstackImageClient;
import org.openstack.client.storage.OpenstackStorageClient;
import org.openstack.model.common.OpenstackService;

import com.fathomdb.cli.CliContextBase;

public class OpenstackCliContext extends CliContextBase {
	final ConfigurationOptions options;

	public OpenstackCliContext(ConfigurationOptions options) throws IOException {
		super(new OpenstackCliCommandRegistry(), new OpenstackCliFormatterRegistry());

		this.options = options;
	}

	// public OpenstackSession getOpenstackSession() {
	// return options.getOpenstackSession();
	// }

	public OpenstackService getOpenstackService() {
		return options.getOpenstackService();
	}

	public OpenstackComputeClient getComputeClient() {
		return getOpenstackService().getComputeClient();
	}

	public OpenstackImageClient getImageClient() {
		return getOpenstackService().getImageClient();
	}

	public ConfigurationOptions getOptions() {
		return options;
	}

	public void connect() {
		// getComputeClient();
	}

	public static OpenstackCliContext get() {
		return (OpenstackCliContext) CliContextBase.get();
	}

	// public OpenstackStorageClient getStorageClient() {
	// return getOpenstackSession().getStorageClient();
	// }

	public OpenstackCache getCache() {
		OpenstackService service = getOpenstackService();
		OpenstackCache cache = (OpenstackCache) service.getExtensions().get(OpenstackCache.class);
		if (cache == null) {
			cache = new OpenstackCache(service);
			service.getExtensions().put(OpenstackCache.class, cache);
		}
		return cache;
	}

	public OpenstackStorageClient getStorageClient() {
		return getOpenstackService().getStorageClient();
	}

}
