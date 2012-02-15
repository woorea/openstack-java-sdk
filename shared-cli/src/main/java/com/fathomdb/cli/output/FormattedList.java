package com.fathomdb.cli.output;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;


import com.fathomdb.cli.formatter.FormatterRegistry;
import com.google.common.collect.Lists;

public class FormattedList<T> extends ArrayList<T> {
    private static final long serialVersionUID = 1L;
    private final FormatterRegistry registry;

    final boolean decorate;

    public FormattedList(FormatterRegistry registry, Iterable<T> items, boolean decorate) {
        super(Lists.newArrayList(items));
        this.registry = registry;
        this.decorate = decorate;
    }

    public FormattedList(FormatterRegistry registry, boolean decorate) {
        this(registry, Collections.<T> emptyList(), decorate);
    }

    public static <T> FormattedList<T> build(FormatterRegistry registry, Iterable<T> items, boolean decorate) {
        return new FormattedList<T>(registry, items, decorate);
    }

    @Override
    public String toString() {
        Writer writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);
        TextOutputSink sink = new TextOutputSink(registry, out, decorate);

        try {
            for (T item : this) {
                sink.visitObject(item);
            }
            sink.finishOutput();
        } catch (IOException e) {
            throw new IllegalArgumentException("Error formatting list", e);
        }

        return writer.toString();
    }

}
