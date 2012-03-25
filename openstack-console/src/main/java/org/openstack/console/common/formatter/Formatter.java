package org.openstack.console.common.formatter;

import java.io.IOException;
import java.util.List;

import org.openstack.console.common.output.OutputSink;


public interface Formatter {
    List<Class<?>> getHandledClasses();

    void visitObject(Object o, OutputSink sink) throws IOException;
}
