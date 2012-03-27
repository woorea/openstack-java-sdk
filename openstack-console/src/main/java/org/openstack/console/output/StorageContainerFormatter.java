package org.openstack.console.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.console.common.formatter.SimpleFormatter;
import org.openstack.console.common.output.OutputSink;
import org.openstack.model.storage.StorageContainer;
import org.openstack.model.storage.swift.SwiftContainer;

import com.google.common.collect.Maps;

public class StorageContainerFormatter extends SimpleFormatter<StorageContainer> {

	public StorageContainerFormatter() {
		super(SwiftContainer.class);
	}

	@Override
	public void visit(StorageContainer o, OutputSink sink) throws IOException {
		LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

		values.put("name", o.getName());
		values.put("count", o.getCount());
		values.put("bytes", o.getBytes());

		sink.outputRow(values);
	}

}
