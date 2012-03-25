package org.openstack.console.common;

import java.io.PrintWriter;

import org.openstack.console.common.output.ActionOutputSink;
import org.openstack.console.common.output.OutputSink;
import org.openstack.console.common.output.RawOutputSink;
import org.openstack.console.common.output.TextOutputSink;


public enum OutputFormat {
    Text, Xml, Json, Raw, Action;

    public OutputSink buildOutputSink(CliContext context, PrintWriter out) {
        switch (this) {
        case Json:
            throw new UnsupportedOperationException("JSON format not yet implemented");
        case Xml:
            throw new UnsupportedOperationException("XML format not yet implemented");
//                    return new XmlOutputSink(out);
        case Text:
            return new TextOutputSink(context.getFormatterRegistry(), out, true);
        case Raw:
            return new RawOutputSink(out);
        case Action:
            return new ActionOutputSink(context.getFormatterRegistry(), out);
        default:
            throw new IllegalStateException();
        }
    }
}