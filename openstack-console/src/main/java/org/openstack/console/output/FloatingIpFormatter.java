package org.openstack.console.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.console.common.formatter.SimpleFormatter;
import org.openstack.console.common.output.OutputSink;
import org.openstack.model.compute.NovaFloatingIp;

import com.google.common.collect.Maps;

public class FloatingIpFormatter extends SimpleFormatter<NovaFloatingIp> {

	public FloatingIpFormatter() {
		super(NovaFloatingIp.class);
	}

	@Override
	public void visit(NovaFloatingIp o, OutputSink sink) throws IOException {
		LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

		values.put("id", o.getId());
		values.put("ip", o.getIp());
		values.put("pool", o.getPool());
		values.put("instance", o.getInstanceId());

		sink.outputRow(values);
	}
}
