package org.openstack.console.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.console.common.formatter.SimpleFormatter;
import org.openstack.console.common.output.OutputSink;
import org.openstack.model.storage.SwiftStorageObject;

import com.google.common.collect.Maps;

public class StorageObjectFormatter extends SimpleFormatter<SwiftStorageObject> {

	public StorageObjectFormatter() {
		super(SwiftStorageObject.class);
	}

	@Override
	public void visit(SwiftStorageObject o, OutputSink sink) throws IOException {
		LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

		values.put("name", o.getName());
		values.put("bytes", o.getBytes());
		values.put("hash", o.getHash());
		values.put("contentType", o.getContentType());

		sink.outputRow(values);
	}

}
