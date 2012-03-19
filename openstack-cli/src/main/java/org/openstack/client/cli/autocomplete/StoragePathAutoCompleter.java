package org.openstack.client.cli.autocomplete;

import java.util.List;

import org.openstack.api.storage.OpenstackStorageClient;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.model.storage.SwiftContainer;
import org.openstack.model.storage.SwiftStorageObject;

import com.fathomdb.cli.CliContext;
import com.fathomdb.cli.autocomplete.SimpleArgumentAutoCompleter;
import com.google.common.collect.Lists;

public class StoragePathAutoCompleter extends SimpleArgumentAutoCompleter {

	@Override
	public List<String> doComplete(CliContext context, String prefix) throws Exception {
		List<String> strings = Lists.newArrayList();

		OpenstackCliContext osContext = (OpenstackCliContext) context;
		OpenstackStorageClient client = osContext.getStorageClient();

		if (!prefix.contains("/")) {
			Iterable<SwiftContainer> items = client.root().containers().list();
			for (SwiftContainer item : items) {
				strings.add(item.getName());
			}
			addSuffix(strings, "/");
			return strings;
		} else {
			String[] pathTokens = prefix.split("/");
			if (pathTokens.length == 1 || pathTokens.length == 2) {
				Iterable<SwiftStorageObject> items = client.root().containers().id(pathTokens[0]).objects().list();
				for (SwiftStorageObject item : items) {
					strings.add(item.getName());
				}

				addPrefix(strings, pathTokens[0] + "/");
				addSuffix(strings, " ");
				return strings;
			} else {
				return null;
			}
		}
	}

}
