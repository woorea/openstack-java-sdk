package org.openstack.console.common.formatter;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.console.common.output.ClientAction;
import org.openstack.console.common.output.ClientActionFormatter;
import org.openstack.console.common.output.OutputSink;

import com.google.common.collect.Maps;

public class ClientActionDefaultFormatter extends SimpleFormatter<ClientAction> implements
		ClientActionFormatter<ClientAction> {

	public ClientActionDefaultFormatter() {
		super(ClientAction.class);
	}

	@Override
	public void visit(ClientAction o, OutputSink sink) throws IOException {
		LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

		values.put("action", o.getAction());
		values.put("parameter", o.getParameter());

		sink.outputRow(values);
	}

	@Override
	public ClientAction formatAction(ClientAction action) {
		return action;
	}
}
