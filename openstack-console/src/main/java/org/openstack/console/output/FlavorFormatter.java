package org.openstack.console.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.console.common.formatter.SimpleFormatter;
import org.openstack.console.common.output.OutputSink;
import org.openstack.model.compute.NovaFlavor;

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
        values.put("swap", o.getSwap());
        values.put("local_gb", o.getDisk());
        values.put("vcpus", o.getVcpus());
        values.put("rxtx_factor", o.getRxTxFactor());

        sink.outputRow(values);
    }
}
