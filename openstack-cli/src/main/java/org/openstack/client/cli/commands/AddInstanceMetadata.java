package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.OpenstackComputeClient;
import org.openstack.client.cli.model.InstanceName;
import org.openstack.model.compute.NovaMetadata;
import org.openstack.model.compute.NovaMetadata.Item;
import org.openstack.model.compute.NovaServer;

public class AddInstanceMetadata extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName instanceName;

	@Argument(index = 1)
	public String key;

	@Argument(index = 2)
	public String value;

	public AddInstanceMetadata() {
		super("add", "instancemetadata");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackComputeClient compute = getContext().getComputeClient();

		String instanceId = instanceName.findInstanceId(getContext());

		NovaServer server = new NovaServer();
		NovaMetadata metadata = server.getMetadata();
		if (metadata == null) {
			metadata = new NovaMetadata();
			server.setMetadata(metadata);
		}
		Item item = new Item();
		item.setKey(key);
		item.setValue(value);
		metadata.getItems().add(item);

		return compute.root().servers().server(instanceId).update(server);
	}

}
