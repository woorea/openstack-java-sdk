package org.openstack.console.model;

import org.openstack.console.autocomplete.ContainerNameAutoCompleter;
import org.openstack.console.common.StringWrapper;
import org.openstack.console.common.autocomplete.HasAutoCompletor;


@HasAutoCompletor(ContainerNameAutoCompleter.class)
public class ContainerName extends StringWrapper {
	public ContainerName(String key) {
		super(key);
	}
}
