package org.openstack.console.model;

import java.util.List;

import org.openstack.console.OpenstackCliContext;
import org.openstack.console.autocomplete.FlavorNameAutoCompleter;
import org.openstack.console.common.StringWrapper;
import org.openstack.console.common.autocomplete.HasAutoCompletor;
import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.exceptions.OpenstackException;

import com.google.common.collect.Lists;

@HasAutoCompletor(FlavorNameAutoCompleter.class)
public class FlavorName extends StringWrapper {
	public FlavorName(String key) {
		super(key);
	}

	public String findImageId(OpenstackCliContext context) throws OpenstackException {
		List<NovaFlavor> matches = Lists.newArrayList();
		for (NovaFlavor flavor : context.getComputeClient().getPublicEndpoint().flavors().get().getList()) {
			if (flavor.getName().equals(getKey())) {
				matches.add(flavor);
			} else if (flavor.getName().equals(getKey())) {
				matches.add(flavor);
			}
		}

		if (matches.size() == 0)
			return null;

		if (matches.size() != 1) {
			throw new IllegalArgumentException("Image name is ambiguous");
		}

		return matches.get(0).getId();
	}
}
