package org.openstack.console.common.formatter;

import java.io.IOException;
import java.util.List;

import org.openstack.console.common.output.OutputSink;

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
        visit(clazz.cast(o), sink);
    }

    public abstract void visit(T o, OutputSink sink) throws IOException;

}
