package org.openstack.client.cli.commands;

import org.openstack.model.common.Extension;

public class ListExtensions extends OpenstackCliCommandRunnerBase {
	public ListExtensions() {
		super("list", "extensions");
	}

	@Override
	public Object runCommand() throws Exception {
		return getCache().listItems(Extension.class, false);
	}
}
