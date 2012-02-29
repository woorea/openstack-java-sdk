package org.openstack.client.cli.model;

import org.openstack.client.cli.autocomplete.ContainerNameAutoCompleter;

import com.fathomdb.cli.StringWrapper;
import com.fathomdb.cli.autocomplete.HasAutoCompletor;

@HasAutoCompletor(ContainerNameAutoCompleter.class)
public class ContainerName extends StringWrapper {
	public ContainerName(String key) {
		super(key);
	}
}
