package org.openstack.client.cli;

import java.io.IOException;

import org.openstack.client.OpenstackException;
import org.openstack.client.cli.commands.OpenstackCliCommandRegistry;
import org.openstack.client.cli.output.OpenstackCliFormatterRegistry;
import org.openstack.client.common.OpenstackClient;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.common.OpenstackImageClient;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.server.Server;

import com.fathomdb.cli.CliContextBase;

public class OpenstackCliContext extends CliContextBase {
    final ConfigurationOptions options;
    OpenstackComputeClient computeClient;
    OpenstackImageClient glanceClient;

    public OpenstackCliContext(ConfigurationOptions options) throws IOException {
        super(new OpenstackCliCommandRegistry(), new OpenstackCliFormatterRegistry());

        this.options = options;
    }

    public OpenstackClient getOpenstackClient() {
        return options.getOpenstackClient();
    }

    public synchronized OpenstackComputeClient getComputeClient() {
        if (computeClient == null) {
            try {
                computeClient = options.buildComputeClient();
            } catch (OpenstackException e) {
                throw new IllegalArgumentException("Error connecting to OpenStack", e);
            }
        }
        return computeClient;
    }

    public synchronized OpenstackImageClient buildImageClient() {
        if (glanceClient == null) {
            try {
                glanceClient = options.buildImageClient();
            } catch (OpenstackException e) {
                throw new IllegalArgumentException("Error connecting to OpenStack", e);
            }
        }
        return glanceClient;
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

    public Iterable<Image> getImages() throws OpenstackException {
        OpenstackComputeClient computeClient = getComputeClient();
        return computeClient.root().images().list().asModels();
    }

    public Iterable<Server> getInstances() throws OpenstackException {
        OpenstackComputeClient computeClient = getComputeClient();
        return computeClient.root().servers().list(false).asModels();
    }

    public Iterable<Flavor> getFlavors() throws OpenstackException {
        OpenstackComputeClient computeClient = getComputeClient();
        return computeClient.root().flavors().list(false).asModels();
    }

}
