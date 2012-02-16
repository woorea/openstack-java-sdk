package org.openstack.client.cli.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.model.image.Image;
import com.fathomdb.cli.formatter.SimpleFormatter;
import com.fathomdb.cli.output.OutputSink;

import com.google.common.collect.Maps;

public class GlanceImageFormatter extends SimpleFormatter<Image> {

    public GlanceImageFormatter() {
        super(Image.class);
    }

    @Override
    public void visit(Image o, OutputSink sink) throws IOException {
        LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

        values.put("id", o.id);
        values.put("name", o.name);
        values.put("diskFormat", o.diskFormat);
        values.put("containerFormat", o.containerFormat);
        values.put("size", o.size);

        sink.outputRow(values);
    }
}
