package org.openstack.client.cli.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.model.compute.server.action.Console;

import com.fathomdb.cli.formatter.SimpleFormatter;
import com.fathomdb.cli.output.ClientAction;
import com.fathomdb.cli.output.ClientActionFormatter;
import com.fathomdb.cli.output.OutputSink;
import com.fathomdb.cli.output.ClientAction.ClientActionType;
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
