package org.openstack.client.cli.autocomplete;

import java.util.List;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.model.compute.NovaSecurityGroup;

import com.fathomdb.cli.CliContext;
import com.fathomdb.cli.autocomplete.SimpleArgumentAutoCompleter;
import com.google.common.collect.Lists;

public class SecurityGroupNameAutoCompleter extends SimpleArgumentAutoCompleter {

	@Override
	public List<String> doComplete(CliContext contextObject, String prefix) throws Exception {
		List<String> strings = Lists.newArrayList();

		OpenstackCliContext context = (OpenstackCliContext) contextObject;
		for (NovaSecurityGroup securityGroup : context.getComputeClient().getPublicEndpoint().securityGroups().get().getList()) {
			strings.add(securityGroup.getName());
		}
		addSuffix(strings, " ");

		return strings;
	}

}
