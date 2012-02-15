package org.openstack.client.cli.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.client.extensions.Extension;
import org.openstack.client.extensions.ExtensionRegistry;
import org.openstack.client.extensions.ExtensionValues;
import org.openstack.model.compute.extensions.diskconfig.DiskConfigAttributes;
import org.openstack.model.compute.extensions.extendedstatus.ExtendedStatusAttributes;
import org.openstack.model.compute.server.Server;
import com.fathomdb.cli.formatter.SimpleFormatter;
import com.fathomdb.cli.output.OutputSink;

import com.google.common.collect.Maps;

public class ServerFormatter extends SimpleFormatter<Server> {

    public ServerFormatter() {
        super(Server.class);
    }

    @Override
    public void visit(Server o, OutputSink sink) throws IOException {
        LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

        values.put("id", o.getId());
        values.put("name", o.getName());
        values.put("status", o.getStatus());
        values.put("networks", AddressesFormatter.formatAddresses(o.getAddresses()));

        ExtensionRegistry registry = new ExtensionRegistry();
        registry.add(new Extension(DiskConfigAttributes.class));
        registry.add(new Extension(ExtendedStatusAttributes.class));

        ExtensionValues extensions = registry.parseAllExtensions(o.getExtensionData());

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
