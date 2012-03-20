package org.openstack.client.cli.model;

import java.util.List;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.cli.autocomplete.InstanceNameAutoCompleter;
import org.openstack.model.compute.NovaServer;
import org.openstack.model.exceptions.OpenstackException;

import com.fathomdb.cli.StringWrapper;
import com.fathomdb.cli.autocomplete.HasAutoCompletor;
import com.google.common.collect.Lists;

@HasAutoCompletor(InstanceNameAutoCompleter.class)
public class InstanceName extends StringWrapper {
	public InstanceName(String key) {
		super(key);
	}

	public String findInstanceId(OpenstackCliContext context) throws OpenstackException {
		List<NovaServer> matches = Lists.newArrayList();
		for (NovaServer instance : context.getComputeClient().publicEndpoint().servers().get().getList()) {
			if (instance.getName().equals(getKey())) {
				matches.add(instance);
			} else if (instance.getId().equals(getKey())) {
				matches.add(instance);
			}
		}

		if (matches.size() == 0)
			return null;

		if (matches.size() != 1) {
			throw new IllegalArgumentException("Instance name is ambiguous");
		}

		return matches.get(0).getId();
	}
}
