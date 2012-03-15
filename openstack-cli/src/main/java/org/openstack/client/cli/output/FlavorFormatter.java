package org.openstack.client.cli.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.model.compute.NovaFlavor;
import com.fathomdb.cli.formatter.SimpleFormatter;
import com.fathomdb.cli.output.OutputSink;

import com.google.common.collect.Maps;

public class FlavorFormatter extends SimpleFormatter<NovaFlavor> {

    public FlavorFormatter() {
        super(NovaFlavor.class);
    }

    @Override
    public void visit(NovaFlavor o, OutputSink sink) throws IOException {
        LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

        values.put("id", o.getId());
        values.put("name", o.getName());
        values.put("memory_mb", o.getRam());
        values.put("swap", o.swap);
        values.put("local_gb", o.getDisk());
        values.put("vcpus", o.getVcpus());
        values.put("rxtx_factor", o.getRxTxFactor());

        sink.outputRow(values);
    }
}
