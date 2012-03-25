package org.openstack.console.autocomplete;

import java.util.List;

import org.openstack.client.StorageService;
import org.openstack.console.OpenstackCliContext;
import org.openstack.console.common.CliContext;
import org.openstack.console.common.autocomplete.SimpleArgumentAutoCompleter;
import org.openstack.model.storage.SwiftContainer;

import com.google.common.collect.Lists;

public class ContainerNameAutoCompleter extends SimpleArgumentAutoCompleter {

	@Override
	public List<String> doComplete(CliContext context, String prefix) throws Exception {
		List<String> strings = Lists.newArrayList();

		OpenstackCliContext osContext = (OpenstackCliContext) context;
		StorageService client = osContext.getStorageClient();
		Iterable<SwiftContainer> items = client.getPublicEndpoint().get();
		for (SwiftContainer item : items) {
			strings.add(item.getName());
		}
		addSuffix(strings, " ");

		return strings;
	}

}
