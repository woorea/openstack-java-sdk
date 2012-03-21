package org.openstack.client.cli.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.model.image.glance.GlanceImage;

import com.fathomdb.cli.formatter.SimpleFormatter;
import com.fathomdb.cli.output.OutputSink;
import com.google.common.collect.Maps;

public class GlanceImageFormatter extends SimpleFormatter<GlanceImage> {

    public GlanceImageFormatter() {
        super(GlanceImage.class);
    }

    @Override
    public void visit(GlanceImage o, OutputSink sink) throws IOException {
        LinkedHashMap<String, Object> values = Maps.newLinkedHashMap();

        values.put("id", o.getId());
        values.put("name", o.getName());
        values.put("diskFormat", o.getDiskFormat());
        values.put("containerFormat", o.getContainerFormat());
        values.put("size", o.getSize());

        sink.outputRow(values);
    }
}
