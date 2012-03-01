package org.openstack.client.cli;

import java.io.IOException;

import org.openstack.client.cli.commands.OpenstackCliCommandRegistry;
import org.openstack.client.cli.output.OpenstackCliFormatterRegistry;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.common.OpenstackImageClient;
import org.openstack.client.common.OpenstackSession;
import org.openstack.client.storage.OpenstackStorageClient;

import com.fathomdb.cli.CliContextBase;

public class OpenstackCliContext extends CliContextBase {
	final ConfigurationOptions options;

	public OpenstackCliContext(ConfigurationOptions options) throws IOException {
		super(new OpenstackCliCommandRegistry(), new OpenstackCliFormatterRegistry());

		this.options = options;
	}

	public OpenstackSession getOpenstackSession() {
		return options.getOpenstackSession();
	}

	public OpenstackComputeClient getComputeClient() {
		return getOpenstackSession().getComputeClient();
	}

	public OpenstackImageClient buildImageClient() {
		return getOpenstackSession().getImageClient();
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

	public OpenstackStorageClient getStorageClient() {
		return getOpenstackSession().getStorageClient();
	}

	public OpenstackCache getCache() {
		OpenstackSession session = getOpenstackSession();
		OpenstackCache cache = (OpenstackCache) session.extensions.get(OpenstackCache.class);
		if (cache == null) {
			cache = new OpenstackCache(session);
			session.extensions.put(OpenstackCache.class, cache);
		}
		return cache;
	}

}
