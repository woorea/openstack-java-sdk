package org.openstack.client.cli.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.model.storage.StorageObject;

import com.fathomdb.cli.formatter.SimpleFormatter;
import com.fathomdb.cli.output.OutputSink;
import com.google.common.collect.Maps;

public class StorageObjectFormatter extends SimpleFormatter<StorageObject> {

	public StorageObjectFormatter() {
		super(StorageObject.class);
	}

	@Override
	public void visit(StorageObject o, OutputSink sink) throws IOException {
		LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

		values.put("name", o.getName());
		values.put("bytes", o.getBytes());
		values.put("hash", o.getHash());
		values.put("contentType", o.getContentType());

		sink.outputRow(values);
	}

}
