package org.openstack.console.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.compute.TenantResource;
import org.openstack.console.model.InstanceName;
import org.openstack.model.compute.Metadata;
import org.openstack.model.compute.nova.NovaMetadata;
import org.openstack.model.compute.nova.NovaMetadata.Item;
import org.openstack.model.compute.nova.NovaServer;

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
		TenantResource compute = getContext().getComputeClient();

		String instanceId = instanceName.findInstanceId(getContext());

		NovaServer server = new NovaServer();
		Metadata metadata = server.getMetadata();
		if (metadata == null) {
			metadata = new NovaMetadata();
			server.setMetadata((NovaMetadata) metadata);
		}
		Item item = new Item();
		item.setKey(key);
		item.setValue(value);
		metadata.getItems().add(item);

		return compute.servers().server(instanceId).put(server);
	}

}
