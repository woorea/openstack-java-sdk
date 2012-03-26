package org.openstack.console.autocomplete;

import java.util.List;

import org.openstack.console.OpenstackCliContext;
import org.openstack.console.common.CliContext;
import org.openstack.console.common.autocomplete.SimpleArgumentAutoCompleter;
import org.openstack.model.compute.NovaServer;

import com.google.common.collect.Lists;

public class InstanceNameAutoCompleter extends SimpleArgumentAutoCompleter {

	@Override
	public List<String> doComplete(CliContext contextObject, String prefix) throws Exception {
		List<String> strings = Lists.newArrayList();

		OpenstackCliContext context = (OpenstackCliContext) contextObject;
		for (NovaServer server : context.getComputeClient().servers().get().getList()) {
			strings.add(server.getId());
			strings.add(server.getName());
		}
		addSuffix(strings, " ");

		return strings;
	}

}
