package org.openstack.console;

import java.io.IOException;

import org.openstack.api.compute.TenantResource;
import org.openstack.api.images.ImagesResource;
import org.openstack.api.storage.AccountResource;
import org.openstack.client.OpenStackClient;
import org.openstack.console.commands.OpenstackCliCommandRegistry;
import org.openstack.console.common.CliContextBase;
import org.openstack.console.output.OpenstackCliFormatterRegistry;


public class OpenstackCliContext extends CliContextBase {
	
	final ConfigurationOptions options;

	public OpenstackCliContext(ConfigurationOptions options) throws IOException {
		super(new OpenstackCliCommandRegistry(), new OpenstackCliFormatterRegistry());

		this.options = options;
	}

	public OpenStackClient getOpenstackService() {
		return options.getOpenstackService();
	}

	public TenantResource getComputeClient() {
		return getOpenstackService().getComputeEndpoint();
	}

	public ImagesResource getImageClient() {
		return getOpenstackService().getImagesEndpoint();
	}

	public ConfigurationOptions getOptions() {
		return options;
	}

	public static OpenstackCliContext get() {
		return (OpenstackCliContext) CliContextBase.get();
	}

	public AccountResource getStorageClient() {
		return getOpenstackService().getStorageEndpoint();
	}

}
