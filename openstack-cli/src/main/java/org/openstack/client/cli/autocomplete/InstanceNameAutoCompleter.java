package org.openstack.client.cli.autocomplete;

import java.util.List;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.compute.TenantResource;
import org.openstack.model.compute.Server;

import com.fathomdb.cli.CliContext;
import com.fathomdb.cli.autocomplete.SimpleArgumentAutoCompleter;

import com.google.common.collect.Lists;

public class InstanceNameAutoCompleter extends SimpleArgumentAutoCompleter {

    @Override
    public List<String> doComplete(CliContext context, String prefix) throws Exception {
        List<String> strings = Lists.newArrayList();

        OpenstackCliContext osContext = (OpenstackCliContext) context;
        OpenstackComputeClient computeClient = osContext.getComputeClient();
        List<Server> servers = computeClient.root().servers().list(false).getList();
        for (Server server : servers) {
            strings.add(server.getId());
            strings.add(server.getName());
        }
        addSuffix(strings, " ");

        return strings;
    }

}
