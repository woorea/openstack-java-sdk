package org.openstack.console.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.console.common.formatter.SimpleFormatter;
import org.openstack.console.common.output.OutputSink;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaMetadata;

import com.google.common.collect.Maps;

public class ImageFormatter extends SimpleFormatter<NovaImage> {

	public ImageFormatter() {
		super(NovaImage.class);
	}

	@Override
	public void visit(NovaImage o, OutputSink sink) throws IOException {
		LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

		values.put("id", o.getId());
		values.put("name", o.getName());
		values.put("status", o.getStatus());
		// values.put("server", o.get.formatAddresses(o.getAddresses()));

		StringBuilder sb = new StringBuilder();
		for (NovaMetadata.Item item : o.getMetadata().getItems()) {
			if (sb.length() != 0)
				sb.append(", ");
			String value = item.getValue();
			if (value != null)
				value = value.trim();
			sb.append(item.getKey() + "=" + value);
		}

		values.put("metadata", sb.toString());

		sink.outputRow(values);
	}
}
