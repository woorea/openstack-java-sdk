package org.openstack.console.model;

import org.openstack.api.storage.AccountResource;
import org.openstack.api.storage.ObjectResource;
import org.openstack.console.autocomplete.StoragePathAutoCompleter;
import org.openstack.console.common.StringWrapper;
import org.openstack.console.common.autocomplete.HasAutoCompletor;


@HasAutoCompletor(StoragePathAutoCompleter.class)
public class StoragePath extends StringWrapper {
	public StoragePath(String key) {
		super(key);
	}

	public ObjectResource getResource(AccountResource client) {
		String containerName = getContainer();
		String objectPath = getObjectPath();
		if (containerName == null || objectPath == null) {
			throw new IllegalArgumentException("Cannot parse: " + getKey());
		}
		return client.container(containerName).object(objectPath);
	}

	public String getContainer() {
		String[] tokens = getKey().split("/");
		if (tokens.length == 0) {
			throw new IllegalArgumentException("Cannot parse: " + getKey());
		}
		return tokens[0];
	}

	public String getObjectPath() {
		String key = getKey();
		int firstSlash = key.indexOf('/');
		if (firstSlash == -1)
			return null;
		return key.substring(firstSlash + 1);
	}
}
