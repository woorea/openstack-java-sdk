package org.openstack.client.cli.commands;

import java.util.HashMap;

import javax.ws.rs.client.Entity;

import org.kohsuke.args4j.Argument;
import org.openstack.client.ComputeService;
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
		ComputeService compute = getContext().getComputeClient();

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

		return compute.getPublicEndpoint().servers().server(instanceId).put(new HashMap<String, Object>(), Entity.json(server));
	}

}
