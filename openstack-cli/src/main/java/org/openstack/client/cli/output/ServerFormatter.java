package org.openstack.client.cli.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.api.extensions.Extension;
import org.openstack.api.extensions.ExtensionRegistry;
import org.openstack.api.extensions.ExtensionValues;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.model.common.OpenstackService;
import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaServer;
import org.openstack.model.compute.extensions.diskconfig.DiskConfigAttributes;
import org.openstack.model.compute.extensions.extendedstatus.ExtendedStatusAttributes;

import com.fathomdb.cli.formatter.SimpleFormatter;
import com.fathomdb.cli.output.OutputSink;
import com.google.common.collect.Maps;

public class ServerFormatter extends SimpleFormatter<NovaServer> {

	public ServerFormatter() {
		super(NovaServer.class);
	}

	@Override
	public void visit(NovaServer server, OutputSink sink) throws IOException {
		LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

		OpenstackService service = OpenstackCliContext.get().getOpenstackService();

		NovaFlavor flavor = service.resolveFlavor(server.getFlavor());
		String flavorName = null;
		if (flavor != null) {
			flavorName = flavor.getName();
		}

		NovaImage image = service.resolveImage(server.getImage());
		String imageName = null;
		if (image != null) {
			imageName = image.getName();
		}

		values.put("id", server.getId());
		values.put("flavor", flavorName);
		values.put("image", imageName);
		values.put("name", server.getName());
		values.put("status", server.getStatus());
		values.put("networks", AddressesFormatter.formatAddresses(server.getAddresses()));

		ExtensionRegistry registry = new ExtensionRegistry();
		registry.add(new Extension(DiskConfigAttributes.class));
		registry.add(new Extension(ExtendedStatusAttributes.class));

		ExtensionValues extensions = registry.parseAllExtensions(server.getExtensionAttributes());

		{
			DiskConfigAttributes attributes = extensions.get(DiskConfigAttributes.class);
			values.put("disk", attributes);
		}

		{
			ExtendedStatusAttributes attributes = extensions.get(ExtendedStatusAttributes.class);
			values.put("extstatus", attributes);
		}

		sink.outputRow(values);
	}
}
