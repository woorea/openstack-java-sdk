package org.openstack.client.cli;

import java.io.IOException;

import org.openstack.client.OpenStackClient;
import org.openstack.client.OpenStackComputeClient;
import org.openstack.client.OpenStackImagesClient;
import org.openstack.client.OpenStackStorageClient;
import org.openstack.client.cli.commands.OpenstackCliCommandRegistry;
import org.openstack.client.cli.output.OpenstackCliFormatterRegistry;

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

	public OpenStackClient getOpenstackService() {
		return options.getOpenstackService();
	}

	public OpenStackComputeClient getComputeClient() {
		return getOpenstackService().compute();
	}

	public OpenStackImagesClient getImageClient() {
		return getOpenstackService().images();
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
		OpenStackClient service = getOpenstackService();
		OpenstackCache cache = (OpenstackCache) service.getExtensions().get(OpenstackCache.class);
		if (cache == null) {
			cache = new OpenstackCache(service);
			service.getExtensions().put(OpenstackCache.class, cache);
		}
		return cache;
	}

	public OpenStackStorageClient getStorageClient() {
		return getOpenstackService().storage();
	}

}
