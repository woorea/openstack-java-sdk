package org.openstack.client.cli;

import java.io.IOException;
import java.util.List;

import org.openstack.client.cli.commands.OpenstackCliCommandRegistry;
import org.openstack.client.cli.output.OpenstackCliFormatterRegistry;
import org.openstack.client.common.OpenstackImageClient;
import org.openstack.client.compute.TenantResource;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.server.Server;
import com.fathomdb.cli.CliContextBase;

public class OpenstackCliContext extends CliContextBase {
    final ConfigurationOptions options;
    TenantResource computeClient;
    OpenstackImageClient glanceClient;
    
    public OpenstackCliContext(ConfigurationOptions options) throws IOException {
        super(new OpenstackCliCommandRegistry(), new OpenstackCliFormatterRegistry());

        this.options = options;
    }

    public synchronized TenantResource getComputeClient() {
        if (computeClient == null) {
            try {
                computeClient = options.buildComputeClient();
            } catch (IOException e) {
                throw new IllegalArgumentException("Error connecting to OpenStack", e);
            }
        }
        return computeClient;
    }

    public synchronized OpenstackImageClient buildImageClient() {
        if (glanceClient == null) {
            try {
            	glanceClient = options.buildImageClient();
            } catch (IOException e) {
                throw new IllegalArgumentException("Error connecting to OpenStack", e);
            }
        }
        return glanceClient;
    }

    
    public ConfigurationOptions getOptions() {
        return options;
    }

    public void connect()  {
    	// getComputeClient();
    }

    public static OpenstackCliContext get() {
        return (OpenstackCliContext) CliContextBase.get();
    }

    public List<Image> getImages() {
        TenantResource computeClient = getComputeClient();
        return computeClient.images().list().getList();
    }

    public List<Server> getInstances() {
        TenantResource computeClient = getComputeClient();
        return computeClient.servers().list(false).getList();
    }

    public List<Flavor> getFlavors() {
        TenantResource computeClient = getComputeClient();
        return computeClient.flavors().list().getList();
    }

}
