package com.fathomdb.cli.formatter;

import java.io.IOException;
import java.util.List;


import com.fathomdb.Casts;
import com.fathomdb.cli.output.OutputSink;
import com.google.common.collect.Lists;

public abstract class SimpleFormatter<T> implements Formatter {
    final Class<T> clazz;

    public SimpleFormatter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public List<Class<?>> getHandledClasses() {
        List<Class<?>> classes = Lists.newArrayList();
        classes.add(clazz);
        return classes;
    }

    @Override
    public void visitObject(Object o, OutputSink sink) throws IOException {
        visit(Casts.checkedCast(o, clazz), sink);
    }

    public abstract void visit(T o, OutputSink sink) throws IOException;

}
