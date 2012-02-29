package org.openstack.client.cli.model;

import org.openstack.client.cli.autocomplete.StoragePathAutoCompleter;
import org.openstack.client.storage.ObjectResource;
import org.openstack.client.storage.OpenstackStorageClient;

import com.fathomdb.cli.StringWrapper;
import com.fathomdb.cli.autocomplete.HasAutoCompletor;

@HasAutoCompletor(StoragePathAutoCompleter.class)
public class StoragePath extends StringWrapper {
	public StoragePath(String key) {
		super(key);
	}

	public ObjectResource getResource(OpenstackStorageClient client) {
		String[] tokens = getKey().split("/");
		if (tokens.length != 2) {
			throw new IllegalArgumentException("Cannot parse: " + getKey());
		}
		return client.root().containers().id(tokens[0]).objects().id(tokens[1]);
	}
}
