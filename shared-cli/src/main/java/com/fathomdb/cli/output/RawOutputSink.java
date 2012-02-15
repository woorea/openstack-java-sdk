package com.fathomdb.cli.output;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class RawOutputSink implements OutputSink {

    private final PrintWriter out;

    public RawOutputSink(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void visitObject(Object o) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void outputRow(Map<String, Object> values) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void flush() {
        out.flush();
    }

    @Override
    public void finishOutput() {
    }

    public PrintWriter getWriter() {
        return out;
    }

}
