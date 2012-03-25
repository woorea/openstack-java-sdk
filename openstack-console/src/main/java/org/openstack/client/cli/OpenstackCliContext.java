package org.openstack.client.cli;

import java.io.IOException;

import org.openstack.client.OpenStackClient;
import org.openstack.client.ComputeService;
import org.openstack.client.ImagesService;
import org.openstack.client.StorageService;
import org.openstack.client.cli.commands.OpenstackCliCommandRegistry;
import org.openstack.client.cli.output.OpenstackCliFormatterRegistry;

import com.fathomdb.cli.CliContextBase;

public class OpenstackCliContext extends CliContextBase {
	
	final ConfigurationOptions options;

	public OpenstackCliContext(ConfigurationOptions options) throws IOException {
		super(new OpenstackCliCommandRegistry(), new OpenstackCliFormatterRegistry());

		this.options = options;
	}

	public OpenStackClient getOpenstackService() {
		return options.getOpenstackService();
	}

	public ComputeService getComputeClient() {
		return getOpenstackService().compute();
	}

	public ImagesService getImageClient() {
		return getOpenstackService().images();
	}

	public ConfigurationOptions getOptions() {
		return options;
	}

	public static OpenstackCliContext get() {
		return (OpenstackCliContext) CliContextBase.get();
	}

	public StorageService getStorageClient() {
		return getOpenstackService().storage();
	}

}
