package org.openstack.client.cli;

import java.io.IOException;

import org.openstack.client.cli.commands.OpenstackCliCommandRegistry;
import org.openstack.client.cli.output.OpenstackCliFormatterRegistry;
import org.openstack.client.jersey2.OpenStackClient;
import org.openstack.client.jersey2.OpenStackComputeClient;
import org.openstack.client.jersey2.OpenStackImagesClient;
import org.openstack.client.jersey2.OpenStackStorageClient;

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

	public OpenStackComputeClient getComputeClient() {
		return getOpenstackService().compute();
	}

	public OpenStackImagesClient getImageClient() {
		return getOpenstackService().images();
	}

	public ConfigurationOptions getOptions() {
		return options;
	}

	public static OpenstackCliContext get() {
		return (OpenstackCliContext) CliContextBase.get();
	}

	public OpenStackStorageClient getStorageClient() {
		return getOpenstackService().storage();
	}

}
