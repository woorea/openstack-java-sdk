package org.openstack.console.model;

import java.util.List;

import org.openstack.console.OpenstackCliContext;
import org.openstack.console.autocomplete.SecurityGroupNameAutoCompleter;
import org.openstack.console.common.StringWrapper;
import org.openstack.console.common.autocomplete.HasAutoCompletor;
import org.openstack.model.compute.SecurityGroup;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

@HasAutoCompletor(SecurityGroupNameAutoCompleter.class)
public class SecurityGroupName extends StringWrapper {

	public SecurityGroupName(String key) {
		super(key);
	}

	public SecurityGroup resolve(OpenstackCliContext context) {
		List<SecurityGroup> matches = Lists.newArrayList();
		for (SecurityGroup candidate : context.getComputeClient().securityGroups().get().getList()) {
			if (Objects.equal(candidate.getName(), getKey())) {
				matches.add(candidate);
			} else if (Objects.equal(candidate.getId(), getKey())) {
				matches.add(candidate);
			}
		}

		if (matches.size() == 0)
			return null;

		if (matches.size() != 1) {
			throw new IllegalArgumentException("Security Group name is ambiguous");
		}

		return matches.get(0);
	}
}
