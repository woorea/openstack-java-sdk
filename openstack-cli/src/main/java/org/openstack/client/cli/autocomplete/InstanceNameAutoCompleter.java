package org.openstack.client.cli.autocomplete;

import java.util.List;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.model.compute.NovaServer;

import com.fathomdb.cli.CliContext;
import com.fathomdb.cli.autocomplete.SimpleArgumentAutoCompleter;
import com.google.common.collect.Lists;

public class InstanceNameAutoCompleter extends SimpleArgumentAutoCompleter {

	@Override
	public List<String> doComplete(CliContext contextObject, String prefix) throws Exception {
		List<String> strings = Lists.newArrayList();

		OpenstackCliContext context = (OpenstackCliContext) contextObject;
		for (NovaServer server : context.getComputeClient().getPublicEndpoint().servers().get().getList()) {
			strings.add(server.getId());
			strings.add(server.getName());
		}
		addSuffix(strings, " ");

		return strings;
	}

}
