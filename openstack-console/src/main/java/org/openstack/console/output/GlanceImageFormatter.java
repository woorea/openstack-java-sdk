package org.openstack.console.output;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openstack.console.common.formatter.SimpleFormatter;
import org.openstack.console.common.output.OutputSink;
import org.openstack.model.images.glance.GlanceImage;

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
