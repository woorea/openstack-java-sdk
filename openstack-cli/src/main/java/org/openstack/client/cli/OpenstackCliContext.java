package org.openstack.client.cli;

import java.io.IOException;

import org.openstack.client.OpenstackException;
import org.openstack.client.cli.commands.OpenstackCliCommandRegistry;
import org.openstack.client.cli.output.OpenstackCliFormatterRegistry;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.common.OpenstackImageClient;
import org.openstack.client.common.OpenstackSession;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.Server;

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

    public Iterable<Image> getImages() throws OpenstackException {
        OpenstackComputeClient computeClient = getComputeClient();
        return computeClient.root().images().list();
    }

    public Iterable<Server> getInstances() throws OpenstackException {
        OpenstackComputeClient computeClient = getComputeClient();
        return computeClient.root().servers().list(false);
    }

    public Iterable<Flavor> getFlavors() throws OpenstackException {
        OpenstackComputeClient computeClient = getComputeClient();
        return computeClient.root().flavors().list(false);
    }

}
