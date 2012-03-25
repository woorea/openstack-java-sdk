package org.openstack.console.common.formatter;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.console.common.output.OutputSink;


import com.google.common.collect.Maps;

public class StringFormatter extends SimpleFormatter<String> {

    public StringFormatter() {
        super(String.class);
    }

    @Override
    public void visit(String o, OutputSink sink) throws IOException {
        LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

        values.put("value", o);

        sink.outputRow(values);
    }
}
