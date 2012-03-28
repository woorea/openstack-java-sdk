package org.openstack.console.autocomplete;

import java.util.List;

import org.openstack.api.storage.AccountResource;
import org.openstack.console.OpenstackCliContext;
import org.openstack.console.common.CliContext;
import org.openstack.console.common.autocomplete.SimpleArgumentAutoCompleter;
import org.openstack.model.storage.StorageContainer;
import org.openstack.model.storage.swift.SwiftContainer;

import com.google.common.collect.Lists;

public class ContainerNameAutoCompleter extends SimpleArgumentAutoCompleter {

	@Override
	public List<String> doComplete(CliContext context, String prefix) throws Exception {
		List<String> strings = Lists.newArrayList();

		OpenstackCliContext osContext = (OpenstackCliContext) context;
		AccountResource client = osContext.getStorageClient();
		Iterable<StorageContainer> items = client.get();
		for (StorageContainer item : items) {
			strings.add(item.getName());
		}
		addSuffix(strings, " ");

		return strings;
	}

}
