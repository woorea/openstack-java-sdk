package org.openstack.client.cli.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.model.compute.FloatingIp;

import com.fathomdb.cli.formatter.SimpleFormatter;
import com.fathomdb.cli.output.OutputSink;
import com.google.common.collect.Maps;

public class FloatingIpFormatter extends SimpleFormatter<FloatingIp> {

    public FloatingIpFormatter() {
        super(FloatingIp.class);
    }

    @Override
    public void visit(FloatingIp o, OutputSink sink) throws IOException {
        LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

        values.put("id", o.getId());
        values.put("ip", o.getIp());
        values.put("pool", o.getPool());

        sink.outputRow(values);
    }
}
