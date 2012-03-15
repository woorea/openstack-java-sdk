package org.openstack.client.cli.commands;

import org.openstack.model.compute.NovaFlavor;

public class ListFlavors extends OpenstackCliCommandRunnerBase {
	public ListFlavors() {
		super("list", "flavors");
	}

	@Override
	public Object runCommand() throws Exception {
		return getCache().listItems(NovaFlavor.class, false);
	}

}
