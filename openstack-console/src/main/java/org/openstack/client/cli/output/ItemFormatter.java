package org.openstack.client.cli.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.model.compute.NovaMetadata.Item;

import com.fathomdb.cli.formatter.SimpleFormatter;
import com.fathomdb.cli.output.OutputSink;
import com.google.common.collect.Maps;

public class ItemFormatter extends SimpleFormatter<Item> {

    public ItemFormatter() {
        super(Item.class);
    }

    @Override
    public void visit(Item o, OutputSink sink) throws IOException {
        LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

        values.put("key", o.getKey());
        values.put("value", o.getValue());

        sink.outputRow(values);
    }

}
