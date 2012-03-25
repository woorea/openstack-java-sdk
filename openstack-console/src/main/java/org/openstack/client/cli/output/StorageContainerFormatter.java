package org.openstack.client.cli.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.model.storage.SwiftContainer;

import com.fathomdb.cli.formatter.SimpleFormatter;
import com.fathomdb.cli.output.OutputSink;
import com.google.common.collect.Maps;

public class StorageContainerFormatter extends SimpleFormatter<SwiftContainer> {

	public StorageContainerFormatter() {
		super(SwiftContainer.class);
	}

	@Override
	public void visit(SwiftContainer o, OutputSink sink) throws IOException {
		LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

		values.put("name", o.getName());
		values.put("count", o.getCount());
		values.put("bytes", o.getBytes());

		sink.outputRow(values);
	}

}
