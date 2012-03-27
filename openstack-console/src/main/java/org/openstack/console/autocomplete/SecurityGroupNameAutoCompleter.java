package org.openstack.console.autocomplete;

import java.util.List;

import org.openstack.console.OpenstackCliContext;
import org.openstack.console.common.CliContext;
import org.openstack.console.common.autocomplete.SimpleArgumentAutoCompleter;
import org.openstack.model.compute.SecurityGroup;

import com.google.common.collect.Lists;

public class SecurityGroupNameAutoCompleter extends SimpleArgumentAutoCompleter {

	@Override
	public List<String> doComplete(CliContext contextObject, String prefix) throws Exception {
		List<String> strings = Lists.newArrayList();

		OpenstackCliContext context = (OpenstackCliContext) contextObject;
		for (SecurityGroup securityGroup : context.getComputeClient().securityGroups().get().getList()) {
			strings.add(securityGroup.getName());
		}
		addSuffix(strings, " ");

		return strings;
	}

}
