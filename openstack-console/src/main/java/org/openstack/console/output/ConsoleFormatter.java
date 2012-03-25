package org.openstack.console.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.console.common.formatter.SimpleFormatter;
import org.openstack.console.common.output.ClientAction;
import org.openstack.console.common.output.ClientActionFormatter;
import org.openstack.console.common.output.OutputSink;
import org.openstack.console.common.output.ClientAction.ClientActionType;
import org.openstack.model.compute.server.action.Console;

import com.google.common.collect.Maps;

public class ConsoleFormatter extends SimpleFormatter<Console> implements ClientActionFormatter<Console> {

	public ConsoleFormatter() {
		super(Console.class);
	}

	@Override
	public void visit(Console o, OutputSink sink) throws IOException {
		LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

		values.put("type", o.getType());
		values.put("url", o.getUrl());

		sink.outputRow(values);
	}

	@Override
	public ClientAction formatAction(Console object) {
		return new ClientAction(ClientActionType.BROWSER, object.getUrl());
	}

}
