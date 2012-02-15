package com.fathomdb.cli.formatter;

import java.io.IOException;
import java.util.List;

import com.fathomdb.cli.output.OutputSink;

public interface Formatter {
    List<Class<?>> getHandledClasses();

    void visitObject(Object o, OutputSink sink) throws IOException;
}
